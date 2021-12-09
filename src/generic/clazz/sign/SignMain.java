package generic.clazz.sign;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 使用泛型签名的两个实例
 *
 */
public class SignMain {

    public static void main(String[] args) {
        ParameterizedType genericSuperclass =
                (ParameterizedType) SignSubClass.class.getGenericSuperclass();

        for (Type type : genericSuperclass.getActualTypeArguments()) {
            System.out.println(type);
        }
        // 输出结果 class java.lang.String

        try {
            ParameterizedType getValue =
                    (ParameterizedType) SignSubClass.class.getMethod("getValue").getGenericReturnType();
            for (Type value : getValue.getActualTypeArguments()) {
                System.out.println(value);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
