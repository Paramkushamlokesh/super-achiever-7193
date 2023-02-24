package com.mgnregs.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dao.GPMdao;
import com.mgnregs.dao.GPMdaoimpl;
import com.mgnregs.dto.GPM;

public class gpmpostlogframe {
//	System.out.println("1. Create Employee.");
//	System.out.println("2. View the Details of Employee.");
//	System.out.println("3. Assign Employee to a Project.");
//	System.out.println("4. View total number of days Employee worked in a project and also their wages.");
//	System.out.println("0. Login Page");
	JFrame jf;
	
	JButton but1=new JButton("Create Employee");
	JButton but2=new JButton("View the Details of Employee");
	JButton but3=new JButton("Assign Employee to a Project");
	JButton but4=new JButton("View total number of days Employee worked in a project and also their wages");
	
	JTextField smsg=new JTextField();
	JButton postbutt=new JButton("Proceed");
	
	gpmpostlogframe(GPM gpm){
		jf=new JFrame();
		
		but1.setBounds(100, 50, 400, 50);
		but2.setBounds(100, 110, 400, 50);
		but3.setBounds(100, 170, 400, 50);
		but4.setBounds(100, 230, 400, 50);
		
		smsg.setBounds(100, 350, 400, 50);
		postbutt.setBounds(100, 400, 150, 50);
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
				System.out.println(arr[0]);
				System.out.println(arr[1]);
				System.out.println(arr[2]);
				
				System.out.println(o.CreateEmployee(arr));
			});
			
			//System.out.println(o.CreateEmployee(sc));
		});
		but2.addActionListener(e->{
			System.out.println("butt2");
			smsg.setText("Enter employee id no");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				int id=Integer.parseInt(smsg.getText());
				try {
					System.out.println(o.getEmployeeDetails(id));
				} catch (MGNREGSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		});
		but3.addActionListener(e->{
			System.out.println("butt3");
			smsg.setText("Enter <emp_id, project_id , Start_date(yy-mm-dd)>");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				System.out.println(arr[0]);
				System.out.println(arr[1]);
				System.out.println(arr[2]);
				System.out.println(o.AssignEmployeetoProject(arr));
			});
		});
		but4.addActionListener(e->{
			System.out.println("butt4");
			try {
				o.getEmployeesStatus(gpm.getGPM_ID()).stream().forEach(s->System.out.println(s));
			} catch (MGNREGSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		jf.add(but1);
		jf.add(but2);
		jf.add(but3);
		jf.add(but4);
	}
}
