package string;

public class StringMain {
    public static void main(String[] args) {
        String oldName = "zhangqi";
        String newName = "zhangQi";

        boolean result = oldName.toLowerCase().equals(newName.toLowerCase());

        boolean result2 = oldName.toUpperCase().equals(newName.toUpperCase());
    }
}
