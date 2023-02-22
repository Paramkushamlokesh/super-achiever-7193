package com.mgnregs.dto;

import java.time.LocalDate;

public class Project {
	private int project_id;
	private String project_name;
	private String project_location;
	private LocalDate Start_date;
	private LocalDate End_date;
	public Project(String project_name, String project_location, LocalDate start_date, LocalDate end_date) {
		this.project_name = project_name;
		this.project_location = project_location;
		Start_date = start_date;
		End_date = end_date;
	}
	public Project(int project_id, String project_name, String project_location, LocalDate start_date,LocalDate end_date) {
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_location = project_location;
		Start_date = start_date;
		End_date = end_date;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_location() {
		return project_location;
	}
	public void setProject_location(String project_location) {
		this.project_location = project_location;
	}
	public LocalDate getStart_date() {
		return Start_date;
	}
	public void setStart_date(LocalDate start_date) {
		Start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return End_date;
	}
	public void setEnd_date(LocalDate end_date) {
		End_date = end_date;
	}
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_name=" + project_name + ", project_location="
				+ project_location + ", Start_date=" + Start_date + ", End_date=" + End_date + "]\n";
	}
	
	
}
