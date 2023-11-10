package thread.waitnotify;

import java.util.LinkedList;

public class Consumer implements Runnable {

    private final LinkedList<String> mBuffer;

    private final Object mLock;

    public Consumer(LinkedList<String> buffer, Object lock) {
        mBuffer = buffer;
        mLock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mLock) {
                while (mBuffer.isEmpty()) {
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String value = mBuffer.removeFirst();
                System.out.println("Consuming: " + value);
                mLock.notify();
            }
        }
    }
}
