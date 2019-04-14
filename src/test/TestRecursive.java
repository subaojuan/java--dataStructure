package test;

public class TestRecursive {
//递归调用
	public static void main(String[] args) {
	print(5);	
	}
	public static void print(int i) {
		if(i>0) {
			//System.out.println(i);
			print(i-1);
			System.out.println(i);
		}
	}
}
