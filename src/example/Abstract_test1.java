package example;
//抽象类的应用
abstract class Action {
	public final static int EAT = 1;
	public final static int SLEEP = 5;
	public final static int WORK = 7;

	public abstract void eat();

	public abstract void sleep();

	public abstract void work();

	public void commentd(int flag) {
		switch (flag) {
		case EAT:
			this.eat();
			break;
		case SLEEP:
			this.sleep();
			break;
		case WORK:
			this.work();
			break;
		case EAT + WORK:
			this.eat();
			this.work();
		}
	}
}

class Robat extends Action {
	public void eat() {
		System.out.println("机器人吃东西补充能量");
	}

	public void sleep() {
	}

	public void work() {
		System.out.println("机器人努力工作！！！");
	}
}

class Humen extends Action {

	public void eat() {
		System.out.println("人类开心的吃东西");
	}

	public void sleep() {
		System.out.println("人类睡觉休息");
	}

	public void work() {
		System.out.println("人类工作挣钱");
	}
}

class Pig extends Action {

	public void eat() {
		System.out.println("猪猪吃东西");
	}

	public void sleep() {
		System.out.println("猪猪睡觉养膘");
	}

	public void work() {
	}

}

public class Abstract_test1 {
	public static void main(String[] args) {
		//fun(new Robat());
		//fun(new Humen());
		fun(new Pig());
	}
	public static void fun(Action act) {
		act.commentd(Action.EAT+Action.WORK);
		act.commentd(Action.SLEEP);
	}
}
