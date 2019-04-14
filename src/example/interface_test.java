package example;

//接口定义:如果一个类中"只有"抽象方法和全局常量,我们将此类定义为一个接口类,接口类是一个特殊的抽象类.
//在java1.8之后，也允许在接口里定义普通方法，但必须用default修饰。
//由于接口里有抽象方法,所以不可以用new关键字直接实例化.
//接口类必须要有子类,子类可以使用implements关键字实现多个接口.
//接口的子类(如果不是抽象类),必须要覆写接口中的全部抽象方法
//接口的对象可以利用子类对象的向上转型进行实例化操作.
//接口可以被多继承,在java中,接口的主要功能是接口单继承问题.
interface AA {
	public static final String MSG = "sususuus"; // 全局常量

	public abstract void print(); // 抽象方法
	
	default void print2() {
		System.out.println("接口类中的普通方法实现了");
	}
	//除了可以使用default定义之外，还可以使用static定义，直接由类名称调用。
	static void print3() {
		System.out.println("在接口中直接用类名称调用的普通方法");
	}
}

interface BB {
	public abstract void get();
}
interface CC extends AA,BB{
	public abstract void print1();
}
//class XX implements AA, BB { // X覆写了A,B两个接口
class XX implements CC{
	public void get() {
		System.out.println("覆写B接口的方法");
	}

	public void print() {
		System.out.println("覆写A接口的方法");
	}

	public void print1() {
		
		System.out.println("覆写c接口双继承后的方法");
	}

}

public class interface_test {
	public static void main(String[] args) {
		XX x=new XX();  //实例化子类对象
		AA a=x;          //向上转型
		BB b=x;
		a.print();
		b.get();
		a.print2();
		AA.print3();
	}
}
