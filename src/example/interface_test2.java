package example;
//接口在工厂模式中的应用
interface Fruit {
	public abstract void Eat();
}

class Apple implements Fruit {
	public void Eat() {
		System.out.println("*******吃苹果");
	}
}
class Orange implements Fruit{

	public void Eat() {
	System.out.println("*********吃橘子");	
	}
	
}
class Factory{
	public static Fruit getInstance(String className) {
		if("apple".equals(className)) {
			return new Apple();
		}else if("orange".equals(className)) {
			return  new Orange();
		}else {
			return null;
		}
	}
}
public class interface_test2 {
	public static void main(String[] args) {
			Fruit f=Factory.getInstance("orange");
			f.Eat();
	}
}
