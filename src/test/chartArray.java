package test;

public class chartArray {
	public static void main(String[] args) {
		String str = "abAAsghadgda";
		String str1="Abasghadgda";
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
		String strr="  stst  hellow   ";
		//去掉字符串左右两边的空格
		System.out.println("您好"+strr.trim()+"好的");   //您好stst  hellow好的
		//一般用户输入时可能会携带多余的空格，接收后需要处理掉
		String str3="@@##shgsh$$&&";
		String str2="hello world";
		String str5="120.26.1.2";
		String str4="sss hhh ddd ggg hhh";
		//判断是否是以某一串字符开头的，返回值为true或者false
		System.out.println(str3.startsWith("@@##"));
		//指句首空出两个位置后，是不是以某串字符开头的
		System.out.println(str3.endsWith("&&"));
		System.out.println(str3.endsWith("$$"));
		//字符串替换函数
		System.out.println(str2.replaceAll("ll","**"));
		System.out.println(str2.replaceFirst("l", "@"));
		//字符串截取
		System.out.println(str2.substring(3));   //lo world
		System.out.println(str2.substring(0, 3));   //hel
		//字符串拆分
		String result[]=str4.split(" ");   //按空格进行拆分
		String result5[]=str5.split("\\."); 
		String result1[]=str4.split("");   //默认按字符单个拆分
		for (int i = 0; i < result5.length; i++) {
			System.out.println(result5[i]);
		}
		//字符串查询
		System.out.println(str3.startsWith("##",2));
		System.out.println(str2.indexOf("llo"));   //2
		System.out.println(str2.lastIndexOf("l"));   // 9
		System.out.println(str2.indexOf("xx"));        //-1
		if(str2.contains("s")) {    //返回值为true或者false
		System.out.println("查询到数据");
		}else {
			System.out.println("没有查询到数据");
		}
		//区分大小写
		System.out.println(str.equals(str1));
		//不区分大小写
		System.out.println(str.equalsIgnoreCase(str1));
		//判断返回值大小是大于0还是小于0或者等于零
		System.out.println(str1.compareTo(str));
		System.out.println(str.charAt(0));
		byte[] array=str.getBytes();
		for (int i = 0; i < array.length; i++) {
			array[i]-=32;
		}
		System.out.println(new String(array));
		System.out.println(new String(array,3,5));
		if (isNumber(str)) {
			System.out.println("此字符串由纯数字组成");
		} else {
			System.out.println("此字符串不是全由数字组成");
		}
	}

	public static boolean isNumber(String str) {
		char[] data = str.toCharArray();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < '0' || data[i] > '9') {
				return false;
			}
		}
		return true;
	}
}
