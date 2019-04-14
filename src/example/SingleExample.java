package example;

public class SingleExample {
	private static final SingleExample INTANCE = new SingleExample();

	private SingleExample() {
	}

	public  static SingleExample getintance() {
		return INTANCE;
	}
	public void showMessage() {
		System.out.println("Hello,Word!!!!");
	}

	public static void main(String[] args) {
		SingleExample example=SingleExample.getintance();
		example.showMessage();
	}
}
/*程序特点：
 * 构造方法私有化，在类的内部定义static属性和方法，利用static方法取得本类的实例化对象。
 *这样不管外部产生多少个对象，但本质上永远只有一个实例化对象。
 *核心：一个类在一个程序中只产生一个实例化对象。
 * 
 * 
 * */
