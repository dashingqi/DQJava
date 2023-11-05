package thread;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }
}
