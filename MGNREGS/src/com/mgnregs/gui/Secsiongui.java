package com.mgnregs.gui;

import java.util.Scanner;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dao.BDOdao;
import com.mgnregs.dao.BDOdaoimpl;
import com.mgnregs.dao.GPMdao;
import com.mgnregs.dao.GPMdaoimpl;
import com.mgnregs.dto.BDO;
import com.mgnregs.dto.GPM;

public class Secsiongui {
	  
	static void BDOPostlog(Scanner sc,BDO bdo){
		int choise=-1;
		do{
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Welcome to MGNREGS SYSTEMS!!!!");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Hello(BDO)! "+bdo.getUsername());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("1. Create a project.");
			System.out.println("2. View List Of Project.");
			System.out.println("3. Create new Gram Panchayat Member(GPM).");
			System.out.println("4. View all the GPM.");
			System.out.println("5. Allocate  Project to GPM");
			System.out.println("6. See List of Employee working on that Project and their wages.");
			System.out.println("0. Login Page");
			choise=sc.nextInt();
			BDOdao o=new BDOdaoimpl();
			switch(choise) {
			case 1:
				System.out.println(o.Createproject(sc));
				break;
			case 2:
				try {
					System.out.println(o.ListOfProject());
				} catch (MGNREGSException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				System.out.println(o.CreateGPM(sc));
				break;
			case 4:
				try {
					System.out.println(o.ViewallGPM());
				} catch (MGNREGSException e1) {
					e1.printStackTrace();
				}
				break;
			case 5:
				System.out.println(o.AllocateProjecttoGPM(sc));
				break;
			case 6:
				try {
					o.ListoEmployee(sc).stream().forEach(s->System.out.println(s));
				} catch (MGNREGSException e) {
					e.printStackTrace();
				}
				break;	
				
			}
		}
		while(choise!=0);
	}
	static void GPMPostlog(Scanner sc,GPM gpm) {
		int choise=-1;
		do{

			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Welcome to MGNREGS SYSTEMS!!!!");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Hello(GPM)! "+gpm.getUsername());
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("1. Create Employee.");
			System.out.println("2. View the Details of Employee.");
			System.out.println("3. Assign Employee to a Project.");
			System.out.println("4. View total number of days Employee worked in a project and also their wages.");
			System.out.println("0. Login Page");

			choise=sc.nextInt();
			GPMdao o=new GPMdaoimpl();
			switch(choise) {
			case 1:
				System.out.println(o.CreateEmployee(sc));
				break;
			case 2:
				try {
					System.out.println(o.getEmployeeDetails(sc));
				} catch (MGNREGSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println(o.AssignEmployeetoProject(sc));
				break;
			case 4:
				try {
					o.getEmployeesStatus(gpm.getGPM_ID()).stream().forEach(s->System.out.println(s));
				} catch (MGNREGSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		while(choise!=0);
	}
}
