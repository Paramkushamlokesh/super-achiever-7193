package com.mgnregs.dto;

public class ocupation {
	int ocupation_id ;
	String ocupation_name ;
	int salary_wage;
	public ocupation() { }
	public ocupation(int ocupation_id, String ocupation_name, int salary_wage) {
		this.ocupation_id = ocupation_id;
		this.ocupation_name = ocupation_name;
		this.salary_wage = salary_wage;
	}
	
	public ocupation(String ocupation_name, int salary_wage) {
		this.ocupation_name = ocupation_name;
		this.salary_wage = salary_wage;
	}
	public int getOcupation_id() {
		return ocupation_id;
	}
	public void setOcupation_id(int ocupation_id) {
		this.ocupation_id = ocupation_id;
	}
	public String getOcupation_name() {
		return ocupation_name;
	}
	public void setOcupation_name(String ocupation_name) {
		this.ocupation_name = ocupation_name;
	}
	public int getSalary_wage() {
		return salary_wage;
	}
	public void setSalary_wage(int salary_wage) {
		this.salary_wage = salary_wage;
	}
	@Override
	public String toString() {
		return "ocupation [ocupation_id=" + ocupation_id + ", ocupation_name=" + ocupation_name + ", salary_wage="
				+ salary_wage + "]";
	}
	
}
