package test;

import java.util.Arrays;

public class myQueue {
	private int[] array;
	public myQueue(){
		array=new int[0];
	}
	//入队
	public void add(int element) {
		int[] newarr=new int[array.length+1];
		for(int i=0;i<array.length;i++) {
			newarr[i]=array[i];
		}
		newarr[array.length]=element;
		array=newarr;
	}
	//出队
	public int poll() {
		int element=array[0];
		int[] newarr=new int[array.length-1];
		for(int i=0;i<array.length-1;i++) {
		newarr[i]=array[i+1];
		}
		array=newarr;
		System.out.println(Arrays.toString(array));
		return element;
	}
	//判断队列是否为空
	public boolean isEmpty() {
		return array.length==0;
		
	}
}
