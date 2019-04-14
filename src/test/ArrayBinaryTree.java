package test;

/*顺序存储二叉树                                                                           1（0）
 * 只适用于满二叉树或者完全二叉树                              2（1）            3（2）
 * 左子节点：2*n+1	在数组中的下标		   4（3）5（4） 6（5） 7（6）
 * 右子节点：2*n+2
 * */
public class ArrayBinaryTree {
	int[] array;

	public ArrayBinaryTree(int[] array) {
		this.array = array;
	}
	public void frontShow() {
		frontShow(0);
	}
	public void frontShow(int index) {
		if(array==null || array.length==0) {
			return;
		}
		//先遍历当前节点的内容
		System.out.println(array[index]);
		//搜索遍历左子树
		if(2*index+1<array.length) {
			frontShow(2*index+1);
		}
		//搜索遍历右子树
		if(2*index+2<array.length) {
			frontShow(2*index+2);
		}
	}

}
