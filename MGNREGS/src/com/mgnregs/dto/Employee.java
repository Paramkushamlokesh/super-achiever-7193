package com.mgnregs.dto;

public class Employee {
	private int Emp_id;
	private String Emp_name;
	private String phone;
	private int type;
	public Employee() {	}
	
	public Employee(String emp_name, String phone, int type) {
		Emp_name = emp_name;
		this.phone = phone;
		this.type = type;
	}
	
	public Employee(int emp_id, String emp_name) {
		Emp_id = emp_id;
		Emp_name = emp_name;
	}

	public Employee(int emp_id, String emp_name, String phone, int type) {
		Emp_id = emp_id;
		Emp_name = emp_name;
		this.phone = phone;
		this.type = type;
	}

	public int getEmp_id() {
		return Emp_id;
	}
	public void setEmp_id(int emp_id) {
		Emp_id = emp_id;
	}
	public String getEmp_name() {
		return Emp_name;
	}
	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Employee [Emp_id=" + Emp_id + ", Emp_name=" + Emp_name + ", phone=" + phone + ", type=" + type + "]";
	}
	
	
}
