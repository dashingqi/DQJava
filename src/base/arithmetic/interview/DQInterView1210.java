package base.arithmetic.interview;

import base.arithmetic.listnode.Node;
import base.arithmetic.tree.TreeNode;

import java.util.*;

/**
 * 12月10号开启的面试算法类
 */
public class DQInterView1210 {

    // ####################################################String#######################################################

    /**
     * 回文字符串
     *
     * @param s
     * @return
     */
    public boolean isPalindromeV1(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return false;
    }

    /**
     * 无重复最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLen = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char curValue = s.charAt(end);
            if (maps.containsKey(curValue)) {
                Integer curIndex = maps.get(curValue);
                start = Math.max(curIndex, start);
            }

            maxLen = Math.max(maxLen, end - start + 1);
            maps.put(curValue, end + 1);
        }
        return maxLen;
    }

    // ===================================================array=========================================================

    /**
     * 合并两个有序数据
     * nums.len = m+n
     * nums2 到 nums1中
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * 有序重复数组返回无重复有序数据
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int fast = 1, slow = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 反转字符数组
     *
     * @param s
     */
    public void reverseString(char[] s) {

        if (s == null || s.length == 0) {
            return;
        }

        int left = 0, right = s.length - 1;
        while (left < right) {
            char tempValue = s[right];
            s[right] = s[left];
            s[left] = tempValue;
            left++;
            right--;
        }
    }

    /**
     * 中心角标
     *
     * @param array
     * @return
     */
    public int pivotIndex(int[] array) {
        int total = 0;
        int sum = 0;
        for (int value : array) {
            total += value;
        }

        for (int i = 0; i < array.length; i++) {
            total -= array[i];
            if (total == sum) {
                return i;
            }

            sum += array[i];
        }

        return -1;
    }

    /**
     * 两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int realKey = target - value;
            if (maps.containsKey(realKey)) {
                int index = maps.get(realKey);
                return new int[]{index, i};
            }
            maps.put(value, i);
        }
        return new int[0];
    }

    /**
     * 数组实现队列
     */

    static class DQQueueByArray {

        private int mCapacity;
        private int[] array;

        /**
         * 头部
         */
        int head = 0;
        /**
         * 尾部
         */
        int tail = 0;


        public DQQueueByArray(int capacity) {
            mCapacity = capacity;
            array = new int[capacity];
        }

        /**
         * 入队操作
         *
         * @param value
         */
        public void enqueue(int value) {
            if (tail == mCapacity) {
                return;
            }
            array[tail] = value;
            tail++;
        }

        /**
         * 出队操作
         *
         * @return value
         */
        public int dequeue() {
            if (head == tail) return -1;
            int value = array[head];
            head++;
            return value;

        }

        public int size() {
            return tail - head;
        }
    }

    // ==================================================Node===========================================================

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    public Node reverseListNode(Node head) {
        if (head == null) {
            return null;
        }

        Node preNode = null;
        Node curNode = head;
        while (curNode.next != null) {
            Node nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    /**
     * 链表中是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(Node head) {
        if (head == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node mergeTwoNodeLists(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.data < list2.data) {
            list1.next = mergeTwoNodeLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoNodeLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * lru 算法的实现
     */
    static class DQLruCacheByNode {

        private int capacity;
        private DQInterView2.Node head;

        private DQInterView2.Node tail;

        private Map<Integer, DQInterView2.Node> maps;

        public DQLruCacheByNode(int capacity) {
            this.capacity = capacity;
            maps = new HashMap<>(capacity);
            head = new DQInterView2.Node(0, 0);
            tail = new DQInterView2.Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        /**
         * 存储
         *
         * @param key
         * @param value
         */
        public void put(int key, int value) {
            if (maps.containsKey(key)) {
                DQInterView2.Node node = maps.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                DQInterView2.Node newNode = new DQInterView2.Node(key, value);
                addToHead(newNode);
                if (maps.size() > capacity) {
                    maps.remove(key);
                    removeTail();
                }

            }

        }

        public int get(int key) {
            if (maps.containsKey(key)) {
                DQInterView2.Node node = maps.get(key);
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void moveToHead(DQInterView2.Node node) {
            removeNode(node);
            addToHead(node);
        }

        public void removeNode(DQInterView2.Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addToHead(DQInterView2.Node node) {
            DQInterView2.Node headNext = head.next;
            head.next = node;
            node.pre = head;
            headNext.pre = node;
            node.next = headNext;
        }

        public void removeTail() {
            DQInterView2.Node tailPre = tail.pre;
            removeNode(tailPre);
        }

    }

    // ======================================================Tree=======================================================

    /**
     * 前序遍历
     *
     * @param node 节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node 节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.leftChild);
        System.out.println(node.data);
        inOrderTraverse(node.rightChild);
    }

    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     *
     * @param node 节点
     */
    public void levelOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            System.out.println(curNode.data);
            if (curNode.leftChild != null) {
                queue.offer(curNode.leftChild);
            }
            if (curNode.rightChild != null) {
                queue.offer(curNode.rightChild);
            }
        }
    }

    /**
     * 深度遍历
     *
     * @param node 节点
     */
    public void deepOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(node);
        while (!stacks.isEmpty()) {
            TreeNode curNode = stacks.pop();
            if (curNode.rightChild != null) {
                stacks.push(curNode.rightChild);
            }

            if (curNode.leftChild != null) {
                stacks.push(curNode.leftChild);
            }
            System.out.println(curNode.data);
        }
    }

}
