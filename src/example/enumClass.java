package example;
interface Message1{
	public String getTitle();
}
enum Color implements Message1{
	RED("红色"){
		public String getTitle2() {
			return "自己的"+this;
		}
	},GREEN("绿色"){
		public String getTitle2() {
			return "自己的"+this;
		}
	},PINK("粉色"){
		public String getTitle2() {
			return "自己的"+this;
		}
	};
	private String title;
	private Color(String title) {
		this.title=title;
	}
	public String toString() {
		return this.title;
	}
	@Override
	public String getTitle() {
		return this.title;
	}
	public abstract String getTitle2(); 
}
/*面试题：请解释enum与Enum的区别？
 * enum是一个关键字，而Enum是一个抽象类。
 * 使用enum枚举的类就相当于一个类继承了Enum类
 * 在枚举类中还可以写入抽象方法
 * 但是枚举类中的每一个类都要覆写抽象方法
 */
public class enumClass {
	public static void main(String[] args) {
		System.out.println(Color.RED.getTitle2());
		for(Color c:Color.values()) {
			System.out.println("序号是："+c.ordinal()+",枚举名为"+c.name());
		}
		Color color=Color.RED;
		Color color1=Color.GREEN;
		Color color2=Color.PINK;
		System.out.println(color);
		System.out.println(color1);
		System.out.println(color2);
		for (Color c:Color.values()) {
			System.out.println(c);
		}
		//实现接口方法
		Color msg=Color.RED;
		System.out.println(msg.getTitle());
	}
}
