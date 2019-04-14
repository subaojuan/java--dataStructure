package example;

import java.util.Date;
class Cat{
	public Cat(){
		System.out.println("*****无参构造方法******");
	}
	@Override
	public String toString() {
		return "这是一支猫猫";
	}
}
public class FanShe {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Date date = new Date();
		// 调用object中的getClass（）方法
		Class<?> cls = date.getClass();
		System.out.println(cls);
		// 使用“类.class”取得
		Class<?> cls1 = Date.class;
		System.out.println(cls1);
		// 调用Class类提供的一个方法
		Class<?> cls2;
		try {
			cls2 = Class.forName("java.util.Date");
			System.out.println(cls2);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Cat cat=new Cat();
		System.out.println(cat);
		
		//利用反射进行对象的实例化
		Class<?> cls3;
		try {
			cls3 = Class.forName("example.Cat");
			Object obj=cls3.newInstance();
			@SuppressWarnings("unused")
			Cat cat1=(Cat)obj;
			System.out.println(cat);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
