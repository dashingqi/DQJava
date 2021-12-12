package thread;

/**
 * 线程
 */
public class InterruptableThread extends Thread {

    @Override
    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            System.out.println("interrupted!");
        }
    }
}
