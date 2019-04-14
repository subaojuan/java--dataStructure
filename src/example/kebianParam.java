package example;

/*可变参数
 * */
public class kebianParam {

	public static void main(String[] args) {
		int data[]=new int[] {1,2,3,4,5};
		int res=add(data);
		System.out.println(add(1,2,3,4));
		System.out.println(res);
	}

	//public static int add(int data[]) {   //传统实现
	public static int add(int...data) {	   // 可变参数实现
		int sum = 0;
		
		//传统的for循环
		/*for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}*/
		//Java1.5新特性foreach循环，简单方便
		for(int i:data) {
			sum+=i;
		}
		return sum;
	}

}
