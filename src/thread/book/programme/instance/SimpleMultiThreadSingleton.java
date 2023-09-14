package thread.book.programme.instance;

public class SimpleMultiThreadSingleton {

    private SimpleMultiThreadSingleton() {

    }

    public static void main(String[] args) {
        Singleton.INSTANCE.doSomething();
    }

    private volatile static SimpleMultiThreadSingleton mInstance = null;

    /**
     * 饿汉式
     *
     * @return SimpleMultiThreadSingleton
     */
    public static SimpleMultiThreadSingleton getInstance() {
        if (mInstance == null) {
            synchronized (SimpleMultiThreadSingleton.class) {
                mInstance = new SimpleMultiThreadSingleton();
            }
        }
        return mInstance;
    }

    /**
     * 双重检查模式
     *
     * @return SimpleMultiThreadSingleton
     */
    public static SimpleMultiThreadSingleton getDoubleCheckInstance() {
        if (mInstance == null) {
            synchronized (SimpleMultiThreadSingleton.class) {
                if (mInstance == null) {
                    mInstance = new SimpleMultiThreadSingleton();
                }
            }
        }
        return mInstance;
    }

    private static class InstanceHolder {
        final static SimpleMultiThreadSingleton INSTANCE = new SimpleMultiThreadSingleton();
    }

    /**
     * 静态内部类
     *
     * @return SimpleMultiThreadSingleton
     */
    public static SimpleMultiThreadSingleton getStaticSingleton() {
        return InstanceHolder.INSTANCE;
    }

    /**
     * 枚举
     */
    public enum Singleton {
        INSTANCE;

        Singleton() {
            // do nothing
        }

        public void doSomething() {
            // so something
        }
    }

}
