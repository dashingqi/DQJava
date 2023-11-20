package base.arithmetic.interview;

import base.arithmetic.listnode.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class DQInterView {

    /**
     * 检查链表中是否有环
     *
     * @param head 节点
     * @return true/false
     */
    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 栈
     */
    static class DQStack {
        private final Stack<Integer> mainStack = new Stack<>();
        private final Stack<Integer> minStack = new Stack<>();

        public void push(int value) {
            // 入栈
            mainStack.push(value);
            if (minStack.isEmpty() || value < minStack.peek()) {
                minStack.push(value);
            }
        }

        public int pop() {
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            return mainStack.pop();
        }

        /**
         * 返回栈中保存的最小值
         *
         * @return min value
         */
        public int getMainValue() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }
    }

    /**
     * 队列实现使用栈
     */
    static class QueueWithStack {

        private Stack<Integer> stackA = new Stack<>();

        private Stack<Integer> stackB = new Stack<>();

        /**
         * 入队列
         *
         * @param value 值
         */
        public void enQueue(int value) {
            stackA.push(value);
        }

        /**
         * 出队列
         *
         * @return 先进先出
         */
        public Integer deQueue() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    return null;
                }
                transfer();
            }
            return stackB.pop();
        }

        private void transfer() {
            if (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }

    /**
     * 最大公约数 （辗转相除法）
     *
     * @param a a
     * @param b b
     * @return gcd
     */
    public static int gcdV2(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        if (big % small == 0) {
            return small;
        }
        return gcdV2(big % small, small);
    }

    /**
     * 最大公约数 更相减损术
     *
     * @param a a
     * @param b b
     * @return gcd
     */
    public static int gcdV3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        return gcdV3(big - small, small);
    }

    /**
     * 判断一个数是否是2的整数次幂
     *
     * @param num 数
     * @return true/false
     */
    public boolean isPowerOf2V1(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp << 1;
        }
        return false;
    }

    public boolean isPowerOf2V2(int num) {
        // 0和1按位与运算的结果是0
        return (num & (num - 1)) == 0;
    }

    /**
     * 删除整数的k个数字，获得删除后的最小值
     *
     * @param num 整数
     * @param k   第K个
     * @return 获取到的最小值
     */
    public static String removeKDigits(String num, int k) {
        String newNum = num;
        boolean hasCut = false;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < newNum.length() - 1; j++) {
                if (newNum.charAt(j) > newNum.charAt(j + 1)) {
                    newNum = newNum.substring(0, j) + newNum.substring(j + 1, newNum.length());
                    hasCut = true;
                    break;
                }
            }
            if (!hasCut) {
                newNum = newNum.substring(0, newNum.length() - 1);
            }
            // 清除整数左侧数字0
            newNum = removeZero(newNum);
        }
        if (newNum.length() == 0) {
            return "0";
        }
        return newNum;
    }

    /**
     * 移除zero
     *
     * @param num 整数
     * @return 移除后的整数
     */
    private static String removeZero(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                break;
            }
            num = num.substring(1, num.length());
        }

        return num;
    }

    /**
     * 两个大数进行相加
     *
     * @param bigNumberA 数A
     * @param bigNumberB 数B
     * @return 相加后的数字
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        int maxLen = Math.max(bigNumberA.length(), bigNumberB.length());
        int[] arrayA = new int[maxLen + 1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            // 将bigNumber中的字符转化成数字逆序存储到arrayA中
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLen + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            //  将bigNumber中的字符转化成数字逆序存储到arrayB中
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i) - '0';
        }

        // 构建一个结果result数组
        int[] result = new int[maxLen + 1];
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp > 10) {
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        // 从数组中将结果读取转换成字符串
        StringBuilder sb = new StringBuilder();
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static int methodV1(int[] array) {
        int total = 0;
        int sum = 0;
        for (int value : array) {
            total += value;
        }
        for (int i = 0; i < array.length; i++) {
            if (2 * sum + array[i] == total) {
                return i;
            } else {
                sum += array[i];
            }
        }
        return -1;
    }

    public static void methodV2(String[] strArray) {
        int left = 0;
        int right = strArray.length - 1;
        while (left < right) {
            String tempLeftValue = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = tempLeftValue;
            left++;
            right--;
        }
    }
}
