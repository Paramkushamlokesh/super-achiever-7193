package com.mgnregs.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dao.BDOdao;
import com.mgnregs.dao.BDOdaoimpl;
import com.mgnregs.dto.BDO;

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
				
				System.out.println(o.Createproject(arr));
			});
			
			
		});
		but2.addActionListener(e->{
			System.out.println("butt2");
			postbutt.addActionListener(w->{
				int id=Integer.parseInt(smsg.getText());
				try {
					System.out.println(o.ListOfProject());
				} catch (MGNREGSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		});
		but3.addActionListener(e->{
			System.out.println("butt3");
			smsg.setText("Enter <username password email phone>");
			jf.add(smsg);
			jf.add(postbutt);
			postbutt.addActionListener(w->{
				String ans=smsg.getText();
				String[] arr=ans.split(" ");
				System.out.println(o.CreateGPM(arr));
			});
		});
		but4.addActionListener(e->{
			System.out.println("butt4");
			try {
				System.out.println(o.ViewallGPM());
			} catch (MGNREGSException e1) {
				e1.printStackTrace();
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
				System.out.println(o.AllocateProjecttoGPM(arr));

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
					o.ListoEmployee(id).stream().forEach(s->System.out.println(s));
				} catch (MGNREGSException e1) {
					e1.printStackTrace();
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
