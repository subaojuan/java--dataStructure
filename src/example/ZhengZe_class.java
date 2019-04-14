package example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhengZe_class {
	public static void main(String[] args) {
		// 将字符转转变为字符数组，而后判断每一个字符串是否在“0~9”之间。
		String str = "12345sh34dajsk44aGDHhggha55H--=%^88%&$&%00^%$#$";
		char data[] = str.toCharArray();
		System.out.println(isNumber(data));
		System.out.println(str.matches("\\d+"));
		// 将不是小写字母的字符全部替换为空字符
		String regex = "[^a-z]";
		System.out.println(str.replaceAll(regex, ""));
		// 利用正则表达式拆分
		String regex1 = "\\d+";
		//String result[] = str.split(regex1);
		
		//使用Java自带的java.util.regex.pattern类来实现
		Pattern pattern=Pattern.compile(regex1);  //编译正则
		
		String[] result=pattern.split(str);  //拆分字符串
		
		Matcher mat=pattern.matcher(str);    //进行正则匹配
		System.out.println(mat.matches());
		/*for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}*/
		System.out.println(Arrays.toString(result));
		
		// 验证一个字符串是否为数字，如果是则将其变为double型
		String str1 = "11024554458754.2345";
		String regex2 = "\\d+(\\.\\d+)?";
		if (str1.matches(regex2)) {
			double d = Double.parseDouble(str1);
			System.out.println(d);
		}

		// 判断一个给定字符串是否是一个IP地址（IPV4）
		String str2 = "192.168.1.223";
		String regex3 = "(\\d{1,3}\\.){3}\\d{1,3}";
		System.out.println(str2.matches(regex3));

		// 给定一个字符串，要求判断其是否为日期格式，如果是则将其转换为Date型数据
		String str3 = "2019-01-24";
		String regex4 = "\\d{4}(\\-\\d{2}){2}";
		if (str3.matches(regex4)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(str3);
				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * 判断电话号码一般编写电话号码以下几种格式都是满足的 5283346 \\d{7,8} 010-5283346 (\\d{3,4}-)?\\d{7,8}
		 */

		// 验证email地址
		String str4 = "2967254652@126.cn";
		String regex5 = "[a-zA-Z][a-zA-Z0-9_\\.]{0,28}[a-zA-Z]@\\w+\\.(net|cn|com\\.cn|net\\.cn|org|gov|edu)";
		System.out.println(str4.matches(regex5));
	}

	public static boolean isNumber(char[] data) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] < '0' || data[i] > '9') {
				return false;
			}
		}
		return true;
	}
}
