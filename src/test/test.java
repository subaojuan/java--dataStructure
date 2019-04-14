package test;

class People {
	private String name;
	private double money;
	private Car car;

	public Car getCar() {
		return this.car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	public String getInfo() {
		return ("名字是：" + this.name + ",工资是：" + this.money);
	}

	public People(String name, double money) {
		this.name = name;
		this.money = money;
	}
}

class Car {
	private People people;
	private String cname;

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Car(String cname) {
		this.cname = cname;
	}

	public String getInfo() {
		return "车的名字是：" + this.cname;
	}

}

public class test {
	public static void main(String[] args) {
		People p = new People("苏苏", 5000);
		Car c = new Car("24k法拉利");
		p.setCar(c);
		c.setPeople(p);
		System.out.println(p.getCar().getInfo());
		System.out.println(c.getPeople().getInfo());
	}
}
