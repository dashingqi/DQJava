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
         * @return
         */
        public int getMainValue() {
            if (minStack.isEmpty()) {
                return -1;
            }
            return minStack.peek();
        }
    }
}
