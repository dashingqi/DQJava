package base.arithmetic.interview;

import base.arithmetic.listnode.Node;

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
}
