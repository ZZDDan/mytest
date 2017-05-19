package com.rxx.arithmetic;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * @Title      :SortTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月15日 下午5:14:32
 */
public class SortTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testRadixSort(){
		int[] arr = {14,60,212,12,5,8};
		System.out.println("排序前：" + printArr(arr));
		arr = radixSorting(arr, 3);
		System.out.println("排序后：" + printArr(arr));
	}
	
	// d为数据长度
	private int[] radixSorting(int[] arr, int d) {
		for (int i = 0; i < d; i++) {
			arr = countingSort(arr, i); // 依次对各位数字排序（直接用计数排序的变体）
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
			int d = getBitData(arr[i], figures);
			bucket[d]++;
		}
		// 记录排序结果
		for (int i = 1; i <= k; i++) {
			bucket[i] += bucket[i - 1];
		}
		// 输出排序结果
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
	public void testQuickSort(){
		int[] arr = {4,6,2,9,5,8};
		System.out.println("排序前：" + printArr(arr));
		quicksort(arr, 0, arr.length - 1);
		System.out.println("排序后：" + printArr(arr));
	}
	
	private void quicksort(int[] arr, int left, int right) {
		if(left < right){
            int key = arr[left];
            int low = left;
            int high = right;
            while(low < high){
                while(low < high && arr[high] > key){
                        high--;
                }
                arr[low] = arr[high];
                while(low < high && arr[low] < key){
                        low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = key;
            quicksort(arr,left,low-1);
            quicksort(arr,low+1,right);
		}
	}

	@Test
	public void testShellSort(){
		int[] arr = {4,6,2,9,5,8};
		System.out.println("排序前：" + printArr(arr));
		
		for(int gap = arr.length / 2; gap > 0; gap /= 2){
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < arr.length; j += gap) {
					if(arr[j] < arr[j - gap]){
						int tmp = arr[j];
						int k = j - gap;
						while(k >= 0 && tmp < arr[k]){
							arr[k + gap] = arr[k];
							k -= gap;
						}
						arr[k + gap] = tmp;
					}
				}
			}
		} 
		
		System.out.println("排序后：" + printArr(arr));
	}
	
	/**
	 * 冒泡排序
	 */
	@Test
	public void testBubbleSort(){
		int[] arr = {4,6,2,9,5,8};
		System.out.println("排序前：" + printArr(arr));
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if(arr[j] < arr[j - 1]){
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		System.out.println("排序后：" + printArr(arr));
	}
	
	@Test
	public void test(){
		int[] arr = {4,6,2,9,5,8};
		System.out.println("排序前：" + printArr(arr));
		System.out.println("排序后：" + printArr(arr));
	}
	
	/**
	 * 选择排序
	 */
	@Test
	public void testSelectSort(){
		int[] arr = {4,6,2,9,5,8};
		System.out.println("排序前：" + printArr(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]){
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		System.out.println("排序后：" + printArr(arr));
	}
	
	@Test
	public void testInsertionSort() {
		int[] arr = {4,6,2,9,5,8};
		
		System.out.println("排序前：" + printArr(arr));
		// sort
		for(int i = 1; i < arr.length; i++){
			int keyword = arr[i];
			int j = i-1;
			while(j >= 0 && keyword < arr[j]){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = keyword;
		}
		System.out.println("排序后：" + printArr(arr));
	}
	

	private String printArr(int[] arr){
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] + " ";
		}
		return result;
	}
}
