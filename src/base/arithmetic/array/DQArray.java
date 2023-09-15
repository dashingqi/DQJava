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
}
