package generic.clazz;

/**
 * 泛型类 # main
 */
public class GenericClazzMain {
    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> pairInstance = ArrayAlg.minMax(words);
        System.out.println("min = " + pairInstance.getFirst());
        System.out.println("max = " + pairInstance.getSecond());

    }
}
