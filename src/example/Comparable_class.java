package example;

import java.util.Arrays;

/*比较器的使用
*ComparableTo()方法由Arrays.sort()自动调用
*如果以后要对对象进行比较排序，对象所在的类一定要实现Comparable类
*面试题：请解释Comparable和Comparator的区别？（请解释两种比较器的区别？）
*如果对象数组要进行排序，那么必须设置排序规则，可以使用Comparable或者Comparator来实现。
*java.lang.Comparable是在一个类定义的时候实现好的接口。这样本类的对象数组使用Comparable
*里提供的CompareTo()方法实现。
*java.util.Comparator是专门指定一个类的比较规则，属于挽救的比较操作。有一个
*public int compare()方法。
*/
class Books implements Comparable<Books>{
	private String name;
	private double price;
	public Books(String name,double price){
		this.name=name;
		this.price=price;
	}
	public String toString() {
		return "书的名字是"+this.name+",书的价格为"+this.price+"\n";
	}
	@Override
	public int compareTo(Books o) {
		if(this.price>o.price) {
			return 1;
		}else if(this.price<o.price) {
			return -1;
		}else {
		return 0;
		}
	}
	
}
public class Comparable_class {
	public static void main(String[] args) {
		Books[] books=new Books[] {
				new Books("java开发", 12.5),
				new Books("php开发", 26.5),
				new Books("oracle开发", 15.5),
				new Books("安卓开发", 10.5)
		};
		Arrays.sort(books);
		System.out.println(Arrays.toString(books));
		
		
		int data[]=new int[] {1,5,2,7,3,8,10,5}; 
		int data1[]=new int[] {7,5,2,7,3,8,10,5};
		//数组排序
		Arrays.sort(data);
		//数组二分查找
		System.out.println(Arrays.binarySearch(data, 3));
		//比较两个数组是否相等，比较时数组元素的顺序也应该相同
		System.out.println(Arrays.equals(data, data1));
		//数组填充
		int data2[]=new int[5];
		Arrays.fill(data2, 2);
		System.out.println(Arrays.toString(data2));
	}
}
