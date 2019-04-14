package test;

public class NodeTest {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.append(n2);
		n1.append(n3);
		System.out.println(n3.data);
		System.out.println(n3.isLast());
		n1.show();
		n1.removeNode();
		n1.show();
		Node node=new Node(5);
		n1.after(node);
		n1.show();
		System.out.println("=========================");
		
	}
	
}
