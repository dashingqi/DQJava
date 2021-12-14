package thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

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

        User user1 = new User("张三", 1);
        User user2 = new User("李四", 2);
        User user3 = new User("王五", 3);

        // AtomicReference 是对普通对象的封装
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(user1);

        userAtomicReference.compareAndExchange(user1, user2);
        System.out.println("current user is " + userAtomicReference.get());

        userAtomicReference.compareAndExchange(user1, user3);
        System.out.println("current user is " + userAtomicReference.get());
    }
}
