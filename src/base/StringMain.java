package base;

/**
 * Java String 有多长
 * 字面量
 * 存储在栈中，具体是方法区的常量池中
 * .java ---> .class 文件的时候
 * String 是以如下结构进行存储
 * CONSTANT_Utf8_info {
 * u1 tag;
 * u2 length;   // 0 ~ 65535
 * u1 bytes[length];
 * }
 * UTF-8 编码
 * length： 长度 u2：两个字节
 * u1:使用byte[]进行存储，长度为 两个字节的长度也就是 65535个字节 (1111111111111111)
 * <p>
 * 当使用 String a = "65535个拉丁字母" 会提示 超长
 * 当声明为65534个，是可以编译通过的
 * 在编译器的 Gen.java 文件中我们可以发现 对于字面量字节个数的检查，能编译通过是要小于65535
 * 这是编译器的一个Bug
 * 还要取决与 栈内存的空间大小
 * <p>
 * byte [] bytes = loadFile();
 * String content = new String(bytes)
 * <p>
 * 虚拟机指令 newarray 数组最长 是 Integer.MAX_VALUE
 * 堆内存空间的大小
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

        int digit = '5' - '0';
        System.out.println("digit = " + digit);
    }

    // 写一个最长回文子串
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
