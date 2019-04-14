package test;

public class TestBinaryTree {
	public static void main(String[] args) {
		// 创建一棵树
		BinaryTree bintree = new BinaryTree();
		// 创建根节点
		TreeNode root = new TreeNode(1);
		bintree.setRoot(root);
		TreeNode leftNode = new TreeNode(2);
		root.setleftNode(leftNode);
		TreeNode rightNode = new TreeNode(3);
		root.setrightNode(rightNode);
		leftNode.setleftNode(new TreeNode(4));
		leftNode.setrightNode(new TreeNode(5));
		rightNode.setleftNode(new TreeNode(6));
		rightNode.setrightNode(new TreeNode(7));
		// 遍历这棵树
		// 前序遍历
		// bintree.frontShow();
		// 中序遍历
		 bintree.middleShow();
		// 后序遍历
		// bintree.afterShow();
		// 前序查找
//		TreeNode five = bintree.frontSearch(5);
//		System.out.println(five);
//		 删除结点
//		bintree.delete(1);
//		bintree.frontShow();
		System.out.println("=================================");
		bintree.threadNodes();
		bintree.thredIterator();
	}
}
