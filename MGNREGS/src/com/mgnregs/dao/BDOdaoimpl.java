package com.mgnregs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dbconnections.DbConnect;
import com.mgnregs.dto.AllEmp;
import com.mgnregs.dto.Employee;
import com.mgnregs.dto.GPM;
import com.mgnregs.dto.Project;
import com.mgnregs.dto.ocupation;
import com.mgnregs.dto.workerslog;

public class BDOdaoimpl implements BDOdao {

	@Override
	public String Createproject(Scanner sc) {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		String sout="Oops insertion failed";
		System.out.println("Enter <name location date>");
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
	public List<Project> ListOfProject() throws  MGNREGSException{
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		List<Project> sout=new ArrayList<>();

		String q="select * from project";
		
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				throw new  MGNREGSException("No Project Found");
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
	public String CreateGPM(Scanner sc) {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		String sout="Oops insertion failed";
		System.out.println("Enter <username password email phone>");
		String username =sc.next();
		String password =sc.next();
		String email =sc.next();
		String phone =sc.next();
		String q="insert into GPM (username,password,email,phone) values (?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,phone);
			int ans=ps.executeUpdate();
			if(ans>0) {
				sout="GPM created Sucessfull";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public List<GPM> ViewallGPM() throws  MGNREGSException {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		List<GPM> sout=new ArrayList<>();

		String q="select * from GPM";
		
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				throw new MGNREGSException("No GPM found");
			}
			else {
				while(rs.next()) {
					sout.add(new GPM(rs.getInt("GPM_id"),rs.getString("username"),rs.getString("email"),rs.getString("phone")));
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
	public String AllocateProjecttoGPM(Scanner sc) {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		String sout="Oops allocation failed";
		System.out.println("Enter GPM_id-->Project_id");
		int gpm_id =sc.nextInt();
		int pro_id =sc.nextInt();
		
		String q="insert into gpmtopro values (?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1,gpm_id);
			ps.setInt(2,pro_id);
			
			int ans=ps.executeUpdate();
			if(ans>0) {
				sout="Project allocated to GPM";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public List<AllEmp> ListoEmployee(Scanner sc) throws  MGNREGSException{
		// TODO Auto-generated method stub
		String q="select * from  ocupation AB right join (select A.emp_id,emp_name,start_date,emp_type from workerslog A left join Employee B on A.emp_id=B.emp_id where project_id=?) BC on AB.ocupation_id=BC.emp_type";
		Connection con= DbConnect.connecttodb();
		List<AllEmp> sout=new ArrayList<>();
		System.out.println("Enter project Id");
		int id=sc.nextInt();
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				throw new MGNREGSException("No Employee Found");
			}
			else {
				while(rs.next()) {
					//ocupation_id | ocupation_name | salary_wage | 
					//emp_id | emp_name | start_date | emp_type
					int a=rs.getInt("emp_id");
					String b=rs.getString("emp_name");
					String c=rs.getString("ocupation_name");
					LocalDate d=LocalDate.parse(rs.getString("start_date"));
					LocalDate e=LocalDate.now();
					int f=rs.getInt("salary_wage");
					int days=(int)ChronoUnit.DAYS.between(d,e);
					sout.add(new AllEmp(new Employee(a,b),new ocupation(c,f),new workerslog(d,e,days)));
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
