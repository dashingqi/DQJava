package base.arithmetic.soort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 排序
 */
public class DQSort {

    /**
     * 冒泡排序
     *
     * @param array 数组
     */
    public void bubbleSort(int array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int lastExchangeIndex = 0;
        int sortBorder = len - 1;
        // 外层循环控制回合
        for (int i = 0; i < len - 1; i++) {
            // 每一轮的标记
            boolean isSorted = true;
            // 内层循环控制每轮的交换
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            // 提前结束循环，避免重复循环
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param array 排序的数组
     */
    private void bubbleSortV2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int lastExchangeIndex = 0;
        int len = array.length;
        int sortBorder = len;
        for (int i = 0; i < len - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int tempValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempValue;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            // 提前结束排序
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序V3
     *
     * @param array 数组
     */
    private void bubbleSortV3(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    int tempValue = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempValue;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void bubbleSortV4(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void bubbleSortedV5(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    int tempValue = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tempValue;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param array 待排序
     */
    private void bubbleSortV5(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    int tempValue = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tempValue;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }

    }

    /**
     * 快速排序
     *
     * @param arr        数组
     * @param startIndex 开始
     * @param endIndex   结束
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static void quickSortV1(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int partition = partitionV1(arr, startIndex, endIndex);
        quickSort(arr, startIndex, partition - 1);
        quickSort(arr, partition + 1, endIndex);

    }

    private static int partitionV1(int[] arr, int startIndex, int endIndex) {
        // 临界值取默认第一位
        int pivotValue = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivotValue) {
                right--;
            }

            while (left < right && arr[left] <= pivotValue) {
                left++;
            }
            if (left < right) {
                int tempValue = arr[left];
                arr[left] = arr[right];
                arr[right] = tempValue;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    private static int partitionV5(int[] arr, int startIndex, int endIndex) {
        int pivotValuer = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivotValuer) {
                right--;
            }

            while (left < right && arr[left] <= pivotValuer) {
                left++;
            }

            if (left < right) {

            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivotValuer;
        return left;
    }

    /**
     * 快速排序V3 寻找分割值
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionV3(int[] arr, int startIndex, int endIndex) {
        int pivotValue = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            if (left < right && arr[right] > pivotValue) {
                right--;
            }

            if (left < right && arr[left] <= pivotValue) {
                left--;
            }

            if (left < right) {
                int tempValue = arr[left];
                arr[left] = arr[right];
                arr[right] = tempValue;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    private static int partitionV8(int[] arr, int startIndex, int endIndex) {
        int pivotValue = arr[startIndex];
        int leftIndex = startIndex;
        int rightIndex = endIndex;
        while (leftIndex != rightIndex) {
            while (leftIndex < rightIndex && arr[rightIndex] > pivotValue) {
                rightIndex--;
            }

            while (leftIndex < rightIndex && arr[leftIndex] <= pivotValue) {
                leftIndex++;
            }

            if (leftIndex < rightIndex) {
                // 交换对应位置数据
                int tempValue = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = tempValue;
            }
        }

        arr[startIndex] = arr[leftIndex];
        arr[leftIndex] = pivotValue;
        return leftIndex;
    }

    public static void quickSortV9(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }

        int pivotIndex = partitionV9(arr, startIndex, endIndex);
        quickSortV9(arr, startIndex, pivotIndex - 1);
        quickSortV9(arr, pivotIndex + 1, endIndex);
    }

    private static int partitionV9(int[] arr, int startIndex, int endIndex) {
        int pivotValue = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            while (left < right && arr[right] > pivotValue) {
                right--;
            }

            while (left < right && arr[left] <= pivotValue) {
                left++;
            }

            if (left < right) {
                int tempValue = arr[left];
                arr[left] = arr[right];
                arr[right] = tempValue;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    /**
     * 寻找基准角标
     * 分治 单边循环法
     *
     * @param arr        数组
     * @param startIndex 开始
     * @param endIndex   结束
     * @return 基准
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivotValue = arr[startIndex];
        int markIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivotValue) {
                markIndex++;
                int tempValue = arr[markIndex];
                arr[markIndex] = arr[i];
                arr[i] = tempValue;
            }
        }
        arr[startIndex] = arr[markIndex];
        arr[markIndex] = pivotValue;
        return markIndex;
    }

    /**
     * 计数排序
     *
     * @param array 无序数组 [9,3,5,4,9,1,2,7,8,1,3,6,510,79]
     * @return 有序数组
     */
    public static int[] countSortV1(int[] array) {
        int max = array[0];
        // 选择出最大数
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // int len = max - min +1
        // 偏移量是最小值 min

        // 根据数列最大值确定统计数组的长度,默认值都是0
        int[] countArray = new int[max + 1];

        //遍历数列填充统计数组
        for (int k : array) {
            countArray[k]++;
        }
        //遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    /**
     * 计数排序 v2
     *
     * @param array 无序数组
     * @return 有序数组
     */
    public static int[] countSortV2(int[] array) {
        int max = array[0];
        int min = array[0];
        // 计算出 max 和 min
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        // 差值 d --> 用于计算统计数组的长度
        // min用作偏移量
        int d = max - min;
        // 统计数组
        int[] countArray = new int[d + 1];
        // 统计数组计数
        for (int j : array) {
            countArray[j - min]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] sortedArray = new int[array.length];
        //倒序
        for (int i = array.length - 1; i > 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    /**
     * 计数排序
     *
     * @param array 排序
     * @return 排序后的数组
     */
    private static int[] countSortV3(int[] array) {
        // 获取到数组中最大值
        int max = array[0];
        // 找到数组中最小值
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        // 偏移量
        int d = max - min;

        // 构建存储数据
        int[] countArray = new int[d + 1];

        //遍历数组，统计数据
        for (int k : array) {
            countArray[k - min]++;
        }

        //遍历数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    /**
     * 计数排序
     *
     * @param array 排序数组
     */
    private int[] countSortV4(int[] array) {
        int max = array[0];
        int min = array[1];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }

            if (min > array[i]) {
                min = array[i];
            }
        }
        // 偏移量
        int d = max - min;

        int[] countArray = new int[d + 1];
        for (int j : array) {
            countArray[j - min]++;
        }

        // 输出结果
        int index = 0;
        int[] sortArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }

    /**
     * 桶排序
     *
     * @param array 无序数组
     * @return 有序数组
     */
    public static double[] bucketSort(double[] array) {
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;

        // 初始化桶
        int bucketNum = array.length;

        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        for (double v : array) {
            // 计算当前数值属于哪个桶中
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }

        // 对每个桶内部进行排序
        for (LinkedList<Double> doubles : bucketList) {
            Collections.sort(doubles);
        }

        // 输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    /**
     * 桶排序
     *
     * @param array 数组
     * @return 排序后的数组
     */
    public static double[] bucketSortV1(double[] array) {
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;
        // 初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 计算值所在的桶
        for (double v : array) {
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }
        // 对桶内元素尽心排序
        for (LinkedList<Double> list : bucketList) {
            Collections.sort(list);
        }

        // 输出元素
        double[] sortArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> bucket : bucketList) {
            for (double value : bucket) {
                sortArray[index++] = value;
            }
        }
        return sortArray;
    }

    /**
     * 桶排序
     *
     * @param array
     * @return
     */
    private static double[] bucketSortV2(double[] array) {
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }

            if (min > array[i]) {
                min = array[i];
            }
        }

        // 偏移量
        double d = max - min;

        // 初始化桶
        int bucketArray = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketArray);
        for (int i = 0; i < bucketArray; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 遍历将元素放置到对应的桶中
        for (double v : array) {
            int index = (int) ((v - min) * (bucketArray - 1) * d);
            bucketList.get(index).add(v);
        }

        // 对桶内的元素进行排序
        for (LinkedList<Double> bucket : bucketList) {
            Collections.sort(bucket);
        }

        // 输出桶内的元素
        double[] sortArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> bucket : bucketList) {
            for (double value : bucket) {
                sortArray[index++] = value;
            }
        }
        return sortArray;
    }
}
