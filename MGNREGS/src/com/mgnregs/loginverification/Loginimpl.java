package com.mgnregs.loginverification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mgnregs.dbconnections.DbConnect;

public class Loginimpl implements Login{
	public boolean verifyBDOlogin(Scanner sc) {
		System.out.println("username");
		System.out.println("password");
		String user=sc.next();
		String pass=sc.next();
		Connection con=DbConnect.connecttodb();
		boolean sout=false;
		String q="select * from BDO where username=?";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				
			}
			else {
				rs.next();
				if(rs.getString("password").equals(pass)) {
					sout=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}
	public boolean verifyGPMlogin(Scanner sc) {
		System.out.println("username");
		System.out.println("password");
		String user=sc.next();
		String pass=sc.next();
		return false;
	}
}
