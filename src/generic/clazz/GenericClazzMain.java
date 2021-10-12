package generic.clazz;

import java.time.LocalDate;
import java.util.Collections;

import static generic.clazz.ArrayAlg.minMax;

/**
 * 泛型类 # main
 */
public class GenericClazzMain {
    public static void main(String[] args) {

        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> pairInstance = minMax(words);

        System.out.println("min = " + pairInstance.getFirst());
        System.out.println("max = " + pairInstance.getSecond());


        double middle = ArrayAlg.getMiddle(3.14, 1729D, 0D);
        System.out.println("middle  = " + middle);

        LocalDate[] localTime = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(2021, 10, 1)
        };

        Pair<LocalDate> localDatePair = minMax(localTime);

        System.out.println("min = " + localDatePair.getFirst());
        System.out.println("max = " + localDatePair.getSecond());
//        Pair a = new Pair<>();
//        // 运行时类型仅适用于原始类型
//        if (a instanceof Pair<String>){
//
//        }
         //不能创建参数化类型的数组 为了避免数组里出现类型不一致的元素
        // Pair<String> [] tables = new Pair<String>[10];

        //Pair<String>[] objectPair = new Pair[10];
        // 将数组向上转换一下
//        Object[] o = objectPair;
//        o[0] = new Object();


    }
}
