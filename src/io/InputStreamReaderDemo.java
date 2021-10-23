package io;

import java.io.*;

public class InputStreamReaderDemo {
    public static void main(String[] args) {

        File tempFile = new File(IOUtils.getAbsolutePath() + "/src/file/OutputStreamWriter.txt");
        try {
            inputStreamReaderDef(new FileInputStream(tempFile));
            inputStreamReaderGBK(new FileInputStream(tempFile));
            inputStreamReaderUTF8(new FileInputStream(tempFile));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void inputStreamReaderDef(InputStream is) {
        BufferedReader defaultReader = null;
        try {
            defaultReader = new BufferedReader(new InputStreamReader(is));
            String tempStr;
            while ((tempStr = defaultReader.readLine()) != null) {
                System.out.println("tempStr = " + tempStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (defaultReader != null) {
                try {
                    defaultReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void inputStreamReaderGBK(InputStream is) {
        BufferedReader gbkReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(is, "GBK");
            gbkReader = new BufferedReader(inputStreamReader);

            String tempStr;
            while ((tempStr = gbkReader.readLine()) != null) {
                System.out.println("tempStr = " + tempStr);
            }

            System.out.println("code is " + inputStreamReader.getEncoding());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (gbkReader != null) {
                try {
                    gbkReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void inputStreamReaderUTF8(InputStream is) {
        BufferedReader utf8Reader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
            utf8Reader = new BufferedReader(inputStreamReader);

            String tempStr;
            while ((tempStr = utf8Reader.readLine()) != null) {
                System.out.println("tempStr = " + tempStr);
            }

            System.out.println("code is " + inputStreamReader.getEncoding());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (utf8Reader != null) {
                try {
                    utf8Reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
