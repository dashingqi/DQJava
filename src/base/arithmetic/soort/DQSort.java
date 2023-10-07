package base.arithmetic.soort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

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
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
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
}
