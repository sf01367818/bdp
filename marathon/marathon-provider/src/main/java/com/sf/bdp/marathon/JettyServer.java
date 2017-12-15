package com.sf.bdp.marathon;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NCSARequestLog;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 
 * Jetty启动类
 * @author 01235599
 * date: 2017年11月8日 下午7:58:41
 */
public class JettyServer implements ApplicationContextAware {
	
	private static final Logger LOG = LoggerFactory.getLogger(JettyServer.class);
	
	private static final String WEB_XML = "META-INF/WEB-INF/web.xml";
    private static final String WEB_WAR_PATH = "src/main/webapp";
    
	private Integer port = 8080;
	private Integer minThreads=10;
	private Integer maxThreads=20;
	private String webappBaseTempdir = null;
	private String requestLog = null;
	
	private Server server;
	
	private ApplicationContext applicationContext;
	
	/**
	 * 实现ApplicationContextAware接口 ,自动注入applicationContext
	 */
	@Override  
	public void setApplicationContext(ApplicationContext applicationContext) {  
		this.applicationContext = applicationContext;  
	}
	
	/**
	 * 初始化方法
	 * @throws Exception
	 */
	public void start() throws Exception
	{
		server = new Server();
        server.setThreadPool(createThreadPool());
        server.addConnector(createConnector());
        server.setHandler(createHandlers());        
        server.setStopAtShutdown(true);
        server.start();
	}
	
	public void stop() throws Exception
	{
		server.stop();
	}
	
	/**
	 * 创建WebContext
	 * @return
	 */
	private HandlerCollection createHandlers()
    {                
		WebAppContext webAppContext = new WebAppContext();
        webAppContext .setContextPath("/");
        if(isRunningInShadedJar()){
            webAppContext.setWar(getShadedWarUrl());
        }
        else{            
            webAppContext.setWar(WEB_WAR_PATH);
        }
        XmlWebApplicationContext xmlWebAppContext = new XmlWebApplicationContext();
        xmlWebAppContext.setParent(applicationContext);  
        xmlWebAppContext.setConfigLocation("");  
        xmlWebAppContext.setServletContext(webAppContext.getServletContext());  
        xmlWebAppContext.refresh();  
        webAppContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,xmlWebAppContext);
        if(StringUtils.isNotBlank(webappBaseTempdir)){
        	String baseTempDir = webappBaseTempdir+File.separator+this.port;
        	File baseTempDirectory = new File(baseTempDir);
        	if(!baseTempDirectory.exists()){
        		try {
					FileUtils.forceMkdir(baseTempDirectory);
				} catch (IOException e) {
					LOG.error("make dir error",e);
				}
        	}
        	webAppContext.setAttribute("org.eclipse.jetty.webapp.basetempdir", baseTempDir);
        }
        
        List<Handler> handlers = new ArrayList<>();        
        handlers.add(webAppContext);
        
        if(StringUtils.isNotBlank(requestLog)){
        	RequestLogHandler logHandler = new RequestLogHandler();
        	logHandler.setRequestLog(createRequestLog());
        	handlers.add(logHandler);
        }
        
        HandlerCollection ret = new HandlerCollection();
        ret.setHandlers(handlers.toArray(new Handler[0]));
        return ret;
    }

	private SelectChannelConnector createConnector()
    {
        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(port);
        return connector;
    }
	
	private ThreadPool createThreadPool() {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setMinThreads(minThreads);
        threadPool.setMaxThreads(maxThreads);
        return threadPool;
	}

	private RequestLog createRequestLog()
    {
        NCSARequestLog reqLog = new NCSARequestLog();        
    	File requestLogFile = new File(requestLog);
    	requestLogFile.getParentFile().mkdirs();     
        reqLog.setFilename(requestLogFile.getPath());
        reqLog.setRetainDays(90);
        reqLog.setExtended(false);
        reqLog.setAppend(true);
        reqLog.setLogTimeZone("GMT");
        reqLog.setLogLatency(true);
        return reqLog;
    }
		
		
	private boolean isRunningInShadedJar()
    {
    	String className = this.getClass().getName().replace('.', '/');
    	String classJar =  this.getClass().getResource("/" + className + ".class").toString();
    	LOG.info(classJar);
    	return classJar.startsWith("jar:");
    }
    
    private URL getResource(String aResource)
    {
        return Thread.currentThread().getContextClassLoader().getResource(aResource); 
    }
    
    private String getShadedWarUrl()
    {
    	LOG.info("Load config: {}",WEB_XML);
        String urlStr = getResource(WEB_XML).toString();
        return urlStr.substring(0, urlStr.length() - 15);
    }

	public void setMinThreads(Integer minThreads) {
		this.minThreads = minThreads;
	}
	public void setMaxThreads(Integer maxThreads) {
		this.maxThreads = maxThreads;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public void setWebappBaseTempdir(String webappBaseTempdir) {
		this.webappBaseTempdir = webappBaseTempdir;
	}
	public void setRequestLog(String requestLog) {
		this.requestLog = requestLog;
	}
}
