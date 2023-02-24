package com.mgnregs.gui;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.mgnregs.frame.bdologframe;
import com.mgnregs.frame.gpmlogframe;

public class Main {
	
	public static void main(String[] args) {
		////
		
		
		
		Scanner sc=new Scanner(System.in);
		
		
		JFrame jf=new JFrame();
		jf.setTitle("MGNREGS");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(420,420);
		jf.setVisible(true);
		
		
		
		JButton jb1=new JButton("BLOCK DEVELOPMENT OFICER LOGIN");
		JButton jb2=new JButton("GRAM PANCHAYTH MEMBER LOGIN");
		jb1.setBounds(20, 50, 350, 50);
		jb1.addActionListener(e-> {
			jf.dispose();
			bdologframe bdof=new bdologframe();
		});
		jb2.setBounds(20, 120, 350, 50);
		jb2.addActionListener(e->{
			jf.dispose();
			gpmlogframe gpmf=new gpmlogframe();
		} );
		
		jf.add(jb1);
		
		jf.add(jb2);
		////
		//Scanner sc=new Scanner(System.in);
		
//		int choise=-1;
//		do {
//			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//			System.out.println("Welcome to MGNREGS SYSTEMS!!!!");
//			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
//			System.out.println("1. Block_Development_Officer Login");
//			System.out.println("2. Gram_Panchayat_member Login");
//			choise=sc.nextInt();
//			switch(choise) {
//				case 1:
//					Login log1=new Loginimpl();
//					BDO dbo=log1.verifyBDOlogin(sc);
//					if(dbo!=null){
//						System.out.println("login successful");
//						Secsiongui.BDOPostlog(sc,dbo);
//					}
//					else {
//						System.out.println("login failed");
//					}
//					break;
//				case 2:
//					Login log2=new Loginimpl();
//					GPM gpm=log2.verifyGPMlogin(sc);
//					if(gpm!=null){
//						System.out.println("login successful");
//						Secsiongui.GPMPostlog(sc,gpm);
//					}
//					else {
//						System.out.println("login failed");
//					}
//					break;
//					
//			}
//		}
//		while(choise!=0);
//		sc.close();
	}

}
