package com.mgnregs.loginverification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mgnregs.dbconnections.DbConnect;
import com.mgnregs.dto.BDO;
import com.mgnregs.dto.GPM;

public class Loginimpl implements Login{
	public BDO verifyBDOlogin(Scanner sc) {
		System.out.println("username");
		System.out.println("password");
		String user=sc.next();
		String pass=sc.next();
		Connection con=DbConnect.connecttodb();
		BDO sout=null;
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
					sout=new BDO(rs.getInt("BDO_ID"),rs.getString("username"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}
	public GPM verifyGPMlogin(Scanner sc) {
		System.out.println("username");
		System.out.println("password");
		String user=sc.next();
		String pass=sc.next();
		Connection con=DbConnect.connecttodb();
		GPM sout=null;
		String q="select * from GPM where username=?";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				
			}
			else {
				rs.next();
				if(rs.getString("password").equals(pass)) {
					sout=new GPM(rs.getInt("GPM_ID"),rs.getString("username"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}
}
