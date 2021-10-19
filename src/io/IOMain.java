package io;

import java.io.*;

public class IOMain {
    public static void main(String[] args) {

    }

    /**
     * 装饰器模式
     * out/in 是针对内存来说的
     * in  是将文件读取到流中读到内存中
     * out 是从将内存中数据写入流中存储到其他文件中
     * 序列化中使用 DataOutputStream
     * 反序列化中使用 DataInputStream
     * 将文件变成一个流  FileInputStream
     * 将流变成一个文件  FileOutputStream
     *
     * @param fileName 文件路径名
     */
    private static void writeUtils(String fileName) {

        try {
            DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(fileName))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void readUtils(String fileName) {
        try {
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File(fileName)
                            )
                    )
            );
            boolean b = in.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从字节流中读取
     */
    private static void readChar(String fileName) {
        try {
           BufferedReader br =  new BufferedReader(new InputStreamReader(
                    new FileInputStream(
                            new File(fileName)
                    )
            ));

           br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将字节流写入
     *
     * @param fileName
     */
    private static void writeChar(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(
                            new File(fileName)
                    )
            ));

            bw = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
