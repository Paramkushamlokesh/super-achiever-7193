package com.mgnregs.gui;

import java.util.Scanner;

import com.mgnregs.dto.BDO;
import com.mgnregs.dto.GPM;
import com.mgnregs.loginverification.Login;
import com.mgnregs.loginverification.Loginimpl;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choise=-1;
		do {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("Welcome to MGNREGS SYSTEMS!!!!");
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.println("1. Block_Development_Officer Login");
			System.out.println("2. Gram_Panchayat_member Login");
			choise=sc.nextInt();
			switch(choise) {
				case 1:
					Login log1=new Loginimpl();
					BDO dbo=log1.verifyBDOlogin(sc);
					if(dbo!=null){
						System.out.println("login successful");
						Secsiongui.BDOPostlog(sc,dbo);
					}
					else {
						System.out.println("login failed");
					}
					break;
				case 2:
					Login log2=new Loginimpl();
					GPM gpm=log2.verifyGPMlogin(sc);
					if(gpm!=null){
						System.out.println("login successful");
						Secsiongui.GPMPostlog(sc,gpm);
					}
					else {
						System.out.println("login failed");
					}
					break;
					
			}
		}
		while(choise!=0);
		sc.close();
	}

}
