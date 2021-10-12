package generic.clazz;

public class ArrayAlg {

    public static <T extends Comparable> Pair<T> minMax(T[] array) {
        if (array == null || array.length == 0) {
            return new Pair();
        }

        T min = array[0];
        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }

        return new Pair<>(min, max);
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }
}
