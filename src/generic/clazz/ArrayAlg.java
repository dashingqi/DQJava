package generic.clazz;

public class ArrayAlg {

    public static Pair<String> minMax(String[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        String min = array[0];
        String max = array[0];

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
}
