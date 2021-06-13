package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import config.Jdbconnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ViewEMpProfile {

	private JFrame frmProfile;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	Connection con=null;
	public ViewEMpProfile(int id)throws ClassNotFoundException, SQLException {
		frmProfile = new JFrame();
		frmProfile.setTitle("PROFILE");
		frmProfile.setBounds(100, 100, 526, 639);
		frmProfile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProfile.getContentPane().setLayout(null);
		frmProfile.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(123, 27, 266, 36);
		frmProfile.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMPID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(65, 100, 142, 36);
		frmProfile.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(65, 178, 142, 36);
		frmProfile.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(65, 259, 142, 36);
		frmProfile.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ROLE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(65, 337, 142, 36);
		frmProfile.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GENDER");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(65, 415, 142, 36);
		frmProfile.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ACTIVE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(65, 493, 142, 36);
		frmProfile.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(233, 100, 180, 36);
		frmProfile.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 178, 180, 36);
		frmProfile.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(233, 259, 180, 36);
		frmProfile.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(233, 337, 180, 36);
		frmProfile.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(233, 415, 180, 36);
		frmProfile.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(233, 493, 180, 36);
		frmProfile.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		con=Jdbconnection.getDBconnection();
		PreparedStatement p=con.prepareStatement("select *from employee where empid=?");
		p.setInt(1, id);
		ResultSet r=p.executeQuery();
		if(r!=null)
		{
		 while(r.next())
		 {
			 int a;
			 String b,c,d,e,f;
			 a=r.getInt("empid");
			 b=r.getString("firstname");
			 c=r.getString("lastname");
			 d=r.getString("roles");
			 e=r.getString("gender");
			 f=r.getString("active");
			 
			 textField.setText(String.valueOf(a));
			 textField_1.setText(b);
			 textField_2.setText(c);
			 textField_3.setText(d);
			 textField_4.setText(e);
			 textField_5.setText(f);
		 }
		}
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProfile.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(417, 556, 85, 36);
		frmProfile.getContentPane().add(btnNewButton);
	}
}
