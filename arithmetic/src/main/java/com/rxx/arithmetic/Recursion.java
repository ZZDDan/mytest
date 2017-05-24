package com.rxx.arithmetic;

import org.junit.Test;

/**
 * @Title      :Recursion
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月19日 下午3:03:59
 */
public class Recursion {
	
	@Test
	public void testMergerSort(){
		int[] arr = {5, 8, 2, 7, 6, 9, 3, 2};
		int[] tmp = new int[arr.length];
		mergerSort(arr, 0, arr.length - 1, tmp);
		for (int i = 0; i < tmp.length; i++) {
			System.out.print(tmp[i] + "\t");
		}
	}
	
	private void mergerSort(int[] arr, int first, int last, int[] tmp) {
		if(first < last){
			int mid = (first + last) / 2;
			mergerSort(arr, first, mid, tmp);    //左边有序  
			mergerSort(arr, mid + 1, last, tmp); //右边有序  
	        mergeArray(arr, first, mid, last, tmp); //再将二个有序数列合并  
		}
		
	}

	private void mergeArray(int[] arr, int first, int mid, int last, int[] tmp) {
	    int i = first, j = mid + 1;  
	    int m = mid,   n = last;  
	    int k = 0;  
	      
	    while (i <= m && j <= n){  
	        if (arr[i] <= arr[j]){  
	            tmp[k++] = arr[i++];  
	        }else{  
	            tmp[k++] = arr[j++];  
	        }
	    }  
	      
	    while (i <= m){ 
	        tmp[k++] = arr[i++];  
	    }
	    while (j <= n){  
	        tmp[k++] = arr[j++];  
	    }
	    for (i = 0; i < k; i++){ 
	        arr[first + i] = tmp[i];  
	    }
	}

	@Test
	public void testDoTower(){
		doTower(3, 'A', 'B', 'C');
	}
	
	private void doTower(int size, char from, char inter, char to) {
		// TODO Auto-generated method stub
		if(size == 1){
			System.out.println(from + " -> " + to);
			return;
		}else{
			doTower(size - 1, from, to, inter);
			System.out.println(from + " -> " + to);
			doTower(size - 1, inter, from, to);
		}
	}

	@Test
	public void testBinarySearch(){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(arr , 5, 0, arr.length - 1));
	}
	
	private int binarySearch(int[] arr, int key, int lowerBound, int upperBound){
		if(lowerBound > upperBound){
			return -1;
		}
		int middleBound = (lowerBound + upperBound) / 2;
		if(arr[middleBound] > key){//升序
			binarySearch(arr, key, lowerBound, middleBound - 1);
		}else if(arr[lowerBound] < key){
			binarySearch(arr, key, middleBound + 1, upperBound);
		}
		return middleBound;
	}
	
	
    private static  char[] words;  
    private static int count;  
    
    @Test
    public void testDoAnagrim(){

    	words="abcd".toCharArray();  
    	count=0;  
    	doAnagram(words.length);  
    	
    }
  
    private static void doAnagram(int newSize) {  
        if(newSize==1)  
            return;  
        for(int j=0; j<newSize; j++) {  
            doAnagram(newSize-1);  
            if(newSize==2)  
                displayWord();  
            rotate(newSize);  
        }  
    }  
  
  
    private static void rotate(int newSize) {  
        int j=words.length-newSize;  
        char temp=words[j];  
        for(; j+1<words.length; j++) {  
            words[j]=words[j+1];  
        }  
        words[j]=temp;  
    }  
  
  
    private static void displayWord() {  
        System.out.print(++count+":");  
        for(int j=0; j<words.length; j++) {  
            System.out.print(words[j]);  
        }  
        System.out.print("\t");  
        if(count%6==0)  
            System.out.println("");  
    }  
  
	
	@Test
	public void testFactorial(){
		/** 10！ = 10 * 9 * 8 * 7 * 6 *5 * 4 * 3 * 2 * 1 */
		for (int i = 1; i < 10; i++) {
			System.out.println(i + " * " + factorial(i - 1) + " = " + factorial(i));
		}
	}
	
	private long factorial(int n){
		if(n <= 1){
			return 1;
		}
		return n * factorial(n - 1);
	}

	/** 1, 3, 6, 10, 15, 21, ... */
	@Test
	public void testTriangle(){
		for (int i = 1; i <= 10; i++) {
			System.out.print(triangle(i) + "\t");
		}
	}
	
	private int triangle(int n){
		if(n == 1){
			return 1;
		}
		return n + triangle(n-1);
	}

}