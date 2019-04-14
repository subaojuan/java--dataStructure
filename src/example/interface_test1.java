package example;
interface USB{
	public abstract void start();
	public abstract void stop();
}
class Computer{
	public void plugin(USB usb) {
		usb.start();
		usb.stop();
	}
}

class Flash implements USB{

	public void start() {
		System.out.println("U盘开始使用");	
	}

	public void stop() {
		System.out.println("U盘停止使用");
	}
	
}
class Print implements USB{

	public void start() {
		System.out.println("打印机开始工作");
	}

	public void stop() {
		System.out.println("打印机停止工作");
	}
	
}
public class interface_test1 {
	public static void main(String[] args) {
		Computer computer=new Computer();
	    computer.plugin(new Flash());
	    computer.plugin(new Print());
	}
	
}
