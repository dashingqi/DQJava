package io;

import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) {
        fileReader(IOUtils.getAbsolutePath());
    }

    private static void fileReader(String parentPath) {

        File file = new File(parentPath + "/src/file/FileWriter.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            char[] content = new char[1024 * 1024];
            while ((br.read(content)) != -1) {
                IOUtils.printCharArray(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
