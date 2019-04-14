package example;
/*现成的第三种实现方法：
 *使用callable接口实现，可以接受线程运行的返回值
 * 必须覆写call（）方法
 * */

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class Mythread1 implements Callable<String> { // 线程操作类
	private int tackit = 10;

	@Override
	public String call() throws Exception {
		for (int i = 0; i < 10; i++) {
			if (this.tackit > 0) {
				System.out.println("卖票，票数=" + this.tackit--);
			}
		}
		return "票已卖光";
	}

}

public class Xiancheng1 {

	public static void main(String[] args) throws Exception {
		Mythread1 st1 = new Mythread1();
		Mythread1 st2 = new Mythread1();
		FutureTask<String> task1 = new FutureTask<>(st1);// 目的是为了取回call的返回结果
		FutureTask<String> task2 = new FutureTask<>(st2);
		// Futuretask是runnable类的接口子类，所以可以使用Thread类的构造来接受task对象
		new Thread(task1).start(); // 启动多线程
		new Thread(task2).start();
		// 多线程执行完毕后可以取得内容，使用futuretask的父接口future中的get（）方法
		System.out.println("A线程的返回结果是" + task1.get());
		System.out.println("B线程的返回结果是" + task2.get());
	}

}
