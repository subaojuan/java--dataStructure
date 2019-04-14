package test;

//二叉排序树
//BST（BinarySortTre）   
//排序二叉树指的是每一个节点的左子节点的值都比当前节点的值小，右子节点的值都比当前节点的值大
public class BinarySortNode {
	int data;
	BinarySortNode left;
	BinarySortNode right;

	public BinarySortNode(int data) {
		this.data = data;
	}

	// 返回当前节点的高度
	public int height() {
		return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;

	}

	// 获取左子树高度
	public int leftHeight() {
		if (left == null) {
			return 0;
		}
		return left.height();
	}

	// 获取右子树高度
	public int rightHeight() {
		if (right == null) {
			return 0;
		}
		return right.height();
	}

	// 向树中添加节点
	public void add(BinarySortNode node) {
		if (node == null) {
			return;
		}
		// 判断传入的值比当前节点的值大还是小
		if (node.data < this.data) {
			// 如果左节点为空
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
		// 查询是否平衡
		// 进行右旋转
		if (leftHeight() - rightHeight() >= 2) {
			// 双旋转
			if (left != null && left.leftHeight() < left.rightHeight()) {
				//先左旋转
				left.leftRotate();
				//再右旋转
				rightRotate();
				//单旋转
			} else {			
				rightRotate();
			}
		}
		// 左旋转
		if (leftHeight() - rightHeight() <= -2) {
			if(right!=null&&right.rightHeight()<right.leftHeight()) {
				//先右旋转
				right.rightRotate();
				//再左旋转
				leftRotate();
				//单旋转
			}else {
			leftRotate();
			}
		}
	}

	private void leftRotate() {
		// 创建一个新节点，值等于当前节点的值
		BinarySortNode newleft = new BinarySortNode(data);
		// 把新节点的右子树设置为当前节点的右子树
		newleft.left = left;
		// 把新节点的左子树设置为当前节点的左子树的右子树
		newleft.right = right.left;
		// 把当前节点的值换为左子节点的值
		data = right.data;
		// 把当前节点的左子树设置为当前节点的左子树的左子树
		right = right.right;
		// 把当前节点的右子树设置为新节点
		left = newleft;

	}

	// 右旋转
	private void rightRotate() {
		// 创建一个新节点，值等于当前节点的值
		BinarySortNode newright = new BinarySortNode(data);
		// 把新节点的右子树设置为当前节点的右子树
		newright.right = right;
		// 把新节点的左子树设置为当前节点的左子树的右子树
		newright.left = left.right;
		// 把当前节点的值换为左子节点的值
		data = left.data;
		// 把当前节点的左子树设置为当前节点的左子树的左子树
		left = left.left;
		// 把当前节点的右子树设置为新节点
		right = newright;

	}

	public void midShow(BinarySortNode node) {
		if (node == null) {
			return;
		}
		midShow(node.left);
		System.out.println(node.data);
		midShow(node.right);
	}

	// 查找结点
	public BinarySortNode search(int data) {
		if (this.data == data) {
			return this;
		} else if (data < this.data) {
			if (left == null) {
				return null;
			}
			return left.search(data);
		} else {
			if (right == null) {
				return null;
			}
			return right.search(data);
		}
	}

	// 搜索父节点
	public BinarySortNode parentSearch(int data) {
		if (this.left != null && this.left.data == data || this.right != null && this.right.data == data) {
			return this;
		} else {
			if (this.data > data && this.left != null) {
				return this.left.parentSearch(data);
			} else if (this.data < data && this.right != null) {
				return this.right.parentSearch(data);
			}
		}
		return null;
	}
}
