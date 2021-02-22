package com.xworkz.matrimonydto;





public class BrideDTO {
	private int id;
	private String name;
	private int age;
	private double height;
	private double weight;
	private String qualification;
	private String expectation;
	private String Phone_number;
	private double salary;
	private String occupatation;
	//private String address;

//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExpectation() {
		return expectation;
	}

	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getOccupatation() {
		return occupatation;
	}

	public void setOccupatation(String occupatation) {
		this.occupatation = occupatation;
	}

	@Override
	public String toString() {
		return "BrideDTO [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", qualification=" + qualification + ", expectation=" + expectation + ", Phone_number=" + Phone_number
				+ ", salary=" + salary + ", occupatation=" + occupatation + "]";
	}

	


}
