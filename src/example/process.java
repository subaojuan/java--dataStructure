package example;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class process {
	// 允许的最大进程数
	public static int maxNum = 100;
	// 真正的进程数
	public static int realNum;
	// 各进程到达时间
	public static int arrivalTime[] = new int[maxNum];
	// 各进程服务时间
	public static int serviceTime[] = new int[maxNum];
	// 各进程完成时间
	public static int finishTime[] = new int[maxNum];
	// 各进程的周转时间
	public static int wholeTime[] = new int[maxNum];
	// 各进程的带权周转时间
	public static double[] weightWholeTime = new double[maxNum];
	// fcfs的平均周转时间
	public static double averageWT_fcfs;
	// fcfs的平均带权周转时间
	public static double averageWWT_fcfs;
	// fcfs的周转时间的总和
	public static int sumWT_fcfs = 0;
	// fcfs的带权周转时间的总和
	public static double sumWWT_fcfs = 0;

	public static Scanner stdin;
	// 进程到达时间
	private static int time[] = new int[maxNum];
	// 时间片
	public static int timeSlice = 0;
	// 进程是否已经结束的标志
	public static boolean finished[] = new boolean[maxNum];
	// 个进程服务时间（用于记录进程服务时间随时间片轮转减少的过程）
	public static int PserviceTime[] = new int[maxNum];
	// 进程调度队列
	public static int order[] = new int[maxNum];
	// order数组的一个下标
	public static int number;
	// 当前时间
	public static int nowTime;
	// 平均周转时间，平均带全周转时间
	public static double averageWT, averageWWT;
	// 优先数
	public static int priority[] = new int[maxNum];

	public static void main(String[] args) throws FileNotFoundException {

		Scanner stdin = new Scanner(System.in);
		// 算法选择
		System.out.println("请输入算法：1.先来先服务 2.时间片轮转3.优先权调度");
		int choice = stdin.nextInt();
		if (choice == 1) {
			System.out.println("请输入进程数：");
			// 真实进程数
			realNum = stdin.nextInt();
			// 各进程到达时间
			System.out.println("请输入各进程的到达时间");
			for (int i = 0; i < realNum; i++) {
				arrivalTime[i] = stdin.nextInt();
			}
			// 各进程服务时间
			System.out.println("请输入个进程的服务时间");
			for (int j = 0; j < realNum; j++) {
				serviceTime[j] = stdin.nextInt();
			}
			stdin.close();
			FCFS();
		} else if (choice == 2) {
			System.out.println("请输入进程数：");
			// 真实进程数
			realNum = stdin.nextInt();
			System.out.println("请输入时间片大小：");
			timeSlice = stdin.nextInt();
			if (realNum < 1) {
				System.out.println("当前没有进程可用");
			}
			// 各进程到达时间
			System.out.println("请输入各进程的到达时间");
			for (int i = 0; i < realNum; i++) {
				time[i] = stdin.nextInt();
			}
			// 各进程服务时间
			System.out.println("请输入各进程服务时间");
			for (int i = 0; i < realNum; i++) {
				serviceTime[i] = stdin.nextInt();
				PserviceTime[i] = serviceTime[i];
				finished[i] = false;
			}
			stdin.close();
			TimeslLice();
		} else if (choice == 3) {
			System.out.println("请输入进程数：");
			// 真实进程数
			realNum = stdin.nextInt();
			// 优先级数
			System.out.println("优先级大小：");
			for (int i = 0; i < realNum; i++) {
				priority[i] = stdin.nextInt();
			}
			// 各进程到达时间
			System.out.println("请输入各进程的到达时间");
			for (int i = 0; i < realNum; i++) {
				arrivalTime[i] = stdin.nextInt();
			}
			// 各进程服务时间
			System.out.println("请输入各进程服务时间");
			for (int i = 0; i < realNum; i++) {
				serviceTime[i] = stdin.nextInt();
			}
			stdin.close();
			PriorityAlgorithm();
		} else {
			System.out.println("算法选择错误");
		}
	}

	public static void FCFS() {
		sort();
		finishTime[0] = arrivalTime[0] + serviceTime[0];
		wholeTime[0] = serviceTime[0];
		weightWholeTime[0] = (double) wholeTime[0] / serviceTime[0];
		averageWT_fcfs = averageWWT_fcfs = 0;
		averageWT_fcfs = averageWT_fcfs + wholeTime[0];
		averageWWT_fcfs = averageWWT_fcfs + weightWholeTime[0];
		// 从第二个进程开始计算完成时间，周转时间，带权周转时间
		for (int j = 1; j < realNum; j++) {
			// 该进程是否在等待a
			if (arrivalTime[j] > finishTime[j - 1]) {
				finishTime[j] = arrivalTime[j] + serviceTime[j];
				wholeTime[j] = serviceTime[j];
			} else {
				// 该进程已在等待
				finishTime[j] = finishTime[j - 1] + serviceTime[j];
				wholeTime[j] = finishTime[j - 1] - arrivalTime[j] + serviceTime[j];
			}
			weightWholeTime[j] = (double) wholeTime[j] / serviceTime[j];
		}
		// 计算总的周转时间，总的带权周转时间
		for (int i = 0; i < realNum; i++) {
			sumWT_fcfs = sumWT_fcfs + wholeTime[i];
			sumWWT_fcfs = sumWWT_fcfs + weightWholeTime[i];
		}
		// 平均周转时间
		averageWT_fcfs = (double) sumWT_fcfs / realNum;
		// 平均带全周转时间
		averageWWT_fcfs = (double) sumWWT_fcfs / realNum;
		outPut(1);
	}

	// 到达时间进行冒泡排序，完成时间随之变动，（先到这排在前面，后到者排在后面）
	public static void sort() {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < realNum - 1; i++) {
			for (int j = 0; j < realNum - 1; j++) {
				if (arrivalTime[j] > arrivalTime[j + 1]) {
					temp1 = arrivalTime[j];
					temp2 = serviceTime[j];
					arrivalTime[j] = arrivalTime[j + 1];
					serviceTime[j] = serviceTime[j + 1];
					arrivalTime[j + 1] = temp1;
					serviceTime[j + 1] = temp2;
				}
			}
		}
	}

	public static void outPut(int a) {
		DecimalFormat format = new DecimalFormat("#.00");
		System.out.println("到达时间：");
		for (int k = 0; k < realNum; k++) {
			System.out.println(arrivalTime[k] + "");
		}
		System.out.println("");
		System.out.println("服务时间：");
		for (int k = 0; k < realNum; k++) {
			System.out.println(serviceTime[k] + "");
		}
		System.out.println("");
		System.out.println("完成时间：");
		for (int k = 0; k < realNum; k++) {
			System.out.println(finishTime[k] + "");
		}
		System.out.println("");
		System.out.println("周转时间：");
		for (int k = 0; k < realNum; k++) {
			System.out.println(wholeTime[k] + "");
		}
		System.out.println("");
		System.out.println("带权周转时间：");
		for (int k = 0; k < realNum; k++) {
			System.out.println((weightWholeTime[k] + ""));
		}
		System.out.println("");
		if (a == 1) {
			System.out.println("平均周转时间：" + format.format(averageWT_fcfs));
			System.out.println("平均带全周转时间：" + format.format(averageWWT_fcfs));
		}
		System.out.println("时刻" + arrivalTime[0] + "：进程" + 1 + "开始运行");
		for (int i = 1; i < realNum; i++) {
			System.out.println("时刻" + finishTime[i - 1] + ":进程" + (i + 1) + "开始运行");
		}
	}

	public static void TimeslLice() {
		int all_add = 1;// 就绪队列中的进程个数
		order[0] = 0;// 进程调度队列
		number = 1;
		nowTime = 0;
		while (order[0] != 100) {
			// 调度程序
			char w = 'A';
			System.out.println("时刻" + nowTime + ":进程" + (char) (w + order[0]) + "开始运行");
			// 进程还未完成
			if (PserviceTime[order[0]] > timeSlice) {
				// 对应的进程的服务时间减去一个时间片
				PserviceTime[order[0]] = PserviceTime[order[0]] - timeSlice;
				// 现在时间对应增加一个时间片
				nowTime += timeSlice;
				System.out.println("时刻" + nowTime + ":进程" + (char) (w + order[0]) + "停止运行，加入就绪序列尾");
			} else {
				// 进程剩一个时间片后结束
				// 现在时间增加一个时间片
				nowTime += PserviceTime[order[0]];
				// 对应进程的服务时间归0
				PserviceTime[order[0]] = 0;
				System.out.println("时刻" + nowTime + ":进程" + (char) (w + order[0]) + "运行结束");
				finishTime[order[0]] = nowTime;
				wholeTime[order[0]] = nowTime - arrivalTime[order[0]];
				weightWholeTime[order[0]] = 1.0 * wholeTime[order[0]] / serviceTime[order[0]];
			}
			// 将到达事件后仍未运行完的进程加入序列尾
			if (all_add < realNum) {
				for (int i = 0; i < realNum; i++) {
					// 判断该进程是否已经在就绪队列中
					if (nowTime >= arrivalTime[i] && finished[i] == false) {
						order[number++] = i;
						all_add++;
						finished[i] = true;
					}
				}
			}
			// 将序列首程序调到序列尾
			int temp = order[0];
			// 将order中的每个数前移一位
			for (int i = 0; i < number - 1; i++) {
				order[i] = order[i + 1];
			}
			// 进程已将全部调度结束，通过将order的第一个数标记为100，来结束进程调度
			if (PserviceTime[temp] == 0) {
				order[--number] = 100;
			} else {
				order[number - 1] = temp;
			}
		}
		double allwhole = 0, allweightwhole = 0;
		// 计算总周转时间和总带权周转时间
		for (int i = 0; i < realNum; i++) {
			allwhole += wholeTime[i];
			allweightwhole += weightWholeTime[i];
		}
		System.out.println("\n进程名\t到达时间\t服务时间\t完成时间\t周转时间\t带权周转时间");
		for (int i = 0; i < realNum; i++) {
			System.out.println((char) (i + 'A') + "\t" + arrivalTime[i] + "\t" + serviceTime[i] + "\t" + finishTime[i]
					+ "\t" + wholeTime[i] + "\t" + weightWholeTime[i]);
		}
		averageWT = allwhole / realNum;
		System.out.println("平均周转时间：" + averageWT);
		averageWWT = allweightwhole / realNum;
		System.out.println("平均带权周转时间为：" + averageWWT);
	}

	public static void PriorityAlgorithm() {
		prioritySort(priority);
		finishTime[0] = arrivalTime[0] + serviceTime[0];
		wholeTime[0] = serviceTime[0];
		weightWholeTime[0] = (double) wholeTime[0] / serviceTime[0];
		averageWT_fcfs = averageWWT_fcfs = 0;
		averageWT_fcfs = averageWT_fcfs + wholeTime[0];
		averageWWT_fcfs = averageWWT_fcfs + weightWholeTime[0];
		Ssort();
		// 从第二个进程开始计算完成时间，周转时间，带权周转时间
		for (int j = 1; j < realNum; j++) {
			// 该进程是否在等待a
			if (arrivalTime[j] > finishTime[j - 1]) {
				finishTime[j] = arrivalTime[j] + serviceTime[j];
				wholeTime[j] = serviceTime[j];
			} else {
				// 该进程已在等待
				finishTime[j] = finishTime[j - 1] + serviceTime[j];
				wholeTime[j] = finishTime[j - 1] - arrivalTime[j] + serviceTime[j];
			}
			weightWholeTime[j] = (double) wholeTime[j] / serviceTime[j];
		}
		// 计算总的周转时间，总的带权周转时间
		for (int i = 0; i < realNum; i++) {
			sumWT_fcfs = sumWT_fcfs + wholeTime[i];
			sumWWT_fcfs = sumWWT_fcfs + weightWholeTime[i];
		}
		// 平均周转时间
		averageWT_fcfs = (double) sumWT_fcfs / realNum;
		// 平均带全周转时间
		averageWWT_fcfs = (double) sumWWT_fcfs / realNum;
		outPut(1);
	}

	private static void prioritySort(int[] array) {
		for (int i = 1; i < realNum; i++) {
			if (array[i + 1] < array[i]) {
				int temp = array[i + 1];
				array[i + 1] = array[i];
				array[i] = temp;
			}
		}

	}

	public static void Ssort() {
		int temp1 = 0;
		if (priority[0] >priority[1]) {
			temp1 = priority[0];
			 priority[0] = priority[1];
			 priority[1] = temp1;
		}
	}

}
