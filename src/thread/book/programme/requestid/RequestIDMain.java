package thread.book.programme.requestid;

public class RequestIDMain {

    public static void main(String[] args) {
        int numberOfThreads =
                args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new WorkThread(i, 10);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    static class WorkThread extends Thread {
        private final int requestCount;

        public WorkThread(int id, int requestCount) {
            super("worker-" + id);
            this.requestCount = requestCount;
        }

        @Override
        public void run() {
            int i = requestCount;
            String requestID;
            RequestIDGenerator requestIDGenerator = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                requestID = requestIDGenerator.nextID();
                processRequest(requestID);
            }
        }

        /**
         * 处理请求
         *
         * @param requestId 请求 ID
         */
        private void processRequest(String requestId) {
            try {
                Thread.sleep(50);
                System.out.printf("%s got requestID: %s %n", Thread.currentThread().getName(), requestId);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


