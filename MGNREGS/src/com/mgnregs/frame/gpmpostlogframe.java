package com.mgnregs.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dao.GPMdao;
import com.mgnregs.dao.GPMdaoimpl;
import com.mgnregs.dbconnections.DbConnect;
import com.mgnregs.dto.GPM;

public class gpmpostlogframe {
//	System.out.println("1. Create Employee.");
//	System.out.println("2. View the Details of Employee.");
//	System.out.println("3. Assign Employee to a Project.");
//	System.out.println("4. View total number of days Employee worked in a project and also their wages.");
//	System.out.println("0. Login Page");
	JFrame jf;
	
	JButton but1=new JButton("Create Employee");
	JButton but2=new JButton("View All  Employees status");
	JButton but3=new JButton("Assign Employee to a Project");
	JButton but4=new JButton("View total number of days Employee worked in a project and also their wages");
	JButton but5=new JButton("View the Details of Employee");
	
	JTextField smsg=new JTextField();
	JButton postbutt=new JButton("Proceed");
	
	gpmpostlogframe(GPM gpm){
		jf=new JFrame();
		Connection con=DbConnect.connecttodb();
		String q="Select * from gpmtopro where GPM_ID=?";
		PreparedStatement ps;
		int sin=0;
		try {
			ps = con.prepareStatement(q);
			ps.setInt(1, gpm.getGPM_ID());
			ResultSet rs=ps.executeQuery();
			
			if(!rs.isBeforeFirst()&&rs.getRow()==0) {
				
			}
			else {
				rs.next();
				sin=rs.getInt("Project_id");
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		DbConnect.closeconnection(con);
		jf.setTitle(gpm.getUsername()+" "+gpm.getGPM_ID()+((sin==0)?"project-> Inactive":"--> project-id "+sin));
		
		if(sin==0) {
			but3.setEnabled(false);
		}
		
		ImageIcon ico=new ImageIcon("MNNREGS_LOGO.png");
		jf.setIconImage(ico.getImage());
		
		but1.setBounds(100, 50, 400, 50);
		but2.setBounds(100, 110, 400, 50);
		but3.setBounds(100, 170, 400, 50);
		but4.setBounds(100, 230, 400, 50);
		but5.setBounds(100, 290, 400, 50);
		
		smsg.setBounds(100, 400, 400, 50);
		postbutt.setBounds(100, 450, 150, 50);
		postbutt.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(620,620);
		jf.setLayout(null);
		jf.setVisible(true);
		
		GPMdao o=new GPMdaoimpl();
		but1.addActionListener(e->{
			System.out.println("butt1");
			smsg.setText("Enter <name phone typeofwork>");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				
				JOptionPane.showMessageDialog(null,o.CreateEmployee(arr));
			});
		});
		but2.addActionListener(e->{
			
				try {
					StringBuilder sb=new StringBuilder();
					o.getAllEmployeeDetails().forEach((s)->{
						sb.append(s);
						});
					JOptionPane.showMessageDialog(null,sb.toString());
				} catch (MGNREGSException e1) {
					JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
				}
			
		});
		but3.addActionListener(e->{
			System.out.println("butt3");
			smsg.setText("Enter <emp_id, project_id , Start_date(yy-mm-dd)>");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				JOptionPane.showMessageDialog(null,o.AssignEmployeetoProject(arr));
			});
		});
		but4.addActionListener(e->{
			System.out.println("butt4");
			try {
				StringBuilder sb=new StringBuilder();
				o.getEmployeesStatus(gpm.getGPM_ID()).stream().forEach(s->{
					int salary=s.getOc().getSalary_wage()*s.getWl().getDays();
					
					sb.append(s+" ,salary"+salary+"\n");
					});
				JOptionPane.showMessageDialog(null,sb.toString());
			} catch (MGNREGSException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
			}
		});
		but5.addActionListener(e->{
			System.out.println("butt5");
			smsg.setText("Enter employee id no");
			jf.add(smsg);
			jf.add(postbutt);
			
			postbutt.addActionListener(w->{
				int id=Integer.parseInt(smsg.getText());
				
				try {
					JOptionPane.showMessageDialog(null,o.getEmployeeDetails(id));
				} catch (MGNREGSException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
				}
			});
		});
		jf.add(but1);
		jf.add(but2);
		jf.add(but3);
		jf.add(but4);
		jf.add(but5);
	}
}
