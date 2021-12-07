package base;

/**
 * Java String 有多长
 */
public class StringMain {
    public static void main(String[] args) {
        // 字面量  该种形式是存储在 栈内存 方法区种
        // 65535：编译器源码中有做判断 必须小于65535个字节 （javac里面的bug，拉丁字符最多是65534，非拉丁 最多65535）
        String longSting = "aaaaaaa";

        // 是存储在堆内存中的
        byte[] bytes = new byte[1024 * 1024];
        String s = new String(bytes);
    }
}
