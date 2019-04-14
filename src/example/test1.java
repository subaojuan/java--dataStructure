package example;

class Array {
	private int data[]; // 定义一个数组
	private int foot; // 表示数组的操作脚标

	public Array(int len) { // 构造本类对象时需要判断大小
		if (len > 0) {
			this.data = new int[len];
		} else {
			this.data = new int[1];
		}
	}

	public boolean Add(int num) {
		if (this.foot < this.data.length) { // 有空间保存
			this.data[this.foot++] = num; // 保存成功
			return true;
		}
		return false;
	}

	public int[] getData() {
		return this.data;
	}
}

class sortArray extends Array {
	// Array里没有无参构造方法
	public sortArray(int len) {
		// 这样父类中的data数组就可以初始化
		super(len); // 明确的调用父类的有参构造方法
	}

	// 因为父类继承的该方法不够本类使用
	// 所以要将此方法进行覆写，将此方法的功能扩充
	public int[] getData() {
		java.util.Arrays.sort(super.getData());
		return super.getData();
	}
}

class ReverseArray extends Array {
	public ReverseArray(int len) {
		super(len);
	}

	public int[] getData() { // 需要得到反转数据
		int center = super.getData().length / 2;
		int head = 0;
		int tail = super.getData().length - 1;
		for (int i = 0; i < center; i++) {
			int temp = super.getData()[head];
			super.getData()[head] = super.getData()[tail];
			super.getData()[tail] = temp;
			tail--;
			head++;
		}
		return super.getData();

	}
}

public class test1 {
	public static void main(String[] args) {
		// Array arr = new Array(5);
		// sortArray arr = new sortArray(3);
		ReverseArray arr = new ReverseArray(5);
		System.out.println(arr.Add(100));
		System.out.println(arr.Add(250));
		System.out.println(arr.Add(30));
		System.out.println(arr.Add(50));
		System.out.println(arr.Add(80));
		int[] temp = arr.getData();
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
}
