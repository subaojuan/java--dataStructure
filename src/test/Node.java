package test;

public class Node {
	// 节点中存放的数据
	int data;
	// 下一个节点
	Node next;
	//如果要变成循环链表
	//Node next=this;
	public Node(int data) {
		this.data = data;
	}

	// 为节点追加节点
	public Node append(Node node) {
		// 当前节点
		Node currentNode = this;
		// 循环向后找
		while (true) {
			// 取出下一个节点
			Node nextNode = currentNode.next;
			if (nextNode == null) {
				break;
			}
			currentNode = nextNode;
		}
		// 把需要追加的结点追加为当前节点的下一个节点
		currentNode.next = node;
		return this;
	}

	// 获取下一个节点
	public Node next(Node node) {
		return node.next;
	}

	// 获取节点中的数据
	public int getData() {
		return this.data;
	}

	// 判断当前结点是否为最后一个节点
	public boolean isLast() {
		return next == null;
	}

	// 删除一个节点
	public void removeNode() {
		Node newNode = next.next;
		this.next = newNode;
	}

	// 显示所有节点信息
	public void show() {
		Node currentNode = this;
		while (true) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
			if (currentNode == null) {
				break;
			}
		}
	}

	// 往单链表中插入节点
	public void after(Node node) {
		//当前节点的next结点变为next的next结点
		Node nextNext = next;
		//新插入节点给当前节点的next结点
		this.next = node;
		//当前结点的next的next结点变成新插入节点的next结点
		node.next = nextNext;
	}
}
