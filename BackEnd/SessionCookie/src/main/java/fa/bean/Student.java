/**
 * @author HauHP
 * @date 20 thg 12, 2021
 * @version 1.0
 */
package fa.bean;

public class Student {
	private int id;
	private String name;
	private String address;
	private int age;
	public Student() {
		super();
	}
	public Student(int id, String name, String address, int age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.age = age;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
