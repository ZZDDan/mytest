package com.rxx.arithmetic;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * @author :zhangdan
 * @Title :SortTest
 * @Description:
 * @Company :
 * @date :2017年1月15日 下午5:14:32
 */
public class SortTest {

    /**
     * 堆排序
     * @throws Exception
     */
    @Test
    public void testHeapSorting() throws Exception {
        int[] arr = {14, 60, 212, 12, 5, 8};
        System.out.println("排序前：" + printArr(arr));
        heapSorting(arr, arr.length);
        System.out.println("排序后：" + printArr(arr));
    }

    /**
     * 堆排序算法
     *
     * @param arr
     * @param length
     * @return
     */
    private void heapSorting(int[] arr, int length) {
        // 初始化堆
        buildingHeap(arr, length);
        // 从最后一个元素开始对序列进行调整
        for (int i = length - 1; i > 0; --i) {
            System.out.println("排序中：" + printArr(arr));

            // 交换堆顶元素arr[0]和堆中最后一个元素
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            // 每次交换堆顶元素和堆中的最后一个元素之后，都要对堆进行调整
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * 已知H[s…m]除了H[s] 外均满足堆的定义
     * 调整H[s],使其成为大顶堆.即将对第s个结点为根的子树筛选,
     *
     * @param arr    待调整的堆数组
     * @param i      待调整的数组元素的位置
     * @param length 数组的长度
     */
    private void heapAdjust(int[] arr, int i, int length) {
        int tmp = arr[i];
        //左孩子结点的位置。(i+1 为当前调整结点的右孩子结点的位置)
        int child = 2 * i + 1;
        while (child < length) {
            // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            // 如果较大的子结点大于父结点
            if (arr[i] < arr[child]) {
                // 那么把较大的子结点往上移动，替换它的父结点
                arr[i] = arr[child];
                // 重新设置s ,即待调整的下一个结点的位置
                i = child;
                child = 2 * i + 1;
            }
            // 如果当前待调整结点大于它的左右孩子，则不需要调整，直接退出
            else {
                break;
            }
            // 当前待调整的结点放到比其大的孩子结点位置上
            arr[i] = tmp;
        }
    }

    /**
     * 初始堆进行调整
     * 将arr[0..length-1]建成堆
     * 调整完之后第一个元素是序列的最小的元素
     */
    private void buildingHeap(int[] arr, int length) {
        //最后一个有孩子的节点的位置 i=  (length -1) / 2
        for (int i = (length - 1) / 2; i >= 0; i--) {
            heapAdjust(arr, i, length);
        }
    }

    /**
     * 基数排序
     */
    @Test
    public void testRadixSort() {
        int[] arr = {14, 60, 212, 12, 5, 8};
        System.out.println("排序前：" + printArr(arr));
        arr = radixSorting(arr, 3);
        System.out.println("排序后：" + printArr(arr));
    }

    // d为数据长度
    private int[] radixSorting(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            arr = countingSort(arr, i); // 依次对各位数字排序（直接用计数排序的变体）

            System.out.println("排序中：" + printArr(arr));
        }
        return arr;
    }

    // 利用计数排序对元素的每一位进行排序
    private int[] countingSort(int[] arr, int figures) {
        int k = 9;
        int[] sorted = new int[arr.length];
        int[] bucket = new int[k + 1]; // 这里比较特殊：数的每一位最大数为9

        // 初始化桶里的数据
        for (int i = 0; i < k; i++) {
            bucket[i] = 0;
        }
        // 进行桶排序
        for (int i = 0; i < arr.length; i++) {
            // d 为 数据 arr[i] 的 figures + 1 位数据，如：arr[i]:123, figures:1, d:2,表示 arr[i]的十位是2
            int d = getBitData(arr[i], figures);
            bucket[d]++;
        }
        // 记录排序结果
        for (int i = 1; i <= k; i++) {
            bucket[i] += bucket[i - 1];
        }
        // 输出排序结果
//      for (int i = 0; i < arr.length; i++) {// 使用从前向后遍历，会把之前的排序颠倒过来，从而导致排序失败
        for (int i = arr.length - 1; i >= 0; i--) {
            int d = getBitData(arr[i], figures);
            sorted[bucket[d] - 1] = arr[i];// C[d]-1 就代表小于等于元素d的元素个数，就是d在B的位置
            bucket[d]--;
        }

        // 排序一次的结果
        return sorted;
    }

    // 获取data指定位的数
    private static int getBitData(int data, int expIndex) {
        while (data != 0 && expIndex > 0) {
            data /= 10;
            expIndex--;
        }
        return data % 10;
    }

    @Test
    public void testQuickSort() {
        int[] arr = {4, 6, 2, 9, 5, 8};
        System.out.println("排序前：" + printArr(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + printArr(arr));
    }

    private void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int key = arr[left];
            int low = left;
            int high = right;
            while (low < high) {
                while (low < high && arr[high] > key) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] < key) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = key;
            System.out.println("排序中：" + printArr(arr));
            quicksort(arr, left, low - 1);
            quicksort(arr, low + 1, right);
        }
    }

    /**
     * 希尔排序
     */
    @Test
    public void testShellSort() {
        int[] arr = {4, 6, 2, 9, 5, 8};
        System.out.println("排序前：" + printArr(arr));

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j += gap) {
                    if (arr[j] < arr[j - gap]) {
                        int tmp = arr[j];
                        int k = j - gap;
                        while (k >= 0 && tmp < arr[k]) {
                            arr[k + gap] = arr[k];
                            k -= gap;
                        }
                        arr[k + gap] = tmp;
                    }
                }
            }

            System.out.println("排序中：" + printArr(arr));
        }

        System.out.println("排序后：" + printArr(arr));
    }

    /**
     * 冒泡排序
     */
    @Test
    public void testBubbleSort() {
        int[] arr = {4, 6, 2, 9, 5, 8};
        System.out.println("排序前：" + printArr(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

            System.out.println("排序中：" + printArr(arr));
        }
        System.out.println("排序后：" + printArr(arr));
    }

    @Test
    public void test() {
        int[] arr = {4, 6, 2, 9, 5, 8};
        System.out.println("排序前：" + printArr(arr));
        System.out.println("排序后：" + printArr(arr));
    }

    /**
     * 选择排序
     */
    @Test
    public void testSelectSort() {
        int[] arr = {4, 6, 2, 9, 5, 8};
        System.out.println("排序前：" + printArr(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            System.out.println("排序中：" + printArr(arr));
        }
        System.out.println("排序后：" + printArr(arr));
    }

    /**
     * 插入排序
     */
    @Test
    public void testInsertionSort() {
        int[] arr = {4, 6, 2, 9, 5, 8};

        System.out.println("排序前：" + printArr(arr));
        // sort
        for (int i = 1; i < arr.length; i++) {
            int keyword = arr[i];
            int j = i - 1;
            while (j >= 0 && keyword < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = keyword;

            System.out.println("排序中：" + printArr(arr));
        }
        System.out.println("排序后：" + printArr(arr));
    }


    private String printArr(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + " ";
        }
        return result;
    }

    @Test
    public void testMergerSort() {
        int[] arr = {5, 8, 2, 7, 6, 9, 3, 2};
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] tmp = new int[arr.length];

        System.out.println("排序前：" + printArr(arr));
        mergerSort(arr, 0, arr.length - 1, tmp);
        System.out.println("排序后：" + printArr(arr));
    }

    private void mergerSort(int[] arr, int first, int last, int[] tmp) {
        if (first < last) {
            int mid = (first + last) / 2;
            //左边归并排序，使得左子序列有序
            mergerSort(arr, first, mid, tmp);
            //右边归并排序，使得右子序列有序
            mergerSort(arr, mid + 1, last, tmp);
            //将两个有序子数组合并操作
            mergeArray(arr, first, mid, last, tmp);

            System.out.println("排序中：" + printArr(arr));
        }
    }

    private void mergeArray(int[] arr, int first, int mid, int last, int[] tmp) {
        int i = first, j = mid + 1;  // i 左指针序列，j 右指针序列
        int t = 0;

        while (i <= mid && j <= last) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }

        //将左边剩余元素填充进temp中
        while (i <= mid) {
            tmp[t++] = arr[i++];
        }
        //将右边剩余元素填充进temp中
        while (j <= last) {
            tmp[t++] = arr[j++];
        }
        //将tmp中的元素全部拷贝到原数组中
        for (i = 0; i < t; i++) {
            arr[first + i] = tmp[i];
        }
    }

}
