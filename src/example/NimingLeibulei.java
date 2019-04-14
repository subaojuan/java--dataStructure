package example;

interface BS {
	// public void print();

	//public void print1(String s);
	
	public int add(int x,int y);
		
}

public class NimingLeibulei {
	public static void main(String[] args) {
		/*
		 * fun(new BS() { 
		 * public void print() { 
		 * System.out.println("这是一个匿名内部类方法");
		 *  } 
		 *  });
		 */
		/*
		 * 这里使用了lamda表达式 lamda的三种形式 （参数）->(单行语句) （参数）->{多行语句} （参数）->表达式
		 */

		// fun(()->System.out.println("这是一个匿名内部类方法"));
		// 接受变量，执行语句
		/*fun1((s) -> {
			//执行多行语句的情况
			s = s.toUpperCase();
			System.out.println(s);
		});*/
		
		//对变量所做的操作是表达式
		//利用lamda表达式最终解决了匿名内部类定义过多的无用操作。
		fun2((s1,s2)->s1+s2);
	}

	/*
	 * public static void fun(BS bs) { 
	 * bs.print();
	 * }
	 */
	/*public static void fun1(BS bss) {
		bss.print1("hello word");// 设置参数内容
	}*/
	
	public static void fun2(BS bs) {
		System.out.println(bs.add(10, 15));	
		}
}
