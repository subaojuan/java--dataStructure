package test;

public class HuffNode implements Comparable<HuffNode> {
	Byte data;
	int weight;
	HuffNode left;
	HuffNode right;

	public HuffNode(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	// 排出来是倒序
	@Override
	public int compareTo(HuffNode o) {
		return o.weight - this.weight;
	}

	@Override
	public String toString() {
		return "HuffNode [data=" + data + ", weight=" + weight + "]";
	}
}
