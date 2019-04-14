package test;
class Book1{
	/*1.如果属性加上了static修饰，则修改一个属性值，所有对象的此属性值都会跟着一起被改变。
	 * 此static变量将会在内存中被放在全局数据区，static变量与普通变量最大的区别是保存的内存
	 * 区域不同，所有对象都会指向同一块内存区域。
	 * 2.static变量可以直接被对象的共有代表即类名进行访问
	 * 3.static与非static变量最大的区别是非static变量必须在实例化变量的情况下使用，而static
	 * 不受实例化控制。
	 * 4.static方法只能调用static实行和方法
	 * 非static方法可以访问static的属性和方法，不受任何限制。
	 * 5.如果此类中的属性较少或者没有属性，就可以把方法全部定义为static方法，可以避免实例化对
	 * 象操作。
	 * 6.内存去一共有四个区：堆区（属性），栈区（存地址），全局数据区（static数据），
	 * 全局代码区（所有方法）
	 * 代码块
	 * 普通块：在方法内部定义的块“{}”，以此括起来，用于区分在同一方法中的变量重名。
	 * 构造块：在类中直接定义的块“{}”，以此括起来，构造块先于构造方法执行，没实例化一个对象，
	 * 对应执行一次构造块和构造方法。
	 * 静态块：用static修饰的{}代码块
	 * （1）在非主类中定义的代码块：先于构造块执行，实例化多个对象，但只执行一次。用于static
	 * 属性的静态初始化操作。
	 * （2）在主类中定义的代码块：静态代码块将优先于主类方法执行
	 * 
	 * this.方法名()与super.方法名()方法调用的区别：
	 * this.方法名()会现在本类中寻找方法名相同的方法进行调用，如果找到了就调用，如果找不到
	 * 就去父类寻找，如果找到就调用，找不到就报错。
	 * super.方法名()会直接定位查找范围是父类中，如果父类中查不到就报错。
	 * 
	 * 方法覆写指的是方法名，参数类型即个数返回值类型都相同的方法。
	 * 重要的一点是private修饰的方法是不可以被覆写的。
	 * 
	 * 面试题：请解释重载与覆写的区别？（请解释overloading和overrid的区别），在使用重载时，
	 *        返回值类型可否不同？
	 * 1.发生范围不同，重载发生在一个类中，而覆写发生在继承关系中。
	 * 2.定义不同，重载指方法名相同，参数类型及个数不同，而覆写指方法名相同，
	 * 参数个数及个数，返回值类型都相同。
	 * 3.访问权限不同，重载没有权限限制，而覆写要求被覆写的方法不能拥有比
	 * 父类更为严格的访问控制权限。
	 * 可以不同，但考虑到程序设计的统一性，尽量做到一致。
	 * */
	private int id;
	private String name;
    static String pub="新华出版社";

	public Book1(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getInfo() {
		return "书编号为："+this.id+"，书名为："+this.name+"，出版社为："+this.pub;
	}
}
public class QuanJu {
	public static void main(String[] args) {
		Book1 book=new Book1(1, "java开发");
		Book1 book2=new Book1(2, "php开发");
		Book1 book3=new Book1(3, "python开发");
		//修改了一个属性的值
		//Book.pub="清华出版社";
		book.pub="清华出版社";
		System.out.println(book.getInfo());
		System.out.println(book2.getInfo());
		System.out.println(book3.getInfo());
	}
	
}
