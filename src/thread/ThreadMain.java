package thread;

import thread.exception.ThreadMonitorDemo;
import thread.waitnotify.Consumer;
import thread.waitnotify.Producer;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        // interruptAtThread();

        // unableInterruptThread();

        //flagThread();
        //useCountDownLaunch();
//        useWaitAndNotify();
//        useJoinn();
        useUnCaughtExceptionHandler();
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


    public static void useWaitAndNotify() {
        // 开启两个线程
        int capacity = 5;
        LinkedList<String> buffer = new LinkedList<>();
        Object lock = new Object();
        Thread producerThread = new Thread(new Producer(buffer, capacity, lock));
        Thread consumerThread = new Thread(new Consumer(buffer, lock));

        producerThread.start();
        consumerThread.start();
    }

    public static void useJoin() {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 performed");
            System.out.println("ThreadGroup is " + Thread.currentThread().getThreadGroup());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        Thread thread2 = new Thread(() -> {
            System.out.println("ThreadGroup is " + Thread.currentThread().getThreadGroup());
            System.out.println("thread2 performed");

        });

        thread1.start();
        try {
            thread1.join(); // 等待 thread1线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }

    private static void useUnCaughtExceptionHandler() throws InterruptedException {
        ThreadMonitorDemo threadMonitorDemo = new ThreadMonitorDemo();
        threadMonitorDemo.initMethod();
        for (int i = 0; i < 100; i++) {
            threadMonitorDemo.service("test-" + i);
        }
        Thread.sleep(20000);
        System.exit(0);
    }

    private Thread makeThread(Runnable runnable){
        return new Thread(runnable){
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }
}
