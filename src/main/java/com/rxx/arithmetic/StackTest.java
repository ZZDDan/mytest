package com.rxx.arithmetic;

import org.junit.Test;

/**
 * @Title      :StackTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年1月16日 下午4:39:38
 */

class Stack{
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}
	
	/**
	 * 入栈
	 * @param val
	 */
	public void push(char val){
		stackArray[++top] = val;
	}
	
	/**
	 * 出站
	 * @return
	 */
	public char pop(){
		return stackArray[top--];
	}
	
	/**
	 * 查看
	 * @return
	 */
	public char peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == maxSize - 1;
	}
}

public class StackTest {
	
	@Test
	public void testReversStr(){
		String str = "zhang";
		Stack stack = new Stack(str.length());
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		for (int i = 0; i < str.length(); i++) {
			System.out.print(stack.pop());
		}
	}
	
	@Test
	public void testBrackets() {
		String str = "{a[b(c)d]e]f";
		Stack stack = new Stack(str.length());
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '{' || c == '[' || c == '(' ){
				stack.push(c);
			}else if((c == ')' && '(' == stack.peek()) ||
			   (c == ']' && '[' == stack.peek()) || 
			   (c == '}' && '{' == stack.peek())){
				stack.pop();
			}
		}
		if(stack.isEmpty()){
			System.out.println("符号匹配");
		}else{
			System.out.println("符号不匹配");
		}
	}
}
