package com.mgnregs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mgnregs.dbconnections.DbConnect;
import com.mgnregs.dto.Employee;
import com.mgnregs.dto.GPM;
import com.mgnregs.dto.Project;

public class BDOdaoimpl implements BDOdao {

	@Override
	public String Createproject(Scanner sc) {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		String sout="Oops insertion failed";
		System.out.println("Enter <name location date");
		String name =sc.next();
		String location =sc.next();
		String start_date =sc.next();
		String end_date =LocalDate.parse(start_date).plusDays(100).toString();
		String q="insert into project (project_name,project_location,Start_date,End_date) values (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,name);
			ps.setString(2,location);
			ps.setString(3,start_date);
			ps.setString(4,end_date);
			int ans=ps.executeUpdate();
			if(ans>0) {
				sout="Project created Sucessfull";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public List<Project> ListOfProject() {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		List<Project> sout=new ArrayList<>();

		String q="select * from project";
		
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				
			}
			else {
				while(rs.next()) {
					sout.add(new Project(rs.getInt("project_id"),rs.getString("project_name"),rs.getString("project_location"),rs.getDate("start_date").toLocalDate(),rs.getDate("end_date").toLocalDate()));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public String CreateGPM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GPM> ViewallGPM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AllocateProjecttoGPM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> ListoEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

}
