package thread.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * AtomicReferenceFiledUpdater
 */
public class AtomicReferenceFieldUpdaterHolder {

    // volatile 关键字重点
    volatile String value = "hello world";
    public static final AtomicReferenceFieldUpdater<AtomicReferenceFieldUpdaterHolder, String> atomicReferenceFieldUpdaterValue =
            AtomicReferenceFieldUpdater.newUpdater(AtomicReferenceFieldUpdaterHolder.class, String.class, "value");
}
