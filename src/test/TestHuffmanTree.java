package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 7, 8, 29, 5, 11, 23, 14 };
		huffmanNode node = createHuffman(arr);
		System.out.println(node);
	}

	// 创建赫夫曼树
	public static huffmanNode createHuffman(int arr[]) {
		// 先使用数组中所有的元素创建若干个二叉树。（只有一个节点）
		List<huffmanNode> nodes = new ArrayList<>();
		for (int data : arr) {
			nodes.add(new huffmanNode(data));
		}
		// 循环处理
		while (nodes.size() > 1) {
			// 排序
			Collections.sort(nodes);
			// 取出来权值最小的两个二叉树
			// 取出权值最小的二叉树
			huffmanNode left = nodes.get(nodes.size() - 1);
			huffmanNode right = nodes.get(nodes.size() - 2);
			// 创建一颗新的二叉树
			huffmanNode parent = new huffmanNode(left.data + right.data);
			// 把取出来的两个二叉树移除
			nodes.remove(left);
			nodes.remove(right);
			// 放入原来的二叉树集合中
			nodes.add(parent);
		}
		return nodes.get(0);
	}

}
