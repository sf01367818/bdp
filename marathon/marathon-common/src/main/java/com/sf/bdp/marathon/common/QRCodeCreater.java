package com.sf.bdp.marathon.common;

import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;

/**
 * Created by 01369308 on 2017/12/15.
 */
public final class QRCodeCreater {
    private QRCodeCreater() {}
    private static final QRCodeCreater instance = new QRCodeCreater();

    public static QRCodeCreater getInstance() {
        return instance;
    }

    public void createQRCode(String context, String logoPath, String qrCodePath, boolean needCompress,int qrcodeSize) throws IOException, WriterException {
        if(!new File(qrCodePath).exists()) {
            QRCodeUtil.encode(context, logoPath, qrCodePath, needCompress, qrcodeSize);
        }
    }
}
