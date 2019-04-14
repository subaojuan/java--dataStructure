package example;

/*
 * 抽象类不能直接产生对象，抽象方法没有方法体，所以不能被实例化。
 * 抽象类必须有子类，必须被继承，抽象类的子类不是抽象类，但必须全部覆写抽象类方法
 * 抽象类的实例化需要借助子类来实现，采用向上转型的方式处理。
 * 抽象类的构造方法是先调用父类的，再调用子类的。
 * 抽象方法不能使用final定义，因为抽象类必须有子类。
 * 外部的抽象类不允许使用static申明，内部类可以使用static修饰
 * 抽象类的子类只能继承一个父类
 * */
abstract class Test3{
	public Test3() {
		System.out.println("------父类的构造方法-------");
	}
	public void fun() {
		System.out.println("这是一个普通方法");
	}
	//这是一个抽象方法，没有方法体。
	
	
	public abstract void print();
	
	//内部类
	static abstract class A{
		public abstract void print();
	}
}
//继承内部类
class B extends Test3.A{
	public void print() {
		System.out.println("----内部类的抽象方法覆写-----");
	}
	
}
class Test4 extends Test3{
	public Test4() {
		System.out.println("-----子类的构造方法-----");
	} 
	public void print() {
		System.out.println("这是一个对抽象方法的覆写方法");
	}
}
class Abstract_test {
	public static void main(String[] args) {
	/*Test4 test=new Test4();
	Test3 t=test;
	t.print();
	t.fun();
	test.fun();
	test.print();*/
	Test3 Test=new Test4();
	Test.fun();
	Test.print();
	
	Test3.A tt=new B();
	tt.print();
	
	}
}
