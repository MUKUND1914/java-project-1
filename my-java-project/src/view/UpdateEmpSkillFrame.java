package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.EmployeeController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateEmpSkillFrame {

	private JFrame frmUpdateFrame;
	private JTextField textField;
	private JTextField textField_2;



	/**
	 * Create the application.
	 */
	EmployeeController ec=null;
	
	public UpdateEmpSkillFrame() {
		frmUpdateFrame = new JFrame();
		frmUpdateFrame.setTitle("UPDATE FRAME");
		frmUpdateFrame.setBounds(100, 100, 520, 543);
		frmUpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUpdateFrame.getContentPane().setLayout(null);
		frmUpdateFrame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("UPDATE YOUR SKILL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(129, 30, 231, 47);
		frmUpdateFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMPLOYEE ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(56, 131, 156, 32);
		frmUpdateFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("EXP. YEAR ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(56, 223, 156, 32);
		frmUpdateFrame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(222, 131, 199, 32);
		frmUpdateFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(222, 223, 199, 32);
		frmUpdateFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int empid=Integer.parseInt(textField.getText());
			 
				int expy=Integer.parseInt( textField_2.getText()); 
				try {
					ec=new EmployeeController();
					ec.updateEmpSkill(empid,expy);
					
				} catch (ClassNotFoundException | SQLException e) {
				
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(129, 365, 126, 40);
		frmUpdateFrame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT\t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUpdateFrame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(287, 365, 113, 40);
		frmUpdateFrame.getContentPane().add(btnNewButton_1);
	}
}
