package example;
import java.util.LinkedList;
import java.util.Scanner;

public class Memory {
	// 内存大小
	private int size;
	// 最小剩余分区大小
	private static final int MIN_SIZE = 5;
	// 内存分区
	private LinkedList<Zone> zones;
	// 上次分配的空闲区位置
	private int pointer;

	// 分区节点类
	class Zone {
		// 分区大小
		private int size;
		// 分区始址
		private int head;
		// 空闲状态
		private boolean isFree;

		public Zone(int head, int size) {
			this.head = head;
			this.size = size;
			this.isFree = true;
		}
	}

	// 默认内存大小为512k
	public Memory() {
		this.size = 512;
		this.pointer = 0;
		this.zones = new LinkedList<Zone>();
		zones.add(new Zone(0, size));
	}

	public Memory(int size) {
		this.size = size;
		this.pointer = 0;
		this.zones = new LinkedList<Zone>();
		zones.add(new Zone(0, size));
	}

	// 内存分配
	// 指定需要分配的大小
	public void allocation(int size) {
		System.out.println("1:首次适应算法            2:最佳适应算法");
		System.out.println("请选择分配算法：");
		Scanner in = new Scanner(System.in);
		int way = in.nextInt();
		switch (way) {
		case 1:
			firstFit(size);
			break;
		case 2:
			bestFit(size);
			break;
		default:
			System.out.println("请重新选择算法：");
		}
	}

	// 首次适应算法
	// 指定需要分配的大小
	private void firstFit(int size) {
		// 遍历分区链表
		for (int pointer = 0; pointer < zones.size(); pointer++) {
			Zone temp = zones.get(pointer);
			// 找到可用分区（空闲且大小足够）
			if (temp.isFree && (temp.size > size)) {
				doAllocation(size, pointer, temp);
				return;
			}
		}
		// 遍历结束，未找到可用分区，内存分配失败
		System.out.println("无可用内存空间");
	}

	// 最佳适应算法
	// 指定需要分配的内存大小
	private void bestFit(int size) {
		int flag = -1;
		int min = this.size;
		for (pointer = 0; pointer < zones.size(); pointer++) {
			Zone temp = zones.get(pointer);
			if (temp.isFree && (temp.size > size)) {
				if (min > temp.size - size) {
					min = temp.size - size;
					flag = pointer;
				}
			}
		}
		if (flag == -1) {
			System.out.println("无可用内存空间");
		} else {
			doAllocation(size, flag, zones.get(flag));
		}
	}

	// 执行分配
	// 申请大小（size）
	// 当前可用分区位置（location）
	// 可用空闲区
	private void doAllocation(int size, int location, Zone temp) {
		// 如果分割后剩余分区大小过小，则将分区全部分配，否则分割为两个分区
		if (temp.size <= MIN_SIZE) {
			temp.isFree = false;
		} else {
			Zone split = new Zone(temp.head + size, temp.size - size);
			zones.add(location + 1, split);
			temp.size = size;
			temp.isFree = false;
		}
		System.out.println("成功分配" + size + "kB内存！");
	}

	// 内存回收
	// 指定要回收的分区号(id)
	public void collection(int id) {
		if (id >zones.size()) {
			System.out.println("无此分区编号");
			return;
		}
		Zone temp = zones.get(id);
		int size = temp.size;
		if (temp.isFree) {
			System.out.println("指定分区未被分配，无需回收");
			return;
		}
		//如果回收分区不是尾分区，且后一个分区为空闲，则与后一个分区合并
		if(id<zones.size()-1 && zones.get(id+1).isFree){
			Zone next=zones.get(id+1);
			temp.size+=next.size;
			zones.remove(next);
		}
		//如果回收区不是首分区，且前一个分区为空闲，则与前一个分区合并
		if(id>0 && zones.get(id-1).isFree){
			Zone previous=zones.get(id-1);
			previous.size+=temp.size;
			zones.remove(id);
			id--;
		}
		zones.get(id).isFree=true;
		System.out.println("内存回收成功！，本次回收了"+size+"kB空间");
	}
	//展示内存分区状况
	public void showZone(){
		System.out.println("===========================");
		System.out.println("分区编号\t分区始址\t分区大小\t空闲状态\t");
		System.out.println("===========================");
		for(int i=0;i<zones.size();i++){
			Zone temp=zones.get(i);
			System.out.println(i+"\t\t"+temp.head+"\t\t"+temp.size+"\t\t"+temp.isFree);
		}
		System.out.println("==============================");
	}
}
