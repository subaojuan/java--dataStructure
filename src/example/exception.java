package example;

/*四种访问控制权限：public protect default private
 * 在同一个类中：都可以访问
 * 在同一个包的不同类中：只有private不可以访问
 * 在不同包的子类：private default不可被访问
 * 在不同包的非子类中：只有public可以被访问
 * 
 * 
 * error和exception的父类是throwable
 * 面试题：请解释error与exception的区别？
 * error:指的是JVM错误，即此时程序还没有执行，用户无法处理异常。
 * exception:指的是程序运行中产生的错误，用户可以处理。
 * 面试题：请解释java中的异常处理流程？
 * 1.当程序在运行过程中，如果产生异常，JVM会根据异常的类型实例化出一个与之类型匹配的异常类对象。
 * 2.产生异常之后会判断当前的语句上是否存在有异常处理，如果没有会交给系统执行默认的异常处理程序。
 * （输出异常信息，结束程序调用）
 * 3.如果存在异常捕获语句，会由try语句来捕获产生的异常类实例化对象，然后与每一个catch语句进行比对，
 * 如果匹配，则异常处理，如果不匹配，则继续往下找。
 * 4.不管是否匹配成功，程序都要向后执行，继续执行finally语句，然后再根据之前的异常捕获情况执行操作，
 * 如果成功捕获异常，则经过处理之后继续执行后续代码，如果捕获失败，则交给JVM默认处理异常（输出异常
 * 信息，终止程序执行）
 *面试题：请解释throw和throws的区别？
 *throw指的是在方法中人为的抛出一个异常类对象（这个异常可能是自己实例化的，也可能是已存在的）
 *throws在方法的申明上使用，表示此方法在调用时必须处理异常。
 *
 *面试题：请解释Exception和runtimeException的区别？请列举出几个你常见的runtimeExceptin.
 *Exception是runtimeException的父类
 *使用Exception定义的异常必须要被处理，而runtimeException定义的异常可以选择性处理
 *ArithmeticException，NULLPointerException，ClassCastEception
 *assert关键字：主要的功能是进行断言，指的是程序执行到某行代码处时一定是预期的结果。
 *
 *
 * * */


class Mymath {
	public int div(int x, int y) throws Exception {
		int result = 0;
		System.out.println("************");
		try {
			result = x / y;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("#############");
		}
		return result;
	}
}

public class exception {
	public static void main(String[] args) {

		Mymath math = new Mymath();
		try {
			System.out.println(math.div(10, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

