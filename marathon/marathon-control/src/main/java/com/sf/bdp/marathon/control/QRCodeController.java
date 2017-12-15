package com.sf.bdp.marathon.control;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.sf.bdp.marathon.common.QRCodeCreater;
import com.sf.bdp.marathon.common.bean.Response;
import com.sf.bdp.marathon.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * Created by 01369308 on 2017/12/15.
 */
@Controller
@RequestMapping(value = "group/qrcode", produces = "application/json; charset=UTF-8")
public class QRCodeController {

    private static final Logger logger = Logger.getLogger(QRCodeController.class);
    @RequestMapping("get")
    @ResponseBody
    public void get(@PathVariable String group_id, HttpServletResponse response) {
        logger.info("group_id:" + group_id);
        String url = "http://112.74.61.163:8080/group/group_id=" + group_id;
        try {
            String filePath = QRCodeController.class.getResource("/").toString();
            String logoPath = filePath + "pics/logo.png";
            String qrCodePath = filePath + "pics/group_" + group_id + "_qrcode.png";
            QRCodeCreater.getInstance().createQRCode(url, logoPath, qrCodePath);
            response.setContentType("image/png");
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(new FileInputStream(qrCodePath), outputStream, 1024);
        } catch (Exception e) {
            logger.info(e);
        }
    }
}
