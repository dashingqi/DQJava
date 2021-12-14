package thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference
 */
public class AtomicReferenceValueHolder {
    // 头占了 12B Fields 4B  64位 16B（指针压缩）24B（指针不压缩）
    // AtomicReference 内部也是又一个 volatile T value
    // 内存问题
    AtomicReference<String> atomicReferenceValue = new AtomicReference<>("Hello Atomic");
}
