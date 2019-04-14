package example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data_class {
	public static void main(String[] args) throws ParseException {
		long cur=System.currentTimeMillis();
		Date date=new Date(cur);                 //long型数据转为date型
		System.out.println(date);
		System.out.println(date.getTime());      //date型数据转为long型
		//将date型数据转换为String型
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String str=sdf.format(date);
		System.out.println(str);
		
		//将String型转化为date型数据
		String str1="2001-11-11 11:11:11.111";
		Date date1=sdf.parse(str1);
		System.out.println(date1);
		
		//String.ValueOf("double b")将double型变量b转换为String型
		
		Calendar cal=Calendar.getInstance();  //获得本类对象
		StringBuffer buf=new StringBuffer();
		buf.append(cal.get(Calendar.YEAR)).append("-");
		buf.append(cal.get(Calendar.MONTH)+1).append("-");
		buf.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ");
		buf.append(cal.get(Calendar.HOUR_OF_DAY)).append(":");
		buf.append(cal.get(Calendar.MINUTE)).append(":");
		buf.append(cal.get(Calendar.SECOND)).append(" ");
		System.out.println(buf);
	}
}
