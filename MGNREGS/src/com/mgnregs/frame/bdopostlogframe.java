package com.mgnregs.frame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dao.BDOdao;
import com.mgnregs.dao.BDOdaoimpl;
import com.mgnregs.dbconnections.DbConnect;
import com.mgnregs.dto.BDO;
import com.mgnregs.dto.GPM;
import com.mgnregs.dto.Project;

public class bdopostlogframe {
JFrame jf;
	
	JButton but1=new JButton("Create a project");
	JButton but2=new JButton("View List Of Project");
	JButton but3=new JButton("Create new Gram Panchayat Member(GPM)");
	JButton but4=new JButton("View all the GPM");
	JButton but5=new JButton("Allocate  Project to GPM");
	JButton but6=new JButton("See List of Employee working on that Project and their wages");
	
	
	JTextField smsg=new JTextField();
	JButton postbutt=new JButton("Proceed");
	
	bdopostlogframe(BDO bdo){
		jf=new JFrame();
		jf.setTitle(bdo.getUsername());
		
		ImageIcon ico=new ImageIcon("MNNREGS_LOGO.png");
		jf.setIconImage(ico.getImage());
		
		but1.setBounds(100, 50, 400, 50);
		but2.setBounds(100, 110, 400, 50);
		but3.setBounds(100, 170, 400, 50);
		but4.setBounds(100, 230, 400, 50);
		but5.setBounds(100, 290, 400, 50);
		but6.setBounds(100, 350, 400, 50);
		
		
		smsg.setBounds(100, 450, 400, 50);
		postbutt.setBounds(100, 500, 150, 50);
		postbutt.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(620,720);
		jf.setLayout(null);
		jf.setVisible(true);
		
		BDOdao o=new BDOdaoimpl();
		but1.addActionListener(e->{
			System.out.println("butt1");
			smsg.setText("Enter <name location date>");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				JOptionPane.showMessageDialog(null,o.Createproject(arr));
				//System.out.println(o.Createproject(arr));
			});
			
			
		});
		but2.addActionListener(e->{
			
			Connection con=DbConnect.connecttodb();
			
			String q="select * from gpmtopro";
			List<Integer> gpmids=new ArrayList<>();
			List<Integer> proids=new ArrayList<>();
			try {
				Statement  st=con.createStatement();
				ResultSet rs=st.executeQuery(q);
				if(!rs.isBeforeFirst()&&rs.getRow()==0) {
					
				}
				else {
					while(rs.next()) {
						gpmids.add(rs.getInt("GPM_ID"))	;
						proids.add(rs.getInt("Project_id"))	;
					}
				}
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			DbConnect.closeconnection(con);
			
			try {
				List<Project> str=o.ListOfProject();
				//System.out.println(str);
				StringBuilder sb=new StringBuilder();
				str.stream().forEach(s->{
					sb.append(s+((proids.contains(s.getProject_id())?"actice \n":"Inactive \n")));
					});
				JOptionPane.showMessageDialog(null,sb.toString());
//				System.out.println(o.ListOfProject());
			} catch (MGNREGSException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
			}
		});
		but3.addActionListener(e->{
			System.out.println("butt3");
			smsg.setText("Enter <username password email phone>");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				JOptionPane.showMessageDialog(null,o.CreateGPM(arr));
			});
		});
		but4.addActionListener(e->{
			System.out.println("butt4");
Connection con=DbConnect.connecttodb();
			
			String q="select * from gpmtopro";
			List<Integer> gpmids=new ArrayList<>();
			List<Integer> proids=new ArrayList<>();
			try {
				Statement  st=con.createStatement();
				ResultSet rs=st.executeQuery(q);
				if(!rs.isBeforeFirst()&&rs.getRow()==0) {
					
				}
				else {
					while(rs.next()) {
						gpmids.add(rs.getInt("GPM_ID"))	;
						proids.add(rs.getInt("Project_id"))	;
					}
				}
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			DbConnect.closeconnection(con);
			try {
				List<GPM>str=o.ViewallGPM();
				StringBuilder sb=new StringBuilder();
				str.stream().forEach(s->{
					sb.append(s+((gpmids.contains(s.getGPM_ID())?"actice \n":"Inactive \n")));
					});
				JOptionPane.showMessageDialog(null,sb.toString());
			} catch (MGNREGSException e1) {
				JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
			}
		});
		but5.addActionListener(e->{
			System.out.println("butt5");
			smsg.setText("Enter <Enter GPM_id-->Project_id");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				JOptionPane.showMessageDialog(null,o.AllocateProjecttoGPM(arr));
			});
		});
		but6.addActionListener(e->{
			System.out.println("butt6");
			smsg.setText("Enter project Id");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				
				int id=Integer.parseInt(smsg.getText());
				try {
					StringBuilder sb=new StringBuilder();
					o.ListoEmployee(id).stream().forEach(s->sb.append(s));
					JOptionPane.showMessageDialog(null,sb.toString());
				} catch (MGNREGSException e1) {
					JOptionPane.showMessageDialog(null,e1.getLocalizedMessage());
				}

			});
		});
		jf.add(but1);
		jf.add(but2);
		jf.add(but3);
		jf.add(but4);
		jf.add(but5);
		jf.add(but6);
	}
}
