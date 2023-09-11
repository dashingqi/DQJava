package thread.book.programme;

import java.util.Date;

public class SimpleJavaApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        Thread.sleep(10000L);
    }
}
