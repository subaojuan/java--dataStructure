package example;

import java.math.BigDecimal;
//实现准确位数的四舍五入操作
class MyMath1{
	public static double round(double num, int scale) {
		BigDecimal bigA = new BigDecimal(num);
		BigDecimal bigB = new BigDecimal(1);
		return bigA.divide(bigB, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}

public class BigDecimal_class {
	public static void main(String[] args) {
		System.out.println(MyMath1.round(13.254566, 3)); 
		System.out.println(MyMath1.round(-15.12359, 3));
	}
}
