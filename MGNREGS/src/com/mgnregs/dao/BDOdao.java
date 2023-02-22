package com.mgnregs.dao;

import java.util.List;
import java.util.Scanner;

import com.mgnregs.dto.Employee;
import com.mgnregs.dto.GPM;
import com.mgnregs.dto.Project;

public interface BDOdao {
	/**
	 * 
	 * @param sc 
	 * @return
	 */
	String Createproject(Scanner sc);
	/**
	 * 
	 * @return
	 */
	List<Project> ListOfProject();
	/**
	 * 
	 * @return
	 */
	String CreateGPM();
	/**
	 * 
	 * @return
	 */
	List<GPM> ViewallGPM();
	/**
	 * 
	 * @return
	 */
	String AllocateProjecttoGPM();
	/**
	 * working on that Project and their wages.
	 * 
	 * @return list of Employee
	 */
	List<Employee> ListoEmployee(); 

}
