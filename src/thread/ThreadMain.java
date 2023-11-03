package thread;

import java.util.concurrent.CountDownLatch;

public class ThreadMain {
    public static void main(String[] args) {
        // interruptAtThread();

        // unableInterruptThread();

        //flagThread();
        useCountDownLaunch();
    }

    /**
     * 用于练习线程的interrupt
     */
    public static void interruptAtThread() {
        InterruptableThread interruptableThread = new InterruptableThread();
        interruptableThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("main Interrupted");
            e.printStackTrace();
        }
        // 中断子线程
        interruptableThread.interrupt();
    }

    /**
     * 用于练习 isInterrupt()方法
     */
    public static void unableInterruptThread() {
        UnableInterruptThread unableInterruptThread = new UnableInterruptThread();
        unableInterruptThread.start();

        unableInterruptThread.interrupt();
    }

    /**
     * 标志位中断Thread
     */
    public static void flagThread() {
        FlagThread flagThread = new FlagThread();
        flagThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flagThread.isInterrupted = true;
    }

    public static void useCountDownLaunch() {
        int numberOfThreads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " ---> Started");
                    Thread.sleep(2000);
                    System.out.println(threadName + " ---> finished its work");
                    countDownLatch.countDown();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("All thread have completed their work. Continue with the main thread");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
