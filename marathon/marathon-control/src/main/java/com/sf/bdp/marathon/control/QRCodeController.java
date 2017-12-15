package com.sf.bdp.marathon.control;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.google.zxing.WriterException;
import com.sf.bdp.marathon.common.QRCodeCreater;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by 01369308 on 2017/12/15.
 */
@Controller
@RequestMapping(value = "groupQrcode", produces = "application/json; charset=UTF-8")
public class QRCodeController {

    private static final Logger logger = Logger.getLogger(QRCodeController.class);

    @RequestMapping("get")
    @ResponseBody
    public void get(String mktId, HttpServletResponse response) throws IOException, WriterException {
        logger.info("mktId:" + mktId);
        Properties properties = new Properties();
        String url = "http://" + properties.getProperty("host_port", "112.74.61.163:8080") + "/marathon-control?mktId=" + mktId;
        logger.info("url:" + url);
        String qrCodePath = "/data/controller/pics/group_" + mktId + "_qrcode.png";
        QRCodeCreater.getInstance().createQRCode(url, "/data/controller/pics/logo.png", qrCodePath, true, 600);
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        IOUtils.write(new FileInputStream(qrCodePath), outputStream, 1024);
    }
}
