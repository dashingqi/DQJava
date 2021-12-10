package generic.clazz;

public class Method<T> {
    // 静态方法无法引用类的泛型参数
//    static T get(T a, T b){
//
//    }
    // 声明方法的类型参数
    static <R> R get(R a, R b) {
        return a;
    }

}
