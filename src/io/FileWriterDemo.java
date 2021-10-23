package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {
        fileWriter(IOUtils.getAbsolutePath());
    }

    private static void fileWriter(String parentPath) {
        File file = new File(parentPath + "/src/file/FileWriter.txt");
        BufferedWriter bw = null;
        try {

            FileWriter fileWriter = new FileWriter(file,true);

            bw = new BufferedWriter(fileWriter);
            bw.write("冥冥中都注定你是贫或富");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
