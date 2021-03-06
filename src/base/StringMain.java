package base;

/**
 * Java String 有多长
 * 字面量
 * 存储在栈中，具体是方法区的常量池中
 * .java ---> .class 文件的时候
 *  String 是以如下结构进行存储
 *  CONSTANT_Utf8_info {
 *        u1 tag;
 *        u2 length;   // 0 ~ 65535
 *        u1 bytes[length];
 *    }
 *  UTF-8 编码
 *  length： 长度 u2：两个字节
 *  u1:使用byte[]进行存储，长度为 两个字节的长度也就是 65535个字节 (1111111111111111)
 *
 *  当使用 String a = "65535个拉丁字母" 会提示 超长
 *  当声明为65534个，是可以编译通过的
 *  在编译器的 Gen.java 文件中我们可以发现 对于字面量字节个数的检查，能编译通过是要小于65535
 *  这是编译器的一个Bug
 *  还要取决与 栈内存的空间大小
 *
 *  byte [] bytes = loadFile();
 *  String content = new String(bytes)
 *
 *  虚拟机指令 newarray 数组最长 是 Integer.MAX_VALUE
 *  堆内存空间的大小
 *
 *
 *
 */
public class StringMain {

    private static final String cd = "aaaaaa";
    public static void main(String[] args) {
        // 字面量  该种形式是存储在 栈内存 方法区种
        // 65535：编译器源码中有做判断 必须小于65535个字节
        // （javac里面的bug，拉丁字符最多是65534，非拉丁 最多65535）
        String longSting = "aaaaaaa";

        // 是存储在堆内存中的
        byte[] bytes = new byte[1024 * 1024];
        String s = new String(bytes);
    }
}
