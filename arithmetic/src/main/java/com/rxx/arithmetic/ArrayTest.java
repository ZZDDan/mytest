package com.rxx.arithmetic;

import org.junit.Test;

/**
 * @Title      :ArrayTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月13日 下午5:46:24
 */
public class ArrayTest {
	
	/**
	 * 有序数组 线性查找
	 */
	@Test
	public void selectLinear(){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int key = 6;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == key){
				System.out.println("线性查找结果：arr[" + i + "]");
				return;
			}
		}
		System.out.println("没找到");
	}
	
	/**
	 * 有序数组 二分查找
	 */
	@Test
	public void selectBinary(){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		printArr(arr);
		int key = 6;
		
		int lowerBound = 0;
		int powerBound = arr.length - 1;
		int curIn = (lowerBound + powerBound)/2;
		while(true){
			if(key == arr[curIn]){
				System.out.println("二分查找结果：arr[" + curIn + "]");
				return;
			}else if(lowerBound > powerBound){
				System.out.println("没找到");
				return;
			}else if(key > arr[curIn]){
				lowerBound = curIn + 1;
			}else{
				powerBound = curIn - 1;
			}
			curIn = (lowerBound + powerBound)/2;
		}
	}

	/**
	 * 打印数组
	 * @param arr
	 */
	private void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	}
}
