package example;
public class test {
	
	public static void main(String[] args) {
	Memory memory=new Memory();
	memory.allocation(300);
	memory.allocation(100);
	memory.collection(0);
	memory.allocation(150);
	memory.allocation(30);
	memory.allocation(40);
	memory.allocation(60);
	memory.collection(4);
	memory.showZone();
	
	}

}
