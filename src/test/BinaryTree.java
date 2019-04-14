package test;

public class BinaryTree {
	TreeNode root;
	// 用于临时存储前驱结点
	TreeNode pre = null;

	// 线索二叉树的遍历
	public void thredIterator() {
		// 用于临时存储当前遍历节点
		TreeNode node = root;
		while (node != null) {
			// 循环找到最开始的节点
			while (node.leftType == 0) {
				node = node.leftNode;
			}
			// 打印当前节点的值
			System.out.println(node.data);
			// 如果当前结点的指针指向的是后继节点，可能后继节点还有后继节点。
			while (node.rightType == 1) {
				node = node.rightNode;
				System.out.println(node.data);
			}
			// 替换遍历的结点
			node = node.rightNode;
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	// 设置根节点
	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// 中序线索二叉树
	public void threadNodes() {
		threadNodes(root);
	}

	public void threadNodes(TreeNode node) {
		if (node == null) {
			return;
		}
		threadNodes(node.leftNode);
		if (node.leftNode == null) {
			node.leftNode = pre;
			node.leftType = 1;
		}
		// 处理前驱结点的右指针，如果前驱节点的右节点为空
		if (pre != null && pre.rightNode == null) {
			// 让前驱结点的右指针指向当前节点
			pre.rightNode = node;
			// 改变前驱结点的右指针类型
			pre.rightType = 1;
		}
		pre = node;
		threadNodes(node.rightNode);
	}

	public void frontShow() {
		if (root != null) {
			root.frontShow();
		}
	}

	public void middleShow() {
		if (root != null) {
			root.middleShow();
		}
	}

	public void afterShow() {
		if (root != null) {
			root.afterShow();
		}
	}

	public TreeNode frontSearch(int i) {
		return root.frontSearch(i);

	}

	public void delete(int i) {
		if (root.data == i) {
			root = null;
		} else {
			root.delete(i);
		}
	}

}
