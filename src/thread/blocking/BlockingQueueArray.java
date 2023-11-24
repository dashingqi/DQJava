package thread.blocking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueArray {

    private final Lock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    private final Queue<String> queue = new LinkedList<>();

    private static final int MAX_SIZE = 10;

    public void writeToQueue(String data) throws InterruptedException {
        try {
            lock.lock();
            while (queue.size() == MAX_SIZE){
                notFull.await();
            }
            queue.add(data);
            System.out.println(Thread.currentThread().getName() + " write to queue data is " + data);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public String readFromQueue() throws InterruptedException {
        try {
            lock.lock();
            while (queue.isEmpty()){
                notEmpty.await();
            }
            String data = queue.poll();
            System.out.println(Thread.currentThread().getName() + " read from queue data is " + data);
            notFull.signal();
            return data;
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        BlockingQueueArray blockingQueueArray = new BlockingQueueArray();

        Thread writerThread = new Thread(() -> {
            try {
                while (true) {
                    blockingQueueArray.writeToQueue("data");
                    Thread.sleep(500);
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Thread readThread = new Thread(() -> {
            try {
                while (true) {
                    String data = blockingQueueArray.readFromQueue();
                    Thread.sleep(1000);
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        writerThread.start();
        readThread.start();

    }
}
