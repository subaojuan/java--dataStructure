package test;

import java.util.Arrays;

public class quickSort {
	public static void main(String[] args) {
		int[] array = new int[] { 25, 26, 2, 4, 15, 34, 56, 21 };	
		quickSort(0, array, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	private static void quickSort(int start, int[] array, int end) {
		int standard=array[start];
		int low=start;
		int high=end;
		while(low<high) {
		while(low<high && standard<=array[high]) {
			high--;
		}
		array[low]=array[high];
		while(low<high && array[low]<=standard) {
			low++;
		}
		array[high]=array[low]; 
	array[low]=standard;
		}
	}	
}
