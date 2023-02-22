package com.mgnregs.gui;

import java.util.Scanner;

import com.mgnregs.dao.BDOdao;
import com.mgnregs.dao.BDOdaoimpl;

public class Secsiongui {
	  
	static void BDOPostlog(Scanner sc,String user){
		int choise=-1;
		do{
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Welcome to MGNREGS SYSTEMS!!!!");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Hello! "+user);
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("1. Create a project.");
			System.out.println("2. View List Of Project.");
			System.out.println("3. Create new Gram Panchayat Member(GPM).");
			System.out.println("4. View all the GPM.");
			System.out.println("5. Allocate  Project to GPM");
			System.out.println("6. See List of Employee working on that Project and their wages.");
			choise=sc.nextInt();
			BDOdao o=new BDOdaoimpl();
			switch(choise) {
			case 1:
				System.out.println(o.Createproject(sc));
				break;
			case 2:
				System.out.println(o.ListOfProject());
				break;
			}
		}
		while(choise!=0);
	}
}
