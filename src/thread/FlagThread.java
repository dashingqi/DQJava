package thread;

public class FlagThread extends Thread {

    /**
     * 当前线程时候被中断
     */
    public volatile boolean isInterrupted = false;

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            if (isInterrupted) {
                break;
            }
            System.out.println(" is == " + i);
        }
    }
}
