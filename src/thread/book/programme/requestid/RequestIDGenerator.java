package thread.book.programme.requestid;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RequestIDGenerator {

    /**
     * 实例对象
     */
    private final static RequestIDGenerator instance = new RequestIDGenerator();
    private final static short SEQ_UPPER_LIMIT = 999;
    private short sequence = -1;

    /**
     * 私有构造方法
     */
    private RequestIDGenerator() {

    }

    public static RequestIDGenerator getInstance() {
        return instance;
    }

    private synchronized short nextSequence() {
        if (sequence >= SEQ_UPPER_LIMIT) {
            sequence = 0;
        } else {
            sequence++;
        }
        return sequence;
    }

    public String nextID() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        String timestamp = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("000");
        short sequenceNo = nextSequence();
        return "0049-" + timestamp + "-" + df.format(sequenceNo);
    }
}
