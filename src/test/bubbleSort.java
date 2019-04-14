package test;

import java.util.Arrays;

public class bubbleSort {
public static void main(String[] args) {
	int[] array=new int[] {25,24,26,2,3,12,46};
	bubbleSort(array);
	System.out.println(Arrays.toString(array));
}
/*25,24,26,2,3,12,46
 * 24,25,2,3,12,26,46
 * 
 * 
 * */
public static void bubbleSort(int[] arr) {
	for(int i=0;i<arr.length-1;i++) { //要比较length-1轮
		//每一轮要比较arr.length-1-i次
		for(int j=0;j<arr.length-1-i;j++) {
			if(arr[j]>arr[j+1]) {
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
}
}
