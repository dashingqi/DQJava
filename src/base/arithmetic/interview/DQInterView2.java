package base.arithmetic.interview;

import base.arithmetic.listnode.Node;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

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


    private static class Bucket {
        Integer max;
        Integer min;
    }

    /**
     * 无序数组排序后的最大相邻差
     *
     * @param array 无序数组
     * @return 最大相邻差值
     */
    public static int getMaxSortedDistance(int[] array) {
        // 确认最大值和最小值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }
        // 如果 max 和 min 相等，说明数组所有元素都相等；
        int d = max - min;
        if (d == 0) {
            return 0;
        }
        // 初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 遍历原始数组，确定每个桶的最大最小值
        for (int j : array) {
            int index = ((j - min) * (bucketNum - 1) / d);
            if (buckets[index].min == null || buckets[index].min > j) {
                buckets[index].min = j;
            }

            if (buckets[index].max == null || buckets[index].max < j) {
                buckets[index].max = j;
            }

        }

        // 遍历桶，找打最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }

            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }

        return maxDistance;
    }

    /**
     * 使用栈实现队列
     */
    static class StackQueue {
        private Stack<Integer> stackA = new Stack<>();
        private Stack<Integer> stackB = new Stack<>();

        /**
         * 入队
         *
         * @param value
         */
        public void enQueue(int value) {
            stackA.push(value);
        }

        /**
         * 出队
         *
         * @return 值
         */
        public Integer deQueue() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    return null;
                }
                // 栈A中有元素，就进行转换
                transfer();
            }
            return stackB.pop();
        }

        /**
         * 将栈A中的元素转换到栈B中
         */
        private void transfer() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }

    /**
     * 删除整数的k个数字，获得删除后的最小值
     *
     * @param num 当前数字
     * @param k   K个数字
     * @return 移除后的数字
     */
    public static String removeKDigits(String num, int k) {
        String numNew = num;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            for (int j = 0; i < numNew.length() - 1; i++) {
                if (numNew.charAt(j) > numNew.charAt(j + 1)) {
                    hasCut = true;
                    numNew = numNew.substring(0, j) + numNew.substring(j + 1, numNew.length());
                    break;
                }
            }
            // 如果没有找到要删除的数字，就删除最后一个数字
            if (!hasCut) {
                numNew = numNew.substring(0, numNew.length() - 1);
            }
            numNew = removeZero(numNew);
        }
        if (numNew.length() == 0) {
            return "0";
        }
        return numNew;
    }

    /**
     * 移除头部零
     *
     * @param num
     * @return
     */
    public static String removeZero(String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(0) != '0') {
                break;
            }
            num = num.substring(1, num.length());
        }
        return num;
    }

    /**
     * 两个大数相加
     *
     * @param bigNumberA numA
     * @param bigNumberB numA
     * @return result
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        int maxLen = Math.max(bigNumberA.length(), bigNumberB.length());
        int[] arrayA = new int[maxLen + 1];
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - i - 1) - '0';
        }
        int[] arrayB = new int[maxLen + 1];
        for (int i = 0; i < bigNumberB.length(); i++) {
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - i - 1) - '0';
        }

        int[] array = new int[maxLen + 1];
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            temp += arrayA[i];
            temp += arrayB[i];
            if (temp >= 10) {
                temp = temp - 10;
                array[i + 1] = 1;
            }
            array[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i++) {
            if (array[array.length - 1] == 0) {
                continue;
            }
            sb.append(i);
        }
        return sb.toString();
    }

    static class Node {
        int key, value;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = this;
            next = this;
        }
    }

    static class LRUCache {
        /**
         * 容量
         */
        private final int capacity;
        /**
         *
         */
        private final Node dump;
        /**
         * 缓存
         */
        private final Map<Integer, Node> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dump = new Node(0, 0);
            // 线程安全
            cache = new ConcurrentHashMap<>();
        }

        /**
         * 获取节点值
         *
         * @param key 健
         * @return value
         */
        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            remove(node);
            add(node);
            return node.value;
        }

        /**
         * 装Node
         *
         * @param key   健
         * @param value 值
         */
        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                // 不存在就进行存储
                // 先判断容量是否超出阈值
                if (cache.size() >= capacity) {
                    cache.remove(dump.next.key);
                    remove(dump.next);
                }
            } else {
                // 存在，先移除节点（缓存与链表中）
                cache.remove(key);
                remove(node);
            }
            // 构造一个新节点
            node = new Node(key, value);
            // 更新cache
            cache.put(key, node);
            // 更新链表
            add(node);
        }

        /**
         * 移除节点
         *
         * @param node 节点
         */
        private void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        /**
         * 添加节点
         *
         * @param node 节点
         */
        private void add(Node node) {
            dump.pre.next = node;
            node.pre = dump.pre;
            node.next = dump;
            dump.pre = node;
        }
    }

    /**
     * 继承LinkedHashMap实现
     *
     * @param <K>
     * @param <V>
     */
    static class DQLruCache<K, V> extends LinkedHashMap<K, V> {
        int capacity;

        public DQLruCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;

        }

        @Override
        public boolean remove(Object key, Object value) {
            return size() > capacity;
        }
    }

    static class DQLruCacheV2 {

        private final int capacity;
        private final Node head;
        private final Node tail;
        private final Map<Integer, Node> cache;

        public DQLruCacheV2(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            cache = new ConcurrentHashMap<>();
        }

        /**
         * 获取节点
         *
         * @param key 健
         * @return value
         */
        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                // 将节点放置到头部
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        /**
         * 移动到头节点
         *
         * @param node 节点
         */
        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        /**
         * 添加节点到头部
         *
         * @param node 节点
         */
        private void addToHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        /**
         * 放置节点
         *
         * @param key   健
         * @param value 值
         */
        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                if (cache.size() > capacity) {
                    // 超过阈值，移除尾部
                    Node node = removeTail();
                    cache.remove(node.value);
                }
            }
        }

        /**
         * 移除Node
         *
         * @param node 节点
         */
        public void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

        }

        /**
         * 移除尾部节点
         *
         * @return 尾部的节点
         */
        public Node removeTail() {
            Node tailNode = tail.pre;
            removeNode(tailNode);
            return tailNode;
        }
    }

    static class DQLruCacheV3 {

        private int capacity;

        private Node head;

        private Node tail;

        private Map<Integer, Node> caches;

        public DQLruCacheV3(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            caches = new ConcurrentHashMap<>();
            head.next = tail;
            tail.pre = head;
        }

        public void put(int key, int value) {
            if (caches.containsKey(key)) {
                // 存在的情况
                Node node = caches.get(key);
                moveToHead(node);
            } else {
                // 不存在的情况
                Node node = new Node(key, value);
                addToHead(node);
                caches.put(key, node);
                if (caches.size() > capacity) {
                    // 移除尾部的节点
                    Node removeNode = removeTail();
                    caches.remove(removeNode.key);
                }
            }
        }

        public int get(int key) {
            if (caches.containsKey(key)) {
                Node node = caches.get(key);
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        /**
         * 移除节点
         *
         * @param node 节点
         */
        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        /**
         * 添加到头部
         *
         * @param node 节点
         */
        private void addToHead(Node node) {
            Node tempNode = head.next;
            node.next = tempNode;
            node.pre = head;
            head.next = node;
            tempNode.pre = node;
        }

        /**
         * 移除尾部的节点
         */
        private Node removeTail() {
            Node node = tail.pre;
            removeNode(node);
            return node;
        }
    }
}
