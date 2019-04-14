package example;

/*java中为了方便用户，使用户快速获得数据，为基本数据类型这只了一组包装类，使其转换为对象
*byte(Byte),short(Short),int(Integer),float(Float),double(Double),long(Long),blooean(Boolean)
*char(Character)
*装箱操作：将基本类变为包装类，每个包装类的构造方法都可以接受各自数据类型的变量
*拆箱操作：从包装类中去除被包装的数据。利用Number类中的一系列方法xxxValue（）方法
*java1.5版本之后才提供了自动装箱自动给拆箱功能。
*基本数据类型与字符串的相互转换操作
*将字符串转为单个字符，Number里没有提供方法，但可以使用str.charAt(数组下标)实现
*字符串转为基本数据类型：依靠包装类中的方法paseInt(),parseDouble,paseBoolean
*基本数据类型转换为字符串：str.ValueOf(基本数据类型)
*java中常用的系统包：
*java.lang:包含了String ，Object，Integer等类，系统会自动导入。
*java.lang.reflact:反射开发包，可以用于框架开发。
*java.util:java的工具包，提供了大量的工具类，像链表。
*java.util.regex:正则工具包
*java.text:国际化处理程序包
*java.io:进行输入输出以及文件处理的包
*java.net:网络编程开发包
*java.sql:数据库程序开发包
*java.applet:Applet程序开发包（现在已经不用了），用于做动态网页，现在用javascript
*/
public class ZhuangChaiXiang {
	public static void main(String[] args) {
		Integer obj = new Integer(10); // 将基本数据类型装箱
		int temp = obj.intValue();
		System.out.println(temp * 2);
		Double d = new Double(20.0);
		double dd = d.doubleValue();
		System.out.println(dd - 5);

		Boolean flag = new Boolean(true);
		boolean f = flag.booleanValue();
		System.out.println(f);
		
		String str="12345";
		int a=Integer.parseInt(str);
		System.out.println(a*2);
		double b=Double.parseDouble(str);
		System.out.println(b+2);
		
		char s=str.charAt(2);
		System.out.println(s);

		//基本数据类型转为String
		int c=100;
		System.out.println(c+"");
		String ss=String.valueOf(c);
		System.out.println(ss+10);
	}

}
