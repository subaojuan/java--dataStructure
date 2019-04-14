package test;

import java.util.Arrays;
//常用算法之堆排序
//大点堆排序
public class HeapSort {
	public static void main(String[] args) {
		int[] array = new int[] { 9, 6, 8, 7, 0, 1, 10, 4, 2 };
		heapSort(array);
		System.out.println(Arrays.toString(array));
		
	}
	public static void heapSort(int[] array) {
		//开始位置为最后一个非叶子节点的父节点
		int start=(array.length-1)/2;
		//调为大点堆
		for (int i = start; i >=0; i--) {
			maxHeap(array, array.length,i);
		}
		//先把数组中的第0个和队中的最后一的交换位置，再把前面的处理为大点堆
		for (int i = array.length-1; i>0; i--) {
			int temp=array[0];
			array[0]=array[i];
			array[i]=temp;
			maxHeap(array, i, 0);
		}
	}
	public static void maxHeap(int[] array,int size,int index) {
		int leftNode=2*index+1;
		int rightNode=2*index+2;
		int max = index;
		if(leftNode<size && array[leftNode]>array[max]) {
			max=leftNode;
		}
		if(rightNode<size && array[rightNode]>array[max]) {
			max=rightNode;
		}
		if(max!=index) {
		int temp=array[index];
		array[index]=array[max];
		array[max]=temp;
		maxHeap(array, size,max);
		}
	}
}
