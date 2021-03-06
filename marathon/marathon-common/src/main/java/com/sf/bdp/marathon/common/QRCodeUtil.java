package com.sf.bdp.marathon.common;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumMap;

/**
 * Created by 01369308 on 2017/12/15.
 */
public class QRCodeUtil {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "PNG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 200;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    private QRCodeUtil() {}

    private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress) throws IOException, WriterException {
        return createImage(content,  imgPath, needCompress,QRCODE_SIZE);
    }
    private static BufferedImage createImage(String content, String imgPath,
                                             boolean needCompress,int qrcodeSize) throws WriterException, IOException {
    	EnumMap<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        hints.put(EncodeHintType.QR_VERSION, 10);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, qrcodeSize, qrcodeSize, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        if (imgPath == null || "".equals(imgPath)) {
            return image;
        }
        // 插入图片
        QRCodeUtil.insertImage(image, imgPath, needCompress,qrcodeSize);
        return image;
    }
    /**
     * 插入LOGO
     *
     * @param source
     *            二维码图片
     * @param imgPath
     *            LOGO图片地址
     * @param needCompress
     *            是否压缩
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String imgPath,
                                    boolean needCompress,int qrcodeSize) throws IOException {
        File file = new File(imgPath);
        if (!file.exists()) {
            return;
        }
        Image src = ImageIO.read(new File(imgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > qrcodeSize/QRCODE_SIZE*WIDTH) {
                width = (int) ((double)qrcodeSize/QRCODE_SIZE*WIDTH);
            }
            if (height > qrcodeSize/QRCODE_SIZE*HEIGHT) {
                height = (int) ((double)qrcodeSize/QRCODE_SIZE*HEIGHT);
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (qrcodeSize - width) / 2;
        int y = (qrcodeSize - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param imgPath
     *            LOGO地址
     * @param destPath
     *            存储地址
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath,
                              boolean needCompress) throws IOException, WriterException {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
        FileUtils.forceMkdir(new File(destPath).getParentFile());
        ImageIO.write(image, FORMAT_NAME, new File(destPath));
    }
    /**
     *
     * @author eason
     * @param content   内容
     * @param imgPath   LOGO地址
     * @param destPath  存储地址
     * @param needCompress 是否压缩LOGO
     * @param qrcodeSize 二维码大小 宽高
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath,
                              boolean needCompress,int qrcodeSize) throws IOException, WriterException {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress,qrcodeSize);
        FileUtils.forceMkdir(new File(destPath).getParentFile());
        ImageIO.write(image, FORMAT_NAME, new File(destPath));
    }


    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param imgPath
     *            LOGO地址
     * @param destPath
     *            存储地址
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath) throws IOException, WriterException {
        QRCodeUtil.encode(content, imgPath, destPath, false);
    }
    public static void encode(String content, String imgPath, String destPath, int qrcodeSize) throws IOException, WriterException {
        QRCodeUtil.encode(content, imgPath, destPath, true, qrcodeSize);
    }
    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param destPath
     *            存储地址
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String destPath, boolean needCompress) throws IOException, WriterException {
        QRCodeUtil.encode(content, null, destPath, needCompress);
    }

    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param destPath
     *            存储地址
     * @throws Exception
     */
    public static void encode(String content, String destPath) throws IOException, WriterException {
        QRCodeUtil.encode(content, null, destPath, false);
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param imgPath
     *            LOGO地址
     * @param output
     *            输出流
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    public static void encode(String content, String imgPath,
                              OutputStream output, boolean needCompress) throws IOException, WriterException {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress);
        ImageIO.write(image, FORMAT_NAME, output);
    }
    /**
     *
     * @author eason
     * @param content  内容
     * @param imgPath  LOGO地址
     * @param output 输出流
     * @param needCompress  是否压缩LOGO
     * @param qrcodeSize
     * @throws Exception
     */
    public static void encode(String content, String imgPath,
                              OutputStream output, boolean needCompress,int qrcodeSize) throws IOException, WriterException {
        BufferedImage image = QRCodeUtil.createImage(content, imgPath, needCompress,qrcodeSize);
        ImageIO.write(image, FORMAT_NAME, output);
    }
    public static void encode(String content, OutputStream output, int qrcodeSize) throws IOException, WriterException {
        QRCodeUtil.encode(content, null, output, false, qrcodeSize);
    }
    /**
     * 生成二维码
     *
     * @param content
     *            内容
     * @param output
     *            输出流
     * @throws Exception
     */
    public static void encode(String content, OutputStream output) throws IOException, WriterException {
        QRCodeUtil.encode(content, null, output, false);
    }

    /**
     * 解析二维码
     *
     * @param file
     *            二维码图片
     * @return
     * @throws Exception
     */
    public static String decode(File file) throws IOException, NotFoundException {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null) {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(
                image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        EnumMap<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        return result.getText();
    }

    /**
     * 解析二维码
     *
     * @param path
     *            二维码图片地址
     * @return
     * @throws Exception
     */
    public static String decode(String path) throws IOException, NotFoundException {
        return QRCodeUtil.decode(new File(path));
    }

}
