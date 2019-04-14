package example;

import java.util.ResourceBundle;

//国际化程序操作
//资源文件：文件名首字母大写，后缀必须为“*.properties”
//通过ResourceBundle类可以读取指定classPath下的文件内容，读取时不需要输入文件后缀。
//动态的站为文本格式化：MessageFormat
//locale类用于指定读取的资源文件的语言环境
public class guoJiHua {

	public static void main(String[] args) {
	ResourceBundle rb=ResourceBundle.getBundle("Messages");
	String str=rb.getString("info");
	System.out.println(str);
	}

}
