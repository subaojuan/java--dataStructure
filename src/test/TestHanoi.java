package test;

public class TestHanoi {
	public static void main(String[] args) {
		/*
		 * n 盘子数 from 开始的柱子 in 中间的柱子 to 目标主子
		 */
		int n;
		char from;
		char in;
		char to;
		hannoi(3, 'A', 'B', 'C');
	}
	public static void hannoi(int n, char from, char in, char to) {
			if(n==1) {
				System.out.println("第1个盘子从"+from+"移到"+to);
			}else {
				hannoi(n-1, from, to, in);
				System.out.println("第"+n+"个盘子从"+from+"移到"+to);
				hannoi(n-1, in, from, to);
			}
	}
}
