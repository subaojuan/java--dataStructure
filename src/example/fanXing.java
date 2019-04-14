package example;
class Pag<T>{
	//范型变量
	public T name;
	public T age;
	public Pag(T age){
		this.age=age;
	}
	//泛型方法
	public <T> T getName(T name) {
		return name;
	}
}
public class fanXing {
	public static <T> void main(String[] args) {
		Pag<Integer> pag=new Pag<>(12);
		System.out.println(pag.age);
		System.out.println(pag.getName("susu"));
	}
}
