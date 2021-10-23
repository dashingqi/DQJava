package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.Duration;
import java.time.Instant;

public class FileChannelDemo {
    public static void main(String[] args) {

        File sourceFile = new File(IOUtils.getAbsolutePath()+"/src/file/8-5.mp4");
        File targetFile = new File(IOUtils.getAbsolutePath()+"/src/video/8-5.mp4");
        if (targetFile.exists()) {
            targetFile.delete();
        }
        copyFileByStream(sourceFile, targetFile);
       // copyFileByChannel(sourceFile, targetFile);


    }


    /**
     * 通过普通流copy文件
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     */
    private static void copyFileByStream(File sourceFile, File targetFile) {

        Instant begin = Instant.now();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(targetFile);

            // 1MB
            byte[] bytes = new byte[1024 * 1024];

            while (fis.read(bytes) != -1) {
                // 写文件
                fos.write(bytes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("total cost time is " + Duration.between(begin, Instant.now()).toMillis());

    }

    /**
     * 通过Channel copy 文件
     *
     * @param sourceFile 源文件
     * @param targetFile 目标文件
     */
    private static void copyFileByChannel(File sourceFile, File targetFile) {
        Instant begin = Instant.now();

        FileChannel readChannel = null;
        FileChannel writeChannel = null;
        try {
            RandomAccessFile raSourceFile = new RandomAccessFile(sourceFile, "r");
            RandomAccessFile raTargetFile = new RandomAccessFile(targetFile, "rw");

            readChannel = raSourceFile.getChannel();
            writeChannel = raTargetFile.getChannel();


            ByteBuffer allocate = ByteBuffer.allocate(1024 * 1024);

            while (readChannel.read(allocate) != -1) {
                allocate.flip();
                writeChannel.write(allocate);
                allocate.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writeChannel != null) {
                try {
                    writeChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (readChannel != null) {
                try {
                    readChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("time cost is " + Duration.between(begin, Instant.now()).toMillis());
    }
}
