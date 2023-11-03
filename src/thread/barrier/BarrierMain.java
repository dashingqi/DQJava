package thread.barrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierMain {

    public static void main(String[] args) {
        int numberOfThreads = 3;

        Runnable barrierRunnable = ()-> {
            System.out.println("barrier runnable perform");
        };

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfThreads, barrierRunnable);

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Current Thread --> " + Thread.currentThread().getName() + "started");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " -->Thread is waiting at the barrier");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " --> Thread has passed the barrier and continues execution.");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }).start();
        }
    }
}
