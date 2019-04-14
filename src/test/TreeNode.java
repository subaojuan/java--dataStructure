package test;

public class TreeNode {
	int data;
	TreeNode leftNode;
	TreeNode rightNode;
	// 标识指针类型
	int leftType;
	int rightType;

	public TreeNode(int data) {
		this.data = data;
	}

	public void setleftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public void setrightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public void frontShow() {
		System.out.println(data);
		if (leftNode != null) {
			leftNode.frontShow();
		}
		if (rightNode != null) {
			rightNode.frontShow();
		}
	}

	public void middleShow() {
		if (leftNode != null) {
			leftNode.middleShow();
		}
		System.out.println(data);
		if (rightNode != null) {
			rightNode.middleShow();
		}
	}

	public void afterShow() {
		if (leftNode != null) {
			leftNode.afterShow();
		}
		if (rightNode != null) {
			rightNode.afterShow();
		}
		System.out.println(data);

	}

	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		// 对比当前节点的值
		if (this.data == i) {
			return this;
			// 当前节点不是要查找的值
		} else {
			// 查找左儿子
			if (leftNode != null) {
				target = leftNode.frontSearch(i);
			}
			// 可能查得到，可能查不到
			if (target != null) {
				return target;
			}
			if (rightNode != null) {
				target = rightNode.frontSearch(i);
			}
			if (target != null) {
				return target;
			}
		}
		return null;
	}

	// 删除子树
	public void delete(int i) {
		TreeNode parent = this;
		if (parent.leftNode != null && parent.leftNode.data == i) {
			parent.leftNode = null;
			return;
		}
		if (parent.rightNode != null && parent.rightNode.data == i) {
			parent.rightNode = null;
			return;
		}
		// 递归检查并删除左儿子
		parent = leftNode;
		if (parent != null) {
			parent.delete(i);
		}
		// 递归检查并删除右儿子
		parent = rightNode;
		if (parent != null) {
			parent.delete(i);
		}
	}
}
