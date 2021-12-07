package base.innerclass;
public class Client {
    public static void run() {
        // 创建了一个匿名内部类，
        Foo foo = new Foo();
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass() {

            @Override
            void test() {
                System.out.println(foo);

            }
        };
        // 匿名内部类
       /* public class Client$1{
            public Client$1(Client client,OuterClass outerClass){

            }
        }*/

        OuterClass.InnerClass1 innerClass1 = new OuterClass.InnerClass1() {

            @Override
            public void test() {

            }
        };
    }
}
