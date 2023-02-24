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
import com.mgnregs.dto.ocupation;
import com.mgnregs.dto.workerslog;

public class GPMdaoimpl implements GPMdao {

	@Override
	public String CreateEmployee(String[] arr) {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		String sout="Oops insertion failed";
		System.out.println("Enter <name phone typeofwork>");
		String name =arr[0];
		String phone =arr[1];
		int type=Integer.parseInt(arr[2]);

		String q="insert into Employee (emp_name,emp_phone,emp_type) values (?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1,name);
			ps.setString(2,phone);
			ps.setInt(3,type);

			int ans=ps.executeUpdate();
			if(ans>0) {
				sout="Employee created Sucessfull";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public Employee getEmployeeDetails(int id) throws  MGNREGSException {
		// TODO Auto-generated method stub
		
		Connection con= DbConnect.connecttodb();
		Employee sout=null;
		String q="select * from employee where emp_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			
			ps.setInt(1,id);

			ResultSet rs =ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				throw new  MGNREGSException("Employee not Found");
			}
			else {
				rs.next();
				sout=new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getString("emp_phone"),rs.getInt("emp_type"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public String AssignEmployeetoProject(String[] arr) {
		// TODO Auto-generated method stub
		Connection con= DbConnect.connecttodb();
		String sout="Oops insertion failed";
		

		String q="insert into workerslog (emp_id,project_id,Start_date) values (?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, Integer.parseInt(arr[0]));
			ps.setInt(2, Integer.parseInt(arr[1]));
			ps.setString(3, arr[2]);
			int ans=ps.executeUpdate();
			if(ans>0) {
				sout="Employee assigined to project Sucessfull";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbConnect.closeconnection(con);
		return sout;
	}

	@Override
	public List<AllEmp> getEmployeesStatus(int id) throws  MGNREGSException{
		String q="select * from  ocupation AB right join (select A.emp_id,emp_name,start_date,emp_type from workerslog A left join Employee B on A.emp_id=B.emp_id where project_id=?) BC on AB.ocupation_id=BC.emp_type";
		Connection con= DbConnect.connecttodb();
		List<AllEmp> sout=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				throw new  MGNREGSException("No Employee on project");
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
