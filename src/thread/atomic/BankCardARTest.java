package thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference 保证你在修改对象引用时的线程安全性
 */
public class BankCardARTest {
    private static AtomicReference<BankCard> atomicReference =
            new AtomicReference(new BankCard("xcuan", 100));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    final BankCard card = atomicReference.get();
                    BankCard newBankCard = new BankCard(card.getAccountName(), card.getMoney() + 100);
                    // 乐观锁，CAS Compare And Swap
                    // 首先会对比 AtomicReference中持有的引用是否和card一致，一致的话就进行交换，交换成newBankCard
                    if (atomicReference.compareAndSet(card, newBankCard)) {
                        System.out.println(newBankCard);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
