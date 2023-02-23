package com.mgnregs.dao;

import java.util.List;
import java.util.Scanner;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dto.AllEmp;
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
	 * @throws MGNREGSException 
	 */
	List<Project> ListOfProject() throws MGNREGSException;
	/**
	 * 
	 * @return
	 */
	String CreateGPM(Scanner sc);
	/**
	 * 
	 * @return
	 * @throws MGNREGSException 
	 */
	List<GPM> ViewallGPM() throws MGNREGSException;
	/**
	 * 
	 * @return
	 */
	String AllocateProjecttoGPM(Scanner sc);
	/**
	 * working on that Project and their wages.
	 * 
	 * @return list of Employee
	 */
	List<AllEmp> ListoEmployee(Scanner sc) throws  MGNREGSException; 

}
