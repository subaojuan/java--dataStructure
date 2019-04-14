package test;


public class myStackTest {
	public static void main(String[] args) {
		myStack ms=new myStack();
		ms.push(25);
		ms.push(35);
		ms.push(18);
//		System.out.println(ms.pop());
//		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.isEmpty());
	}
}
