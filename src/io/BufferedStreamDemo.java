package io;

import java.io.*;

public class BufferedStreamDemo {

    private static final byte[] byteArray = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) {
        System.out.println("abs = " + IOUtils.getAbsolutePath());
        bufferedOutPutStream(IOUtils.getAbsolutePath());
        bufferedInputStream(IOUtils.getAbsolutePath());

    }

    /**
     * 将字节写入到文件中
     */
    private static void bufferedOutPutStream(String parentPath) {
        File targetFile = new File(parentPath + "/src/file/BufferedStreamDemo.txt");
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(targetFile));
            // 这个地方只能写字节
            bos.write(byteArray[0]);
            bos.write(byteArray, 1, byteArray.length - 1);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件中读取
     */
    private static void bufferedInputStream(String parentPath) {

        BufferedInputStream bis = null;
        try {
            File targetFile = new File(parentPath + "/src/file/BufferedStreamDemo.txt");
            bis = new BufferedInputStream(new FileInputStream(targetFile));
            for (int i = 0; i < 10; i++) {
                // 返回当输入流中字节数
                if (bis.available() >= 0) {
                    System.out.println(IOUtils.byteToString((byte) bis.read()));
                }
            }

            // 从上次读取的位置，往后最多读取多少个字节
            bis.mark(6666);
            // 从当前读取的位置，跳过10个字节在读取
            bis.skip(10);

            byte[] bytes = new byte[1024];
            int read = bis.read(bytes, 0, bytes.length);
            System.out.println("read is " + read);

            IOUtils.printByteArray(bytes);

            System.out.println("reset之后 ================");

            // 重置到第一次读取的位置  （skip 复位）调用了skip方法后 才能调用这个方法
            bis.reset();
            int read_1 = bis.read(bytes, 0, bytes.length);
            System.out.println("read_1 is " + read_1);
            IOUtils.printByteArray(bytes);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
