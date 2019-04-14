package example;

import java.util.Scanner;

public class BlanClass {
	private static int Jincheng_Num;  //进程数
    private static int Ziyuan_Num;    //资源类数
    int[] Available;  //可利用资源
    int[][] Max;    //最大需求矩阵
    int[][] Allocation;    //已分配矩阵
    int[][] Need;      //需求矩阵
    int[] work; //初始值为Available，每次值都需要根据上一次计算
    int[][] Request;  //指定是哪个进程请求资源Request[进程名][资源数]
    int[] s;//安全序列
    int num = 0;//设置进程编号
    Scanner in = new Scanner(System.in);// 用于后续输入 in.nextInt()
    public void setJincheng_Num(int n){
        BlanClass.Jincheng_Num = n;
    }
    public void setZiyuan_Num(int m){
        BlanClass.Ziyuan_Num = m;
    }

    public BlanClass(int n,int m){
        setJincheng_Num(n);
        setZiyuan_Num(m);
        Available = new int[m];
        Max = new int[n][m];
        Allocation = new int[n][m];
        Need = new int[n][m];
        work = new int[m];
        Request = new int[n][m];
        s = new int[n];
    }

    public void setInit(){//设置各个矩阵初始值
        System.out.println("请输入avaliable");
        for(int i = 0;i < Ziyuan_Num;i++){
            Available[i] = in.nextInt();
        }
        setMax();
        setAlloction();
        print();
    }
    public void setMax(){
        System.out.println("请输入各个进程的最大需求量Max:");
        for(int i = 0;i < Jincheng_Num;i++){
            System.out.println("请输入进程p"+i+"的最大需求数量");
            for(int j = 0;j < Ziyuan_Num;j++){
                Max[i][j] = in.nextInt();
            }
        }
    }
    public void setAlloction(){
        System.out.println("请输入各个进程的Allocation");
        for(int i = 0;i < Jincheng_Num;i++){
            System.out.println("请输入进程p"+i+"的已分配资源");
            for(int j = 0;j < Ziyuan_Num;j++){
                Allocation[i][j] = in.nextInt();
            }
        }
        for(int i = 0;i < Jincheng_Num;i++){   //计算出Need矩阵
            for(int j = 0;j < Ziyuan_Num;j++){
                Need[i][j] = Max[i][j] - Allocation[i][j];
            }
        }
}
    public void print(){   //打印资源分配表
        System.out.println("资源分配如下");
        System.out.println("进程 "+" Max "+"Alocation"+" Need "+"Available");
        for(int i = 0;i < Jincheng_Num;i++){
            System.out.print("p"+i+"  ");
            for(int j = 0;j < Ziyuan_Num;j++){
                System.out.print(Max[i][j] + " ");
            }
            System.out.print("|");

            for(int j = 0;j < Ziyuan_Num;j++){
                System.out.print(Allocation[i][j] + " ");
            }
            System.out.print("|");
            for(int j = 0;j < Ziyuan_Num;j++){
                System.out.print(Need[i][j] + " ");
            }
            System.out.print("|");
            if(i == 0){
                for(int j = 0;j < Ziyuan_Num;j++){
                    System.out.print(Available[j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("检查t0时刻的安全性");
        //Safe();
    }
    public void InRequest(){  //输入某个进程的请求资源
        System.out.println("输入要请求资源的进程编号，进程编号从0开始");
        num = in.nextInt();
        System.out.println("输入请求资源的向量");
        for(int j = 0;j < Ziyuan_Num;j++){
            Request[num][j] = in.nextInt();
        }
        System.out.print("因此p"+num+"进程的资源请求为Request（");
        for (int j = 0; j < Ziyuan_Num; j++) {
            if (j == Ziyuan_Num - 1) {
                System.out.println(Request[num][j] + ").");
            } else
                System.out.print(+Request[num][j] + ",");
        }
        Request();
    }

    public void Request(){//资源请求算法
        int n = 0;
        int m = 0;
        for(int j = 0;j < Ziyuan_Num;j++){
            if(Request[num][j] <= Need[num][j])
                n++;
            if(Request[num][j] <= Available[j])
                m++;
        }
        if(n == Ziyuan_Num && m == Ziyuan_Num){
            for(int j = 0;j < Ziyuan_Num;j++){
                Available[j] -= Request[num][j];
                Allocation[num][j] += Request[num][j];
                Need[num][j] -= Request[num][j];
            }
            System.out.println("此时资源分配表为");
            print();
            System.out.println("利用安全性算法检测");
            Safe();
        }
        else if(n < Ziyuan_Num){
            System.out.println("出错，因为它所需要的资源数已超过它所提供的最大值");
        }
        else if(n == Ziyuan_Num && m < Ziyuan_Num){
            System.out.println("尚无足够资源需等待");
        }
    }
    public void Safe(){
        boolean[] Finish = new boolean[Jincheng_Num];
        for(int i = 0;i < Jincheng_Num;i++){
            Finish[i] = false;
        }
        int count = 0;//设置完成进程数
        int circle = 0;//记录while循环循环条件，用来检测试分配后的安全性
        for(int j = 0;j < Ziyuan_Num;j++){
            work[j] = Available[j];
        }
        boolean T = true;
        while(count < Jincheng_Num){
            if(T){
                System.out.println("进程 "+"Work  "+"Need "+"Allocation "+"Work+Allocation");
                T = false;
            }
            int m = 0;
            for(int i = 0;i < Jincheng_Num;i++){
                for(int s = 0;s < Ziyuan_Num;s++){
                    if(Need[i][s] <= work[s])
                        m++;
                }
                if(Finish[i] == false && m == Ziyuan_Num)
                {
                    System.out.print("p"+i+" ");
                    for(int j = 0;j < Ziyuan_Num;j++){
                        System.out.print(work[j]+" ");
                    }
                    System.out.print("|");

                    for(int j = 0;j < Ziyuan_Num;j++){
                        work[j] += Allocation[i][j];
                    }
                    Finish[i] = true;   //当前进程满足
                    s[count] = i;  //设置安全序列
                    count++; //满足条件进程+1
                    for(int j = 0;j < Ziyuan_Num;j++){
                        System.out.print(Need[i][j]+" ");
                    }
                    System.out.print("|");

                    for(int j = 0;j < Ziyuan_Num;j++){
                        System.out.print(Allocation[i][j]+" ");
                    }
                    System.out.print("|  ");
                    for(int j = 0;j < Ziyuan_Num;j++){
                        System.out.print(work[j]+" ");
                    }
                    System.out.println();
                }
                m = 0;
            }
            circle ++;
            if(count == Jincheng_Num){
                System.out.print("此时存在一个安全序列");
                for(int i = 0;i < Jincheng_Num;i++){
                    System.out.print("p"+s[i] +" ");
                }
                System.out.println(",所以可以完成分配");
                break;
            }
            if(count < circle){
                count = 5;
                System.out.println("系统处于不安全状态，故不存在安全序列");
                System.out.println("回复原来的状态：");
                for (int i = 0; i < Ziyuan_Num; i++) {
                    Available[i] += Request[num][i];
                    Allocation[num][i] -= Request[num][i];
                    Need[num][i] += Request[num][i];
                }
                print();
                break;
            }
        }
    }
}
