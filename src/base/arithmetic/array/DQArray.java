package base.arithmetic.array;

public class DQArray {

    private int[] array;
    private int size;

    public DQArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int index, int value) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of index == " + index);
        }
        // 扩容
        if (index >= array.length) {
            reSize();
        }
        // 角标循环
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        // 赋值
        array[index] = value;
        size++;
    }

    public void reSize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    public int delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("");
        }
        int deleteValue = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteValue;
    }

    /**
     * 左右两边数组和相等
     *
     * @param nums 数组
     * @return 对应的角标
     */
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
