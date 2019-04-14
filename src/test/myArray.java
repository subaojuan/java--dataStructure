package test;

import java.util.Arrays;

public class myArray {
	// 如果要存放任意类型数据，将int改为object即可。
	private int[] array;

	public myArray() {
		// 初始化长度为0
		array = new int[0];
	}

	// 获取数组长度的方法
	public int getLength() {
		return array.length;
	}

	// 末尾添加一个元素的方法
	public void add(int element) {
		int[] newarray = new int[array.length + 1];
		for (int i = 0; i <array.length; i++) {
			newarray[i] = array[i];
		}
		newarray[array.length] = element;
		array = newarray;
		System.out.println(Arrays.toString(array));
	}

	// 打印所有元素到控制台的方法
	public void show() {
		System.out.println(Arrays.toString(array));
	}

	// 删除数组中的元素
	public void delete(int index) throws Exception {
		if (index < 0 && index > array.length) {
			throw new RuntimeException("数组下表越界");
		}
		int[] newarr = new int[array.length - 1];
		for (int i = 0; i < newarr.length; i++) {
			if (i < index) {
				newarr[i] = array[i];
			} else {
				newarr[i] = array[i + 1];
			}
		}
		array = newarr;
		System.out.println(Arrays.toString(array));
	}

	// 取出指定位置元素
	public int get(int index) {
		return array[index];
	}

	// 如何插入一个元素到指定位置
	public void insert(int index, int element) {
		int[] newarr = new int[array.length + 1];
		if (index < 0 && index > newarr.length) {
			throw new RuntimeException("数组下表越界");
		}
		for (int i = 0; i < array.length; i++) {
			if (i < index) {
				newarr[i] = array[i];
			} else {
				newarr[i + 1] = array[i];
			}
		}
		newarr[index] = element;
		array = newarr;
		System.out.println(Arrays.toString(array));
	}

	// 替换指定位置元素
	public int set(int index, int element) {
		return array[index] = element;
	}
	//线性查找
	public int search(int target) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==target) {
				return i;
			}
		}
		return -1;		
	}
	//二分查找
	public int binarySearch(int target) {
		int begin=0;
		int end=array.length-1;
		int mid=(begin+end)/2;
		while(true) {
			if(begin>end) {
				return -1;
			}
			if(array[mid]==target) {
				return mid;
			}else {
				if(array[mid]>target) {
					end=mid-1;
				}else {
					begin=mid+1;
				}
			}
			mid=(begin+end)/2;
		}
	}
}
