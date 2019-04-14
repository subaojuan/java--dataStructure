package example;

/*线程命名
*主方法就是个线程（main线程），所以在主方法上建立的线程，都可以将其表示为子线程。
*每一个JVM启动的时候至少启动几个线程？
*两个：
*1.main线程（程序的主要执行，以及启动子线程）
*2.gc线程（负责垃圾回收）
*线程休眠：指的是让线程运行的速度变慢一点
*面试题：请解释多个线程访问同一资源时需要考虑到那些情况？有可能带来那些后果？
*1.多个线程访问同一资源时一定要处理好同步，可以使用同步代码块或者同步方法来实现。
*2.但是过多的使用同步，有可能会造成死锁。
*同步代码块:synchronized(锁定对象，即为当前对象){代码}
*同步方法：public synchronized 返回值  方法名（）{代码}
*/
class Mythread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+i);	
		}
		
	}

}

public class Xiancheng2 {
	public static void main(String[] args) {
		Mythread2 sts1 = new Mythread2();
		Mythread2 sts2 = new Mythread2();
		new Thread(sts1, "线程A").start();
		/*new Thread(sts1).start();
		new Thread(sts2).start();
		new Thread(sts1, "线程B").start();
		new Thread(sts2, "线程c").start();
		new Thread(sts1, "线程d").start();*/
		System.out.println(Thread.currentThread().getPriority());//主线程的优先级
		//主线程属于中等优先级
	}
}
