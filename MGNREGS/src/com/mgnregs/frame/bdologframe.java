package com.mgnregs.frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mgnregs.Exception.MGNREGSException;
import com.mgnregs.dto.BDO;
import com.mgnregs.loginverification.Login;
import com.mgnregs.loginverification.Loginimpl;

public class bdologframe{
	
	JFrame jf;
	JButton loginbut=new JButton("Login");
	JButton resetbut=new JButton("Reset");
	JLabel userlable=new JLabel("Username :");
	JLabel passwordlable=new JLabel("Password :");
	JTextField userTextField=new JTextField();
	JPasswordField PasswordField=new JPasswordField();

	
	public bdologframe(){
		jf=new JFrame("MGNREGS BDO");
		
			ImageIcon ico=new ImageIcon("MNNREGS_LOGO.png");
			jf.setIconImage(ico.getImage());
			
		
		
		
		userlable.setBounds(50, 100, 75,25);
		passwordlable.setBounds(50, 150, 75,25);
		userTextField.setBounds(125, 100, 200, 25);
		PasswordField.setBounds(125,150,200,25);
		loginbut.setBounds(125, 200, 100, 25);
		resetbut.setBounds(250, 200, 100, 25);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(420,420);
		jf.setLayout(null);
		jf.setVisible(true);
		
		
		 jf.add(userlable);
		 jf.add(passwordlable);
		 jf.add(userTextField);
		 jf.add(PasswordField);
		 jf.add(loginbut);
		 jf.add(resetbut);
		loginbut.addActionListener(e->{
			String user=userTextField.getText();
			String pass=String.valueOf(PasswordField.getPassword());
			System.out.println(user);
			System.out.println(pass);
			
			Login log1=new Loginimpl();
			
			BDO bdo=null;
			try {
				bdo = log1.verifyBDOlogin(user,pass);
				if(bdo!=null){
					jf.dispose();
					JOptionPane.showMessageDialog(null, "login successful");
					bdopostlogframe bdoframe=new bdopostlogframe(bdo);
					//Secsiongui.BDOPostlog(new Scanner(System.in),dbo);
				}
			} catch (MGNREGSException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getLocalizedMessage());
			}

		});
		resetbut.addActionListener((e)->{
			userTextField.setText("");
			PasswordField.setText("");
		});
		
	}
}
