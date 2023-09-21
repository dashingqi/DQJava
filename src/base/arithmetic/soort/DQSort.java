package base.arithmetic.soort;

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
}
