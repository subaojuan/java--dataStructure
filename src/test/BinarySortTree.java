package test;

public class BinarySortTree {
	BinarySortNode root;

	// 向二叉排序树中添加节点
	public void add(BinarySortNode node) {
		// 如果是一颗空树
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}

	// 中序遍历二叉排序树，从小到大的排序
	public void midShow() {
		if (root != null) {
			root.midShow(root);
		}
	}

	// 结点的查找
	public BinarySortNode search(int data) {
		if (root == null) {
			return null;
		}
		return root.search(data);
	}

	// 删除节点
	public void delete(int data) {
		if (root == null) {
			return;
		} else {
			// 找到这个节点
			BinarySortNode target = search(data);
			// 如果没有这个节点
			if (target == null) {
				return;
			}
			// 找到它的父节点
			BinarySortNode parent = parentSearch(data);
			// 要删除的结点是叶子节点
			if (target.left == null && target.right == null) {
				// 要删除的结点是父节点的左子节点
				if (parent.left.data == data) {
					parent.left = null;
				} else {
					// 要删除的节点是父节点的右子节点
					parent.right = null;
				}
				// 要删除的节点有两个子节点的情况
			} else if (target.left != null && target.right != null) {
				// 删除右子树中值最小的节点，获取到该节点的值
				int min = deleteMin(target.right);
				// 替换目标节点中的值
				target.data = min;
				// 要删除的节点有一个左子节点或者右子节点
			} else {
				// 有左子节点
				if (target.left != null) {
					// 要删除的节点是父节点的左子节点
					if (parent.left.data == data) {
						parent.left = target.left;
					} else {
						// 要删除的节点是父节点的右子节点
						parent.right = target.right;
					}
					// 有右子节点
				} else {
					// 要删除的节点是父节点的左子节点
					if (parent.left.data == data) {
						parent.left = target.right;
						// 要删除的节点是父节点的右子节点
					} else {
						parent.right = target.right;
					}
				}
			}
		}
	}

	// 删除一颗树中最小的节点
	private int deleteMin(BinarySortNode node) {
		BinarySortNode target = node;
		// 递归向左找
		while (target.left != null) {
			target = target.left;
		}
		// 删除这个最小的结点
		delete(target.data);
		return target.data;
	}

	// 搜索父节点的方法
	public BinarySortNode parentSearch(int data) {
		if (root == null) {
			return null;
		} else {
			return root.parentSearch(data);
		}
	}
}
