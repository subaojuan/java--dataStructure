package example;

import java.math.BigInteger;

public class System_class {
	/*面试题：请解释final，finally，finalize的区别？
	 * final：关键字，定义不能被继承的类，不能被覆写的方法，常量。
	 * finally：关键字，异常类的统一出口。
	 * finalize：Object类提供的方法（protected void finalize() throws throwable）指的是
	 * 对象回收前的收尾方法，即使出现了异常也不会导致程序中断。
	 * System.gc()是垃圾回收方法。
	 * 面试题：如果现在有两个很大的数要进行数学计算（超过了double范围），你该怎么做？
	 * 如果真的超过了double范围，肯定无法使用double进行保存，java类中提供了BigInteger和
	 * BigDecimal两个大数字操作类。
	 * 
	 * */
	public static void main(String[] args) {
		//system类可以用于获得当前系统时间
		//Long型用于定义日期时间，内存大小等数据。
		Long start=System.currentTimeMillis();
		String str=" ";
		for (int i = 0; i < 30000; i++) {
			str+=i;
		}
		Long end=System.currentTimeMillis();
		System.out.println("此次for循环运行时间为："+(end-start));
		
		
		
		BigInteger big1=new BigInteger("1234566885753555");
		BigInteger big2=new BigInteger("45244255");
		System.out.println("加法计算结果："+big1.add(big2));
		System.out.println("减法计算结果："+big1.subtract(big2));
		System.out.println("乘法计算结果："+big1.multiply(big2));
		System.out.println("除法计算结果："+big1.divide(big2));
		//除法的结果数组中只有两个元素，第一个是商，第二个是余数
		BigInteger result[]=big1.divideAndRemainder(big2);
		System.out.println("商为："+result[0]+"余数为："+result[1]);
	}
}
