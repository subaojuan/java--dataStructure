package test;

/*两个对象之间的比较
要比较两个对象的所有属性值是否相等
要判断传入的对象是否为空
*/
class Book {
	private int id;
	private String name;

	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public boolean Compare(Book book) {
		// book.name="java开发";
		if (this == book) {
			return true;
		}
		if (book == null) {
			return false;
		}
		if (this.id == book.id && this.name.equals(book.name)) {
			System.out.println("这两个是同一个对象");
			return true;
		} else {
			System.out.println("这两个不是同一个对象");
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class objectCompare {
	public static void main(String[] args) {
		Book book1 = new Book(1, "java开发");
		Book book2 = new Book(1, "php开发");
		Book book3 = new Book(1, "java开发");
		/*
		 * if (book1.getId() == book3.getId() &&
		 * book1.getName().equals(book3.getName())) { System.out.println("这两个对象是同一个对象");
		 * }else { System.out.println("这两个对象不是一个对象"); } if (book1.getId() ==
		 * book2.getId() && book1.getName().equals(book2.getName())) {
		 * System.out.println("这两个对象是同一个对象"); }else { System.out.println("这两个对象不是一个对象");
		 * }
		 */
		book1.Compare(book2);
	}
}
