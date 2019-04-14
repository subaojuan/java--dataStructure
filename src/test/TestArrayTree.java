package test;

public class TestArrayTree {
	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree tree = new ArrayBinaryTree(array);
		tree.frontShow();
	}
}
