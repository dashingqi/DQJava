package thread.book.programme.start;

public class StartThreadMain {
    public static void main(String[] args) {
        // 创建一个Thread
        WorkThread dashingQi = new WorkThread("DashingQi");
        dashingQi.start();

        // 创建一个Runnable
        WorkRunnable workRunnable = new WorkRunnable();
        // 交由一个Thread去执行Runnable
        Thread thread = new Thread(workRunnable);
        // 开启线程（请求Java虚拟机去执行线程）
        thread.start();

    }
}
