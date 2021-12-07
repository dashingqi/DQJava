package base.innerclass;

/**
 * #### Java的匿名内部类有哪些限制？
 * 匿名内部类的概念和用法
 *
 * 语言规范以及语言的横向对比
 * 内存泄漏的切入点
 * 1. 匿名内部类的构造方法是由编译器定义的。
 */
public class InnerClass {
    public static void main(String[] args) {

        Client client = new Client();
        client.run();

        // 匿名内部类，是有名字的.只不过这个名字是由Java虚拟机定义的
        // 名字就是 base.InnerClass$1
        // $1 表示是该类中的第一个匿名内部类
        Foo foo = new Foo() {
            @Override
            public int bar() {
                return 0;
            }
        };

        // 匿名内部类
        // 名字就是  base.InnerClass$2
        Runnable runnable = new Runnable() {

            @Override
            public void run() {

            }
        };

        // 方法体内部定义一个类 继承 Foo， 实现Runnable接口
        class Test extends Foo implements Runnable {
            @Override
            public void run() {

            }
        }
    }
}
