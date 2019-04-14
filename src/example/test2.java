package example;

class X{
	public void print() {
		System.out.println("------A类中的自定义方法------");
	}
	public void print2() {
		System.out.println("----A类中自定义的方法----");
	}
}

class Y extends X {
	public void print() {
		System.out.println("----B类中的覆写方法----");
	}

	public void print1() {
		System.out.println("----B类中的自定义方法----");
	}
}

public class test2 {
	// 对象的多态性：向上转型（子类对象->父类对象）
	// 向下转型（父类对象->子类对象）
	public static void main(String[] args) {
		Y y=new Y();
		X x=y;
		x.print();
		y.print2();
	
		/*X x=new Y();
		Y y=(Y)x;
		y.print();
		y.print1();
		y.print2();*/
	}
}
