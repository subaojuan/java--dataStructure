package example;

import java.io.IOException;

public class StringBuffer1 {
	/*String类一旦被定义，内容就不可改变，StringBuffer类的内容可以改变
	 * 面试题：请解释String，StringBuffer,StringBuilder的区别？
	 * String的内容一旦申明，则不可改变，而StringBuffer和StringBuilder申明的内容可以改变。
	 * StringBuffer提供的方法是同步方法，属于安全的线程操作，而StringBuilder提供的方法属于
	 * 异步方法，属于非线程安全的操作。
	 * 面试题：请解释什么叫GC？如何处理？
	 * gc是垃圾收集器，指的是释放无用的内存空间。
	 * gc会由系统不定期的进行自动调用来回收垃圾，或者调用runtime类中的gc（）方法手工回收。
	 * runtime是指当前运行状态信息，它可以运行本机程序。
	 * runtime类使用了单例设计模式，构造方法私有化，需要采用内部的getruntime()方法获得类对象。
	 * */
	public static void main(String[] args) throws IOException, InterruptedException{
		StringBuffer sb=new StringBuffer("hi,...");
		//删除部分数据，首尾截取
		sb.delete(3, 6);
		sb.append("susu").append("!!!");
		change(sb);
		//在指定位置插入数据
		sb.insert(0, "Why");
		//字符串反转
		System.out.println(sb.reverse());
		String sb1=sb.toString();    //StringBuffer类向String类的转换
		System.out.println(sb1);
		//比较内容的方法
		System.out.println("susu!!!你好！！".contentEquals(sb));
		
		Runtime run=Runtime.getRuntime();//取得runtime类的实例化对象
		Process pro=run.exec("phpStudy.exe");
		Thread.sleep(3000);
		pro.destroy();
	}
	public static void change(StringBuffer sb) {
		sb.append("你好！！");
	}
	
}
