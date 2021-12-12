package thread;

public class ThreadMain {
    public static void main(String[] args) {
        // interruptAtThread();

        // unableInterruptThread();

        flagThread();
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
}
