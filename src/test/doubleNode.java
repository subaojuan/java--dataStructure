package test;

public class doubleNode {
//双向链表，既记录上一个结点，也记录下一个节点，是循环链表
	//上一个节点
	doubleNode pre;
	//下一个节点
	doubleNode next;
	//节点数据
	int data;
	public doubleNode(int data) {
	this.data=data;
	}
	//如何增加结点
	public void after(doubleNode node) {
	//当前节点的next结点变成当前节点的next的next结点
	doubleNode nextNext=next;
    //新插入节点变成当前节点的next结点
	this.next=node;
	//当前节点变成新插入节点的上一个节点
	node.pre=this;
	//当前结点的next的next结点变成新插入节点的next结点
	node.next=nextNext;
	//新插入节点是当前节点的next的next结点的前一个节点
	nextNext.pre=node;
	}
	//获取下一个节点
	public doubleNode getnext() {
		return this.next;
	}
	//获取上一个节点
	public doubleNode getPro() {
		return this.pre;	
	}
	//获取节点数据
	public int getdata() {
		return this.data;	
	}
}
