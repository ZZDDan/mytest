package com.rxx.arithmetic;

import org.junit.Test;

/**
 * @Title      :PiorityQueueTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月17日 上午10:43:35
 */
class PriorityQueue{

	private int maxSize;
	private long[] queueArray;
	private int size;
	public PriorityQueue(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.queueArray = new long[maxSize];
		this.size = 0;
	}
	
	/**
	 * 小的数据在上面（队头），大的数据在下面（队尾--下标为0）
	 * @param key
	 */
	public void add(long key){
		if(size == 0){
			queueArray[size] = key;
		}else{
			int i = size - 1;
			for(; i > - 1; i--){
				if(key > queueArray[i]){
					queueArray[i + 1] = queueArray[i];
				}else{
					break;
				}
			}
			queueArray[i + 1] = key;
		}
		size++;
	}
	
	public long remove(){
		return queueArray[--size];
	}
	
	public long peekMin(){
		return queueArray[size - 1];
	}
	
	public long size(){
		return size;
	}
	
	public boolean isFull(){
		return size == maxSize;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
}

public class PriorityQueueTest {
	
	@Test
	public void testPriorityQueue() {
		PriorityQueue queue = new PriorityQueue(10);
		System.out.print(queue.isEmpty() + "\t");
		System.out.println(queue.isFull() + "\t");
		
		for (int i = 1; i <= 9; i++) {
			queue.add(i);
		}
		queue.add(3);
		System.out.print(queue.isEmpty() + "\t");
		System.out.print(queue.isFull() + "\t");
		System.out.println(queue.size() + "\t");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(queue.remove() + "\t");
		}
		System.out.println();
		System.out.print(queue.isEmpty() + "\t");
		System.out.println(queue.isFull() + "\t");
		
	}
}
