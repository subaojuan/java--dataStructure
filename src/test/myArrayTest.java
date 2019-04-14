package test;

public class myArrayTest {
	public static void main(String[] args) throws Exception {
		myArray arr = new myArray();
		System.out.println(arr.getLength());
		arr.add(20);
		arr.add(25);
		arr.add(30);
		arr.add(45);
		arr.show();
		arr.delete(2);
		System.out.println(arr.get(2));
		System.out.println("=========================");
		arr.insert(2, 27);
		arr.set(2, 29);
		arr.show();
		int index=arr.search(45);
		System.out.println(index);
		System.out.println("=========================");
		int index1=arr.binarySearch(29);
		System.out.println(index1);
	}
}
