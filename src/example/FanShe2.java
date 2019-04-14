package example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Chicken {
	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Chicken(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Chicken() {

	}

	@Override
	public String toString() {
		return "猫猫的名字是" + this.name + "，年龄是" + this.age;
	}
}

// 利用反射调用有参构造方法
public class FanShe2 {
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("example.Chicken");
			Constructor<?> cons = cls.getConstructor(String.class, int.class);
			Object obj = cons.newInstance("小花", 10);
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 利用反射调用普通方法
		String filedName = "name";
		try {
			Class<?> cls1 = Class.forName("example.Chicken");
			Object objj = cls1.newInstance();
			Method setMet = cls1.getMethod("set" + initcap(filedName), String.class);
			Method getMet = cls1.getMethod("get" + initcap(filedName));
			setMet.invoke(objj, "火火");
			System.out.println(getMet.invoke(objj));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 利用反射访问类属型的值
		String filedName1 = "age";
		try {
			Class<?> cls2 = Class.forName("example.Chicken");
			Object obj1 = cls2.newInstance(); // 必须给出实例化对象
			Field ageFiled = cls2.getDeclaredField(filedName1); // 获取成员变量
			ageFiled.setAccessible(true); // 取消封装
			ageFiled.set(obj1, 10);
			System.out.println(ageFiled.get(obj1));
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String initcap(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);

	}
}
