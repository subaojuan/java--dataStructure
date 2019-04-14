package test;

public class huffmanNode implements Comparable<huffmanNode> {
	int data;
	int left;
	int right;

	public huffmanNode(int data) {
		this.data = data;
	}

	// 排序算法
	@Override
	public int compareTo(huffmanNode o) {
		// 从小到大排序
		return -(this.data - o.data);
	}

	@Override
	public String toString() {
		return "huffmanNode [data=" + data + "]";
	}

}
