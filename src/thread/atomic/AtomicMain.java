package thread.atomic;

/**
 * Atomic Main
 */
public class AtomicMain {

    public static void main(String[] args) {
        AtomicReferenceValueHolder atomicReferenceValueHolder = new AtomicReferenceValueHolder();
        // 如果当前atomicReferenceValue中持有的值是 "Hello" 的话就换成 "World"
        atomicReferenceValueHolder.atomicReferenceValue.compareAndSet("Hello", "World");

        String value = atomicReferenceValueHolder.atomicReferenceValue.getAndUpdate(s -> s + " --- 1111");


        // AtomicReferenceFieldUpdaterHolder
        AtomicReferenceFieldUpdaterHolder atomicReferenceFileUpdaterHolder = new AtomicReferenceFieldUpdaterHolder();
        AtomicReferenceFieldUpdaterHolder
                .atomicReferenceFieldUpdaterValue
                .compareAndSet(atomicReferenceFileUpdaterHolder, "Hello", "World");

        String fieldUpdaterValue =
                AtomicReferenceFieldUpdaterHolder
                        .atomicReferenceFieldUpdaterValue
                        .getAndUpdate(atomicReferenceFileUpdaterHolder, o -> o + " --- 1111");

        System.out.println("value == " + value);
        System.out.println("fieldUpdaterValue == " + fieldUpdaterValue);
    }
}
