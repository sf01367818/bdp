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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 01369308 on 2017/12/15.
 */
@Controller
@RequestMapping(value = "groupQrcode", produces = "application/json; charset=UTF-8")
public class QRCodeController {

    private static final Logger logger = Logger.getLogger(QRCodeController.class);

    @RequestMapping("get")
    @ResponseBody
    public void get(String groupId, HttpServletResponse response) throws IOException, WriterException {
        logger.info("groupID:" + groupId);
        String url = "http://112.74.61.163:8080/marathon-control/group/getGroupDetail?groupId=" + groupId;
        logger.info("url:" + url);
        String filePath = "/data/controller/";
        String logoPath = filePath + "pics/logo.png";
        String qrCodePath = filePath + "pics/group_" + groupId + "_qrcode.png";
        QRCodeCreater.getInstance().createQRCode(url, logoPath, qrCodePath);
        response.setContentType("image/png");
        OutputStream outputStream = response.getOutputStream();
        IOUtils.write(new FileInputStream(qrCodePath), outputStream, 1024);
    }
}
