package com.mgnregs.dto;

import java.time.LocalDate;

public class workerslog {
	 int emp_id;
	 int project_id ;
	 LocalDate Start_date ;
	 LocalDate releving_date ;
	 int days;
	 public workerslog() { }
	public workerslog(int emp_id, int project_id, LocalDate start_date, LocalDate releving_date,int days) {
		this.emp_id = emp_id;
		this.project_id = project_id;
		Start_date = start_date;
		this.releving_date = releving_date;
		this.days=days;
	}
	
	public workerslog(LocalDate start_date, LocalDate releving_date, int days) {
		Start_date = start_date;
		this.releving_date = releving_date;
		this.days = days;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public LocalDate getStart_date() {
		return Start_date;
	}
	public void setStart_date(LocalDate start_date) {
		Start_date = start_date;
	}
	public LocalDate getReleving_date() {
		return releving_date;
	}
	public void setReleving_date(LocalDate releving_date) {
		this.releving_date = releving_date;
	}
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "workerslog [emp_id=" + emp_id + ", project_id=" + project_id + ", Start_date=" + Start_date
				+ ", releving_date=" + releving_date + "]";
	}
	 
}
