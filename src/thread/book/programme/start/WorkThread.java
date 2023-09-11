package thread.book.programme.start;

public class WorkThread extends Thread {

    private String name;

    public WorkThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("线程" + name + "启动了");
    }
}
