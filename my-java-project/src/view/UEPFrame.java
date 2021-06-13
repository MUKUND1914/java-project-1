package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import config.Jdbconnection;
import controller.EmployeeController;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UEPFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	EmployeeController ec=null;
    Connection con=null;
  
	public UEPFrame(int i) throws ClassNotFoundException, SQLException {
		con=Jdbconnection.getDBconnection();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 524);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(139, 33, 204, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(34, 111, 157, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SECOND NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(34, 171, 157, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ROLES");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(34, 232, 117, 29);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(234, 111, 147, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 171, 147, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(234, 232, 147, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(34, 299, 185, 43);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CONFORM PASSWORD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(22, 370, 214, 29);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(234, 309, 147, 29);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(234, 372, 147, 27);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		con=Jdbconnection.getDBconnection();
		PreparedStatement p=con.prepareStatement("select *from employee where empid=?");
		p.setInt(1, i);
		ResultSet r=p.executeQuery();
		if(r!=null)
		{
		 while(r.next())
		 {
			 
			 String b,c,d;
			 
			 b=r.getString("firstname");
			 c=r.getString("lastname");
			 d=r.getString("roles");
			 
			 textField.setText(b);
			 textField_1.setText(c);
			 textField_2.setText(d);
			
		 }
		}
		
		JButton btnNewButton = new JButton("UPDATE");
		ec=new EmployeeController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p=textField_3.getText();
				String cp=textField_4.getText();
				if(p.equals(cp))
				{
					ec.updateEmployee(i, p);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(288, 423, 117, 43);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
	}

	

}
