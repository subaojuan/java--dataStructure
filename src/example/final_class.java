package example;

//final可以定义类，变量，方法，final类不能再有子类,final定义的方法不能被子类覆写
//使用final定义的变量就成为了常量，在定义是要设置好内容，一旦定义就不可改变。要求
//final中的常量名必须全是用大写
final class A {
	final double GOOD = 100.0; // final常量
	public static final String TEST = "ghdsafggf"; // 全局常量
	// static数据保存在公共数据区，所以也是公共常量

	public final void test() {

	}
}

public class final_class {
	public static void main(String[] args) {

	}
}
