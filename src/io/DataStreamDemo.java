package io;

import java.io.*;

/**
 * DataOutputStream 以及 DataInputStream 的使用
 * DataOutputStream 什么顺序写入的的
 * DataInputStream 就按照什么顺序读
 */
public class DataStreamDemo {
    public static void main(String[] args) {
        dateOutPutStream(IOUtils.getAbsolutePath());
        dataInputStream(IOUtils.getAbsolutePath());
    }

    private static void dateOutPutStream(String parentPath) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(parentPath + "/src/file/DataStreamDemo.txt"))));

            dos.writeBoolean(true);
            dos.writeByte((byte) 0x41);
            dos.writeInt(0x12345678);
            dos.writeUTF("abcdefghijklmnopqrst");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void dataInputStream(String parentPath) {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(new File(parentPath + "/src/file/DataStreamDemo.txt"))));
            System.out.println("boolean is " + dis.readBoolean());
            System.out.println("byte is " + IOUtils.byteToHexString(dis.readByte()));
            System.out.println("int is " + Integer.toHexString(dis.readInt()));
            System.out.println("utf is "+ dis.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
