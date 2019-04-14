package example;

interface A_a {
	public void fun();
}

interface Message {
	public void print();
}

class B_b extends Object implements A_a {
	public void fun() {
		System.out.println("hello 你好！！！");
	}

}

class Book {
	private String name;
	private double price;

	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}

	// 对象比较方法
	public boolean equals(Object obj) {
		if (obj == null) { // 传入对象不能为空
			return false;
		}
		if (this == obj) { // 对象地址相等
			return true;
		}
		if (!(obj instanceof Book)) { // 传入的是非本类对象
			return false;
		}
		Book book = (Book) obj;
		if (this.name.equals(book.name) && this.price == book.price) {
			return true;
		}
		return false;
	}

	// 直接打印对象时，获取对象信息，系统会自动调用此函数
	public String toString() {
		return "书名为：" + this.name + "价格为：" + this.price;
	}
}

public class BookClass {
	public static void main(String[] args) {
		Book book = new Book("java开发", 12.5);
		Book book1 = new Book("java开发", 12.5);
		Book book3 = new Book("php开发", 11.0);
		System.out.println(book);
		System.out.println(book.equals(book1));
		System.out.println(book.equals(book3));

		// object接受数组对象
		Object obj = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(obj);
		if (obj instanceof int[]) {
			int[] data = (int[]) obj;
			for (int i = 0; i < data.length; i++) {
				System.out.println(data[i]);
			}
		}

		// object接受接口对象
		A_a a = new B_b(); // 接口对象
		Object obj1 = a; // 接受接口对象
		A_a t = (A_a) obj1; // 向下转型
		t.fun();

		// 匿名内部类,使用时，必须基于抽象类或者接口的使用
		fun(new Message() {
			public void print() {
				System.out.println("输出匿名内部类......");
			}
		});
	}

	public static void fun(Message msg) {
		msg.print();

	}
}
