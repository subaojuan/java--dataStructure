package test;

public class myQueueTest {
	public static void main(String[] args) {
		myQueue queue=new myQueue();
		queue.add(25);
		queue.add(35);
		queue.add(45);
		queue.add(55);
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
	}
	
}
