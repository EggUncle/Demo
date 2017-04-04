package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by egguncle on 17-4-3.
 * 图片处理类
 */
public class ImageUtil {
    String openUrl;//需要处理的图片打开路径
    String saveUrl;//图片的保存路径
    String saveName;//保存图片的名字
    String suffix; //图片的类型

//    StringBuilder inputHtmlStr;
//    //<font color="#{{ item.color }}">{{ item.char }}</font>
//    String htmlStr="<html>\n" +
//            "<head>\n" +
//            "    <meta charset=\"utf-8\">\n" +
//            "    <title>{{ title }}</title>\n" +
//            "    <style type=\"text/css\">\n" +
//            "        body {\n" +
//            "            margin: 0px; padding: 0px; line-height:100%; letter-spacing:0px; text-align: center;\n" +
//            "            min-width: {{width}}px;\n" +
//            "            width: auto !important;\n" +
//            "            font-size: {{size}}px;\n" +
//            "            background-color: #{{background}};\n" +
//            "            font-family: {{font_family}};\n" +
//            "        }\n" +
//            "    </style>\n" +
//            "</head>\n" +
//            "<body>\n" +
//            "<div>"
//            +inputHtmlStr+
//            "</div>\n" +
//            "</body>\n" +
//            "</html>";

    public String c = "稳";

    public ImageUtil(String openUrl, String saveUrl, String saveName, String suffix) {
        this.openUrl = openUrl;
        this.saveUrl = saveUrl;
        this.saveName = saveName;
        this.suffix = suffix;

    }

    /**
     * 马赛克化.
     *
     * @param size 马赛克尺寸，即每个矩形的长宽
     * @return
     * @throws Exception
     */
    public boolean mosaic(int size) throws Exception {
        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }
        BufferedImage bi = ImageIO.read(file); // 读取该图片
        BufferedImage spinImage = new BufferedImage(bi.getWidth(),
                bi.getHeight(), bi.TYPE_INT_RGB);
        if (bi.getWidth() < size || bi.getHeight() < size || size <= 0) { // 马赛克格尺寸太大或太小
            return false;
        }

        int xcount = 0; // x方向绘制个数
        int ycount = 0; // y方向绘制个数
        if (bi.getWidth() % size == 0) {
            xcount = bi.getWidth() / size;
        } else {
            xcount = bi.getWidth() / size + 1;
        }
        if (bi.getHeight() % size == 0) {
            ycount = bi.getHeight() / size;
        } else {
            ycount = bi.getHeight() / size + 1;
        }
        int x = 0;   //坐标
        int y = 0;


        // 绘制马赛克(绘制矩形并填充颜色)
        Graphics gs = spinImage.getGraphics();
        for (int i = 0; i < xcount; i++) {
            for (int j = 0; j < ycount; j++) {
                //马赛克矩形格大小
                int mwidth = size;
                int mheight = size;
                if (i == xcount - 1) {   //横向最后一个比较特殊，可能不够一个size
                    mwidth = bi.getWidth() - x;
                }
                if (j == ycount - 1) {  //同理
                    mheight = bi.getHeight() - y;
                }
                // 矩形颜色取中心像素点RGB值
                int centerX = x;
                int centerY = y;
//                if (mwidth % 2 == 0) {
//                    centerX += mwidth / 2;
//                } else {
//                    centerX += (mwidth - 1) / 2;
//                }
//                if (mheight % 2 == 0) {
//                    centerY += mheight / 2;
//                } else {
//                    centerY += (mheight - 1) / 2;
//                }
                Color color = new Color(bi.getRGB(centerX, centerY));

                gs.setColor(color);
                gs.fillRect(x, y, mwidth, mheight);
                y = y + size;// 计算下一个矩形的y坐标
            }
            y = 0;// 还原y坐标
            x = x + size;// 计算x坐标
        }
        gs.dispose();
        File sf = new File(saveUrl, saveName + "." + suffix);
        ImageIO.write(spinImage, suffix, sf); // 保存图片

        return true;
    }


    //将图片转化为html并且存在硬盘中
    public boolean imgToHtml(int size) throws Exception {
        File file = new File(openUrl);
        if (!file.isFile()) {
            throw new Exception("ImageDeal>>>" + file + " 不是一个图片文件!");
        }

        BufferedImage bi = ImageIO.read(file); // 读取该图片
        if (bi.getWidth() < size || bi.getHeight() < size || size <= 0) { // 马赛克格尺寸太大或太小
            return false;
        }

        int xcount = 0; // x方向绘制个数
        int ycount = 0; // y方向绘制个数
        if (bi.getWidth() % size == 0) {
            xcount = bi.getWidth() / size;
        } else {
            xcount = bi.getWidth() / size + 1;
        }
        if (bi.getHeight() % size == 0) {
            ycount = bi.getHeight() / size;
        } else {
            ycount = bi.getHeight() / size + 1;
        }
        int x = 0;   //坐标
        int y = 0;

        StringBuilder inputHtmlStr = new StringBuilder();

        // 绘制马赛克(绘制矩形并填充颜色)
        for (int i = 0; i < ycount; i++) {
            for (int j = 0; j < xcount; j++) {
                // 矩形颜色取中心像素点RGB值
                int centerX = x;
                int centerY = y;
                System.out.println(centerX + "  " + centerY);
                int RGB = bi.getRGB(centerX, centerY);
                Color color = new Color(RGB);

                String RGBColor = toHex(color.getRed(), color.getGreen(), color.getBlue());
                inputHtmlStr.append("<font color=" + RGBColor + ">" + c + "</font>");
                x = x + size;// 计算下一个矩形的x坐标
            }
            inputHtmlStr.append("<br>\n\n");
            x = 0;// 还原x坐标
            y = y + size;// 计算y坐标
        }

        PrintStream printStream = new PrintStream(new FileOutputStream(saveUrl + saveName + "." + "html"));
        printStream.println(getHtml(inputHtmlStr, bi.getWidth() * size, bi.getHeight(), size));
        return true;

    }



    public static String getHtml(StringBuilder strInput, int width, int height, int size) {
        System.out.println(width + "  " + height);
        String htmlStr = "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>title </title>\n" +
                "    <style type=\"text/css\">\n" +
                "        body {\n" +
                "            margin: 0px; padding: 0px; line-height:100%; letter-spacing:0px;text-align: center; \n" +
                "            font-size: " + size + " px;\n" +
                "            background-color: #000000;\n" +
                "            font-family: monospace;\n" +
                "        }\n" +
                "div{" +
                "width:" + width + "px;\n" +
                "height:" + height + "px;\n" +
                "margin-left:auto;margin-right:auto;" +
                "}" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>"
                + strInput +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        return htmlStr;

    }

    //将RGB转换为16进制Hex
    public static String toHex(int r, int g, int b) {
        return "#" + toBrowserHexValue(r) + toBrowserHexValue(g)
                + toBrowserHexValue(b);
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(
                Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }

}
