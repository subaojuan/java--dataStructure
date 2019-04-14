package example;

/*线程是进程的更小分支，占有更少的资源，进程结束则线程一定结束，线程结束进程未必结束
 * 线程一旦开始执行，不能够有返回值。
 * 多线程的三种实现方式
 * 继承Thread类  （java.lang）
 * 使用Thread类的start（）方法不仅仅要启动多线程的执行代码，还要去根据不同的操作系统进行资
 * 源分配,如果继承的是Thread类，则也继承了start（）方法。但runnable接口不可以。
 * 实现runnable接口（Callable接口）
 * runnable方法避免了单继承局限，在实际工作中使用runnable接口最好。
 * 面试题1：两种多线程实现方式的区别？
 *1.thread类是runnable类的字类，使用runnable接口与Thread类继承相比，解决了单继承的定义局限，如果要使用，
 *一定是用runnable接口。
 *2.使用runnable接口可以比thread类更好的描述出数据共享。此时的数据共享指多个线程访问同一资源。
 *面试题2：请写出多线程实现的两种操作。
 * */
//线程操作主类
//class MyThread extends Thread{
class MyThread implements Runnable {
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	// 在多线程的每个主体类中都必须覆写Thread提供的run()方法
	@Override
	public void run() {
		for (int i = 1; i < 200; i++) {
			System.out.println(this.name + "*****" + i);
		}
	}
}

public class Xiancheng { // 主类
	public static void main(String[] args) {
		MyThread st1 = new MyThread("线程1");
		MyThread st2 = new MyThread("线程2");
		MyThread st3 = new MyThread("线程3");
		/*st1.start(); // 启动多线程运行的方法
		st2.start();
		st3.start();*/
		//thread方法可以接受runnable对象，然后间接使用start方法实现。
		new Thread(st1).start();
		new Thread(st2).start();
		new Thread(st3).start();
	}
}
