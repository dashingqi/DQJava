package base.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Java方法中的分派
 * 调用谁的那个方法
 *
 * 静态分派 -- 方法重载 （编译期确定）
 * 动态分派 -- 方法复写 （运行时确定，子类复写父类的方法）
 *
 * 程序输出什么 几乎Java中的所有方法都是虚方法；程序输出什么取决于运行时的实际类型--> SubClass 输出结果就是"Hello Sub"
 * 怎么调用的：取决于编译时期声明的类型
 *
 * 虚方法：能被子类复写的方法
 * private、public static 修饰的方法是不能被复写的
 *
 */
public class MethodQuestion {

    public static void main(String[] args) {
        SuperClass subClass = new SubClass();
        println(subClass);

        List<String> strList = new ArrayList<>();
        strList.add("aaa");
        String value = strList.get(0);


        // 字节码的形态
        // SubClass var1 = new SubClass();
        // println((SuperClass)var1);

    }

    private static void println(SuperClass superClass) {
        System.out.println("Hello " + superClass.getName());
    }

    private static void println(SubClass subClass) {
        System.out.println("Hello " + subClass.getName());
    }

    // 泛型类型无法用于方法的重载
//    private void method1(List<String> str){}

    private void method1(List<Integer> str){}

    // 泛型类型无法当做真实类型使用
    static <T> void getMethod(T t) {
//        T instance = new T(); // 报错
//        T[] ts = new T[0]; // 报错
//        Class<T> tClass = T.class; // 报错
//
//        // 泛型擦除 T -> Object
//        List<T> list = new ArrayList<T>();
//
//        // T -> Object
//        if (list instanceof List<String>) {}
    }

    public void test(){
//        startActivityForResult(intent,new ResultListener(){
//           void onResult(){
//               // do Something
//           }
//        });
    }
}
