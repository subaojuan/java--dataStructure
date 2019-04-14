package test;

class Province {
	private int pid;
	private String pname;
	private City cities[];
	public City[] getCities() {
		return cities;
	}
	public void setCities(City[] cities) {
		this.cities = cities;
	}
	public Province(int pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}
	public String getInfo() {
		return "省份编号："+this.pid+",省份名称"+this.pname;
	}
}

class City {
	private int cid;
	private String cname;
	private Province province;
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public City(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	public String getInfo() {
		return "城市编号"+cid+",城市名称"+this.cname;
	}
}

public class testProvinceCity {
	public static void main(String[] args) {
		Province province=new Province(101,"陕西");
		City city1=new City(1011, "西安");
		City city2=new City(1012, "汉中");
		City city3=new City(1013, "渭南");
		province.setCities(new City[] {city1,city2,city3});
		city1.setProvince(province);
		//根据省获得相关城市的信息
		for(int i=0;i<province.getCities().length;i++){
			System.out.println(province.getCities()[i].getInfo());
		}
		//根据城市来获得相关的省份的信息
		System.out.println(city1.getProvince().getInfo());
		}
}
