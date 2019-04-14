package test;

class Dept {
	private int deptno;
	private String dname;
	private String loc;
	private Emp emps[];

	public Emp[] getEmps() {
		return emps;
	}

	public void setEmps(Emp[] emps) {
		this.emps = emps;
	}

	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public String getInfo() {
		return "部门编号：" + this.deptno + ",名称：" + this.dname + ",位置：" + this.loc;
	}
}

class Emp {
	private int empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	private Emp mgr; // 每一个雇员对应的领导

	public Emp getMgr() {
		return mgr;
	}

	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Emp(int empno, String ename, String job, double sal, double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	public String getInfo() {
		return "雇员编号：" + this.empno + ",雇员姓名：" + this.ename + ",工作：" + this.job + ",薪水：" + this.sal + ",佣金" + this.comm;
	}
}

public class testDeptDemo {
	// 产生独立的对象
	public static void main(String[] args) {
		Dept dept = new Dept(5, "accounting", "new york");
		Emp ea = new Emp(7750, "smith", "clerk", 500, 0.00);
		Emp eb = new Emp(7690, "fusu", "accounter", 5000, 500);
		Emp ec = new Emp(7370, "mary", "boss", 900, 300);
		// 雇员与领导的关系
		ea.setMgr(eb);
		eb.setMgr(ec);
		// 设置雇员与部门的关系
		ea.setDept(dept);
		eb.setDept(dept);
		ec.setDept(dept);
		dept.setEmps(new Emp[] { ea, eb, ec });
		// 取出数据
		// 通过雇员找到领导信息和部门信息
		System.out.println(ea.getInfo());
		System.out.println(ea.getMgr().getInfo());
		System.out.println(ea.getDept().getInfo());
		// 根据部门找到所有雇员以及每个雇员的领导信息
		System.out.println("==================================");
		System.out.println(dept.getInfo());
		for (int x = 0; x < dept.getEmps().length; x++) {
			System.out.println(dept.getEmps()[x].getInfo());
			if (dept.getEmps()[x].getMgr() != null) {
				System.out.println(dept.getEmps()[x].getMgr().getInfo());
			}
		}
	}
}
