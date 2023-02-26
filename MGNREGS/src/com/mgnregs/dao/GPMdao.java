package com.mgnregs.dao;

import java.util.List;
import java.util.Scanner;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dto.AllEmp;
import com.mgnregs.dto.Employee;

public interface GPMdao { 
	/**
	 * Create Employee.
	 * @return String statement
	 */
	String CreateEmployee(String[] arr);
	/**
	 * View the Details of Employee.
	 * @return Employee
	 * @throws MGNREGSException 
	 */
	Employee getEmployeeDetails(int id) throws MGNREGSException;
	/**
	 * Assign Employee to a Project
	 * @return
	 */
	String AssignEmployeetoProject(String[] arr);
	/**
	 * View total number of days Employee worked in a project and also their wages.
	 * @return list of employee data
	 * @throws MGNREGSException 
	 */
	List<AllEmp> getEmployeesStatus(int id) throws MGNREGSException;
	/**
	 * 
	 * @return string
	 * @throws MGNREGSException
	 */
	List<String> getAllEmployeeDetails()throws MGNREGSException;
	
	

}
