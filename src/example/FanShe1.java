package example;

interface Fruit1 {
	public void eat();
}

class Apple1 implements Fruit1 {
	public void eat() {
		System.out.println("****吃苹果****");
	}
}

class Orange1 implements Fruit1 {
	public void eat() {
		System.out.println("******吃橘子******");
	}
}

class Factory1 {
	//利用反射实现对象实例化，在工厂设计模式中，无需再修改工厂类
	public static Fruit1 getInstance(String className) {
		Fruit1 f = null;
		try {
			f = (Fruit1) Class.forName(className).newInstance();
		} catch (Exception e) {}
		return f;
	}
}

public class FanShe1 {
	public static void main(String[] args) {
		Fruit1 f = (Fruit1) Factory1.getInstance("example.Apple1");
		f.eat();
	}

}
