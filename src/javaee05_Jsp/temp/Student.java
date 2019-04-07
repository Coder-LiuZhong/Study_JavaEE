package javaee05_Jsp.temp;

//JavaBean
public class Student {
	private String name;
	private int age;
	private double salary;
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student(){
		System.out.println("使用jsp:useBean标签，web容器会通过反射创建JavaBean对象");
	}
	public String getName() {
		System.out.println("getName()");
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println(name);
	}
	public int getAge() {
		System.out.println("getAge()");
		return age;
	}
	public void setAge(int age) {
		this.age = age;
		System.out.println(age);
	}
	public double getSalary() {
		System.out.println("getSalary()");
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
		System.out.println(salary);
	}
}
