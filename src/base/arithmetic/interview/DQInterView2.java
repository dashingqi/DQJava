package base.arithmetic.interview;

import base.arithmetic.listnode.Node;

import java.util.Stack;

public class DQInterView2 {

    /**
     * 判断链表中是否有环
     *
     * @param head 链表
     * @return true/false
     */
    public boolean hasCycle(Node head) {
        if (head == null) return false;
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
     * 求环的长度
     *
     * @param head 环
     * @return 长度
     */
    public int getCycleLength(Node head) {
        // 边间条件判断
        if (head == null) {
            return 0;
        }
        Node p1 = head;
        Node p2 = head;
        // 循环快指针
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            // 判断是否有环
            while (p1 == p2) {
                int len = 1;
                p1 = p1.next;
                p2 = p2.next.next;
                // 循环开始计步
                while (p1 != p2) {
                    len++;
                    p1 = p1.next;
                    p2 = p2.next.next;
                }
                return len;
            }
        }
        return 0;
    }

    static class DQStack {
        private Stack<Integer> stackA = new Stack<>();
        private Stack<Integer> stackB = new Stack<>();

        /**
         * 入栈
         *
         * @param value 值
         */
        public void push(int value) {
            stackA.push(value);
            // 如果stackB为空就入栈
            if (stackB.isEmpty()) {
                stackB.push(value);
            }
            // 临时获取下栈顶元素
            Integer minValue = stackB.peek();
            // 入栈元素小于栈顶元素就入栈
            if (value < minValue) {
                stackB.push(value);
            }
        }

        /**
         * 出栈
         *
         * @return value
         */
        public int pop() {
            // 需要做 stackB 的操作
            Integer currentValue = stackA.pop();
            if (currentValue.equals(stackB.peek())) {
                stackB.pop();
            }
            return currentValue;
        }

        /**
         * 获取最小值
         *
         * @return value
         */
        public int getMin() {
            return stackB.pop();
        }
    }

    /**
     * 求两个数的最大公约数(欧几里德算法)
     *
     * @param a value1
     * @param b value2
     * @return gcd
     */
    public int gcdV2(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int tempValue = max % min;
        if (tempValue == 0) {
            return min;
        }
        return gcdV2(tempValue, min);
    }

    /**
     * 求两个数的最大公约数(辗转相除法)
     *
     * @param a value1
     * @param b value2
     * @return gcd
     */
    public int gcdV3(int a, int b) {
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
     * @param value
     * @return
     */
    public boolean isPowerOf2V1(int value) {
        return (value & (value - 1)) == 0;
    }
}
