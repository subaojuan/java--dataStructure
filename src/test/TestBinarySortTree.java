package test;

public class TestBinarySortTree {
	public static void main(String[] args) {
		//int[] arr = new int[] { 7, 3, 10, 12, 5, 1, 9 };
		//int[] arr = new int[] { 8,9,6,7,5,4};
		//int[] arr= new int[] { 2,1,4,3,5,6};
		int[] arr= new int[] { 8,9,5,4,6,7};
		// 创建一颗二叉排序树
		BinarySortTree tree = new BinarySortTree();
		// 循环添加
		for (int i : arr) {
			tree.add(new BinarySortNode(i));
		}
		//查看树中的值
		tree.midShow();
		/*BinarySortNode node=tree.search(10);
		BinarySortNode node1=tree.search(12);
		System.out.println(node.data);
		System.out.println(node1.data);
		BinarySortNode node2=tree.parentSearch(12);
		System.out.println(node2.data);
		System.out.println("========================");
		//删除叶子节点
		tree.delete(12);
		tree.midShow();
		System.out.println("================================");
		tree.delete(10);
		tree.midShow();*/
		System.out.println("================================");
		tree.delete(7);
		tree.midShow();
		System.out.println(tree.root.height());
		System.out.println(tree.root.data);
	}
}
