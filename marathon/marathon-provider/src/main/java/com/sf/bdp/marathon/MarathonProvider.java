package com.sf.bdp.marathon;

import com.sf.bdp.marathon.manager.GroupManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class MarathonProvider {

	static final Logger LOG = LoggerFactory.getLogger(MarathonProvider.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		GroupManager groupManager = applicationContext.getBean(GroupManager.class);
		SchedulerTaskExecutor.getInstance().execute(groupManager,100,1000,MILLISECONDS);
		while (true) {
			try {
				Thread.sleep(2000L);
			} catch (Exception e) {
				LOG.error("start MarathonProvider failed", e);
			}
		}
	}
}
