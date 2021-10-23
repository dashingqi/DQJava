package io;

import java.io.File;

/**
 * IO 工具类
 */
public class IOUtils {
    /**
     * 字节转成字符串
     *
     * @param b
     * @return
     */
    public static String byteToString(byte b) {
        byte[] b_array = {b};
        return new String(b_array);
    }

    /**
     * 打印字节数组
     * @param buf
     */
    public static void printByteArray(byte[] buf) {
        for (byte b : buf) {
            if (b != 0) {
                System.out.println(byteToString(b));
            }
        }
    }

    public static void printCharArray(char[] chaz){
        for (char c : chaz){
            if (c !=0){
                System.out.print(String.valueOf(c));
            }
        }
    }

    // 打印byte对应的16进制的字符串
    public static String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    // 打印char对应的16进制的字符串
    public static String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    // 打印short对应的16进制的字符串
    public static String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }

    /**
     * 获取到当前的绝对路径
     *
     * @return String 绝对路径
     */
    public static String getAbsolutePath() {
        File file = new File("");
        try {
            return file.getAbsolutePath();
        } catch (Exception e) {
            return "";
        }
    }
}
