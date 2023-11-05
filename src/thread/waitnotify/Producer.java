package thread.waitnotify;

import java.util.LinkedList;

public class Producer implements Runnable {
    private final LinkedList<String> mBuffer;
    private final int mCapacity;

    private final Object mLock;

    public Producer(LinkedList<String> buffer, int capacity, Object lock) {
        mBuffer = buffer;
        mCapacity = capacity;
        mLock = lock;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            synchronized (mLock) {
                while (mBuffer.size() == mCapacity) {
                    try {
                        mLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing: " + value);
                mBuffer.add("" + value);
                value++;
                mLock.notify();
            }
        }
    }
}
