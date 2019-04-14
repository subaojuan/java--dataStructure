package test;

import java.util.Arrays;
import java.util.Stack;

public class myStack {
	private int[] array;

	public myStack() {
		array = new int[0];
	}

	// 向栈中压入元 素
	public void push(int element) {
		int[] newarr = new int[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newarr[i] = array[i];
		}
		newarr[array.length] = element;
		array = newarr;
	}

	// 取出栈顶元素
	public int pop() {
		int element = array[array.length - 1];
		int[] newarr = new int[array.length - 1];
		for(int i=0;i<array.length-1;i++) {
			newarr[i]=array[i];
		}
		array=newarr;
		return element;
	}

	// 查看栈顶元素
	public int peek() {
		return array[array.length-1];

	}

	// 栈是否为空
	public boolean isEmpty() {
		return array.length==0;
	}
}
