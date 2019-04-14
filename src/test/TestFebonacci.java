package test;

public class TestFebonacci {
//递归输出打印斐波那契数列的前n项
	public static void main(String[] args) {
	//斐波那契数列：1 1 2 3 5 8 13 21 	
		int i=febonacci(6);
		System.out.println(i);
	}
	public static int febonacci(int i) {
		if(i==1 || i==2) {
			return 1;
		}else {
		return febonacci(i-1)+febonacci(i-2);
		}	
	}
}
