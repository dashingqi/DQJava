package thread.executors;

import java.io.File;
import java.util.concurrent.*;

public class TaskResultRetrievalDemo {

    /**
     * CPU 核心数
     */
    final static int N_CPU = Runtime.getRuntime().availableProcessors();

    /**
     * 线程池
     */
    final ThreadPoolExecutor executor = new ThreadPoolExecutor(0,
            N_CPU * 2,
            4,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100)
            , new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        TaskResultRetrievalDemo taskResultRetrievalDemo = new TaskResultRetrievalDemo();
        Future<String> stringFuture = taskResultRetrievalDemo.recognizeImage("");
        doSomething();
        try {
            System.out.println("result is " + stringFuture.get());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void doSomething() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Future<String> recognizeImage(final String imageFile) {
        return executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doRecognizeImage(new File(imageFile));
            }
        });
    }

    private String doRecognizeImage(File imageFile) {
        String result = "";
        String[] simulatedResults = {"1", "2", "4"};
        result = simulatedResults[(int) (Math.random() * simulatedResults.length)];
        return result;
    }
}
