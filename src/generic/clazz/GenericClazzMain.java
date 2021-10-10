package generic.clazz;

import java.time.LocalDate;

/**
 * 泛型类 # main
 */
public class GenericClazzMain {
    public static void main(String[] args) {

        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> pairInstance = ArrayAlg.minMax(words);
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

        Pair<LocalDate> localDatePair = ArrayAlg.minMax(localTime);

        System.out.println("min = " + localDatePair.getFirst());
        System.out.println("max = " + localDatePair.getSecond());


    }
}
