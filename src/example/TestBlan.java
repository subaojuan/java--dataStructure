package example;
import java.util.Scanner;
public class TestBlan {
		 public static void main(String[] args){
		        boolean flag = true;
		        Scanner in = new Scanner(System.in);
		        System.out.println("这是一个多进程，初始系统考虑n个进程的请求m类资源的银行家算法：");
		        System.out.println("输入进程数n");
		        int n = in.nextInt();
		        System.out.println("输入资源类数m");
		        int m = in.nextInt();
		        BlanClass T = new BlanClass(n,m);
		        T.setInit();
		        while(flag){
		            System.out.println("是否要进行资源请求:Yes输入1/No输入0");
		            if(in.nextInt()==1){
		                System.out.println("开始请求资源");
		                T.InRequest();
		            }
		            else{
		                flag = false;
		            }
		        }
		    }
}
