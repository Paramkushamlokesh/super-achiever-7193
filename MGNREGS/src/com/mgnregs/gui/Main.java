package com.mgnregs.gui;

import java.util.Scanner;

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
					if(log1.verifyBDOlogin(sc)){
						System.out.println("login successful");
						Secsiongui.BDOPostlog(sc,"lokesh");
					}
					else {
						System.out.println("login failed");
					}
					break;
				case 2:
					Login log2=new Loginimpl();
					if(log2.verifyGPMlogin(sc)){
						
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
