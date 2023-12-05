package base.arithmetic.interview;

import base.arithmetic.listnode.Node;

import java.util.*;

/**
 * 2023-11-24
 */
public class DQInterView24 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
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
                Integer realIndex = maps.get(realKey);
                return new int[]{realIndex, i};
            } else {
                maps.put(value, i);
            }
        }
        return new int[0];
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
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
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */
    public String longestPalindrome(String s) {
        return "";

    }


    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int start = 0, end = 0; end < len; end++) {
            char value = s.charAt(end);
            if (maps.containsKey(value)) {
                Integer index = maps.get(value);
                start = Math.max(start, index);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            maps.put(value, end + 1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringV1(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char value = s.charAt(end);
            if (maps.containsKey(value)) {
                Integer index = maps.get(value);
                start = Math.max(start, index);

            }
            maxLen = Math.max(maxLen, end - start + 1);
            maps.put(value, end + 1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringV2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char charValue = s.charAt(end);
            if (maps.containsKey(charValue)) {
                Integer index = maps.get(charValue);
                start = Math.max(start, index);

            }
            maxLen = Math.max(maxLen, end - start + 1);
            maps.put(charValue, end + 1);
        }
        return maxLen;
    }


    /**
     * 链表反转
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
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
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
     * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
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
        return true;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     */
    public Node mergeTwoLists(Node list1, Node list2) {
        Node newNode = new Node(0);
        Node dumpNode = newNode;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                dumpNode.next = list1;
                list1 = list1.next;
            } else {
                dumpNode.next = list2;
                list2 = list2.next;
            }
            dumpNode = dumpNode.next;
        }
        if (list1 != null) {
            dumpNode.next = list1;
        } else {
            dumpNode.next = list2;
        }
        return dumpNode.next;
    }


    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * <p>
     * 输入：l1 = [], l2 = []
     * 输出：[]
     */
    public Node mergeTwoListsV1(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Node node = new Node(0);
        Node newNode = node;
        while (list1.next != null || list2.next != null) {
            if (list1.data < list2.data) {
                newNode.next = list1;
            } else {
                newNode.next = list2;
            }
            newNode = newNode.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        return newNode;
    }

    public Node mergeTwoListsV2(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.data < list2.data) {
            list1.next = mergeTwoListsV2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsV2(list1, list2.next);
            return list2;
        }
    }

    /**
     * 合并两个链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public Node mergeTwoListsV3(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.data < list2.data) {
            list1.next = mergeTwoListsV3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsV3(list1, list2.next);
            return list2;
        }

    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n
     * ，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
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
            nums1[k--] = nums1[j--];
        }
        System.out.println(nums1);
    }

    public int[] mergeV1(int[] nums1, int m, int[] nums2, int n) {
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
        return nums1;

    }

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * <p>
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     * <p>
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出：true
     * 解释："amanaplanacanalpanama" 是回文串。
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        StringBuilder reverseStr = new StringBuilder(s).reverse();
        return s.equals(reverseStr);

    }

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * <p>
     * 字母和数字都属于字母数字字符。
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
     * <p>
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出：true
     * 解释："amanaplanacanalpanama" 是回文串。
     */
    public boolean isPalindromeV1(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i : nums) {
            integers.add(i);
        }
        return integers.size();
    }

    public int removeDuplicatesV1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int fast = 1, slow = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;
    }

    public int removeDuplicatesV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int index = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 移除数组中的重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicatesV3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     */
    public int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);

    }

    /**
     * 使用两个栈实现队列
     */
    static class DQQueue {

        /**
         * 栈 A
         */
        Stack<Integer> stackA = new Stack<Integer>();
        /**
         * 栈 B
         */
        Stack<Integer> stackB = new Stack<Integer>();

        public DQQueue() {

        }

        public void appendTail(int value) {
            stackA.push(value);
        }

        public int deleteHead() {
            if (stackB.isEmpty()) {
                if (stackA != null && !stackA.isEmpty()) {
                    a2B();
                } else {
                    return -1;
                }
            }
            return stackB.pop();
        }

        private void a2B() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }

    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，
     * 并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     */
    static class DQStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public DQStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }

            Queue<Integer> tempQueue = queue1;
            queue1 = queue2;
            queue2 = tempQueue;
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    static class DQStackV1 {
        Queue<Integer> mQueue;

        public DQStackV1() {
            mQueue = new LinkedList<>();
        }

        public void push(int x) {
            int n = mQueue.size();
            mQueue.offer(x);
            for (int i = 0; i < n; i++) {
                mQueue.offer(mQueue.poll());
            }
        }

        public int pop() {
            return mQueue.poll();
        }

        public int top() {
            return mQueue.peek();
        }

        public boolean empty() {
            return mQueue.isEmpty();
        }
    }

    public boolean isValidBracket(String s) {
        if (s == null && s.isEmpty()) {
            return false;
        }

        HashMap<Character, Character> maps = new HashMap<>();
        maps.put('(', ')');
        maps.put('[', ']');
        maps.put('{', '}');
        maps.put('?', '?');
        int len = s.length();
        LinkedList<Character> queue = new LinkedList<>();
        queue.offer('?');
        for (int i = 0; i < len; i++) {
            char charValue = s.charAt(i);
            if (maps.containsKey(charValue)) {
                Character tempValue = maps.get(charValue);
                queue.addLast(tempValue);
            } else {
                Character poll = queue.removeLast();
                if (poll != charValue) {
                    return false;
                }
            }
        }
        return queue.size() == 1;
    }

    public int pivotIndex(int[] array) {
        int total = 0;
        int sum = 0;
        for (int intValue : array) {
            total += intValue;
        }
        for (int i = 0; i < array.length; i++) {
            total -= array[i];
            if (sum == total) {
                return i;
            }
            sum += array[i];
        }

        return -1;
    }

    /**
     * 示例 1：
     * <p>
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     * <p>
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     * <p>
     * 输入：x = 120
     * 输出：21
     */
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            int value = x % 10;
            sum = sum * 10 + value;
            x /= 10;
        }
        return sum;
    }


    /**
     * 接雨水
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     */
    public int trap(int[] height) {
        Stack<Integer> stacks = new Stack<>();
        int current = 0;
        int sum = 0;
        while (current < height.length) {
            while (!stacks.isEmpty() && height[current] > height[stacks.peek()]) {
                int h = height[stacks.peek()];
                stacks.pop();
                if (stacks.isEmpty()) {
                    break;
                }
                int distance = current - stacks.peek() - 1;
                int min = Math.min(height[stacks.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stacks.push(current);
            current++;

        }

        return sum;

    }

    /**
     * 最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV3(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> maps = new HashMap<>();
        for (int start = 0, end = 0; end < len; end++) {
            char tempCharValue = s.charAt(end);
            if (maps.containsKey(tempCharValue)) {
                Integer index = maps.get(tempCharValue);
                start = Math.max(index, start);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            maps.put(tempCharValue, end + 1);
        }
        return maxLen;
    }

    /**
     * 去除数组中重复的数据
     * @param nums
     * @return
     */
    public int[] removeDuplicatesV4(int[] nums) {
        if (nums == null && nums.length == 0) {
            return new int[0];
        }
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[start] != nums[end]) {
                start++;
                nums[start] = nums[end];
            }
        }

        return Arrays.copyOfRange(nums, 0, start + 1);
    }
}