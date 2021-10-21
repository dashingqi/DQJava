package io;

import java.io.*;

public class OutputStreamWriterDemo {

    private final static String STRING = "i l y";

    public static void main(String[] args) {
        outputStreamWriter(IOUtils.getAbsolutePath());
    }

    private static void outputStreamWriter(String parentPath) {
        File file = new File(parentPath + "/src/file/OutputStreamWriter.txt");
        BufferedWriter bw = null;
        BufferedWriter gBkWriter = null;
        BufferedWriter utf8Writer = null;
        try {
            // 设置为true表示可以追加
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            OutputStreamWriter oswDef = new OutputStreamWriter(fileOutputStream);
            bw = new BufferedWriter(oswDef);

            // 写字符或者字符串 数字
            bw.write(STRING);
            bw.newLine();
            bw.flush();

            System.out.println("oswDef encoding is " + oswDef.getEncoding());

            OutputStreamWriter oswGBK = new OutputStreamWriter(fileOutputStream, "GBk");
            gBkWriter = new BufferedWriter(oswGBK);
            gBkWriter.write(STRING + " - GBK");
            gBkWriter.newLine();
            gBkWriter.flush();

            System.out.println("oswGBk encoding is " + oswGBK.getEncoding());

            OutputStreamWriter oswUTF8 = new OutputStreamWriter(fileOutputStream, "UTF-8");
            utf8Writer = new BufferedWriter(oswUTF8);
            utf8Writer.write(STRING + " - UTF-8");
            utf8Writer.newLine();
            utf8Writer.flush();

            System.out.println("oswUTF8 encoding is " + oswUTF8.getEncoding());

        } catch (Exception e) {
            e.printStackTrace();

            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (gBkWriter != null) {
                try {
                    gBkWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (utf8Writer != null) {
                try {
                    utf8Writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
