package com.rxx.arithmetic;

import org.junit.Test;

/**
 * @Title      :Queue
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月16日 下午5:39:49
 */

class Queue{
	
	private int maxSize;
	private long[] queueArray;
	private int front;
	private int rear;
	private int size;
	
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.queueArray = new long[maxSize];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
	}
	
	/**
	 * 添加
	 * @param val
	 */
	public void add(long val){
		size++;
		if(rear == maxSize - 1){
			rear = -1;
		}
		queueArray[++rear] = val;
	}
	/**
	 * 删除
	 * @return
	 */
	public long remove(){
		size--;
		if(front == maxSize){
			front = 0;
		}
		return queueArray[front++];
	}
	
	/**
	 * 查看队头
	 * @return
	 */
	public long peekFront(){
		return queueArray[front];
	}
	
	/**
	 * 队列是否已满
	 * @return
	 */
	public boolean isFull(){
		return size == maxSize;
	}
	
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 队列中元素的数量
	 * @return
	 */
	public int size(){
		return size;
	}
}
public class QueueTest {

	@Test
	public void tetsQueue(){
		int maxSize = 10;
		Queue queue = new Queue(maxSize);
		System.out.print(queue.isEmpty() + "\t");
		System.out.print(queue.isFull() + "\t");
		System.out.println(queue.size() + "\t");
		
		for (int i = 1; i < maxSize + 1; i++) {
			queue.add(i);
		}
		System.out.println(queue.peekFront() + "\t");
		System.out.print(queue.isEmpty() + "\t");
		System.out.print(queue.isFull() + "\t");
		System.out.println(queue.size() + "\t");
		
		for (int i = 0; i < maxSize; i++) {
			System.out.print(queue.remove() + "\t");
		}
		System.out.println();
		System.out.print(queue.isEmpty() + "\t");
		System.out.print(queue.isFull() + "\t");
		System.out.println(queue.size() + "\t");
	}
}
