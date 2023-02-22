package com.mgnregs.dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbConnect {
	private static final String url;
	private static final String username;
	private static final String password;
	
	static {
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		ResourceBundle rb=ResourceBundle.getBundle("dbDetails");
		url=rb.getString("url");
		username=rb.getString("username");
		password=rb.getString("password");
	}
	
	public static Connection connecttodb() {
		Connection con=null;;
		try {
			con = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeconnection(Connection con) {
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
