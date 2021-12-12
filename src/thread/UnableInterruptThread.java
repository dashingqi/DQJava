package thread;

/**
 * 不支持中断的线程
 */
public class UnableInterruptThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 100000; i++) {
            if (interrupted()) {
                break;
            }
            if (i % 2 == 0) {
                System.out.println(" i == " + i);
            }
        }
    }
}
