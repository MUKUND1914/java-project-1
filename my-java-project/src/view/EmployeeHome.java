package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.EmployeeController;
import model.Employee;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class EmployeeHome {

	private JFrame frame;
	 private EmployeeController econtroller=null;
	 

	public EmployeeHome(Employee emp) {
		
		 
    	 try
    	 {
    		 econtroller=new EmployeeController();
    	 }catch(ClassNotFoundException q)
    	 {
    		 System.out.println(q);
    	 }
    	 catch(SQLException w)
    	 {
    		 System.out.println(w);
    	 }
    	 frame = new JFrame();
    	 frame.getContentPane().setBackground(new Color(176, 196, 222));
 		frame.setBounds(100, 100, 502, 671);
 		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 		frame.getContentPane().setLayout(null);
 		frame.setVisible(true);
 		
 		
 		JLabel lblNewLabel = new JLabel("EMPLOYEE DETAIL");
 		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
 		lblNewLabel.setBounds(117, 36, 249, 41);
 		frame.getContentPane().add(lblNewLabel);
 		
 		JButton btnNewButton = new JButton("VIEW PROFILE");
 		btnNewButton.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				int i=emp.getEmpId();
 				try {
					new ViewEMpProfile(i);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 		});
 		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton.setBounds(74, 111, 349, 41);
 		frame.getContentPane().add(btnNewButton);
 	    
 		
 		JButton btnNewButton_1 = new JButton("UPDATE EMPLOYEE JOB");
 		btnNewButton_1.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 			   new UpdateEmpJobFrame();
 			}
 		});
 		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_1.setBounds(74, 177, 349, 41);
 		frame.getContentPane().add(btnNewButton_1);
 		
 		JButton btnNewButton_2 = new JButton("UPDATE EMPLOYEE SKILL");
 		btnNewButton_2.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				
 				new UpdateEmpSkillFrame();
 			}
 		});
 		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_2.setBounds(74, 243, 349, 41);
 		frame.getContentPane().add(btnNewButton_2);
 		
 		JButton btnNewButton_3 = new JButton("ADD JOB DETAIL");
 		btnNewButton_3.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				new ApplyForJobFrame();
 				
 			}
 		});
 		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_3.setBounds(74, 309, 349, 41);
 		frame.getContentPane().add(btnNewButton_3);
 		
 		JButton btnNewButton_4 = new JButton("LOGOUT");
 		btnNewButton_4.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				frame.dispose();
 				try {
					new LoginFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 			}
 		});
 		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_4.setBounds(74, 571, 349, 41);
 		frame.getContentPane().add(btnNewButton_4);
 		
 		JButton btnNewButton_4_1 = new JButton("ADD EMPLOYEE SKILL");
 		btnNewButton_4_1.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 			      try {
					new AddEmpskill();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 			}
 		});
 		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_4_1.setBounds(74, 446, 349, 41);
 		frame.getContentPane().add(btnNewButton_4_1);
 		
 		JButton btnNewButton_5 = new JButton("VIEW SKILL");
 		btnNewButton_5.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				try {
					new AllSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 			}
 		});
 		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_5.setBounds(74, 379, 349, 41);
 		frame.getContentPane().add(btnNewButton_5);
 		
 		JButton btnNewButton_6 = new JButton("UPDATE PROFILE");
 		btnNewButton_6.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				new UpadteProfileFrame();
 			}
 		});
 		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
 		btnNewButton_6.setBounds(74, 509, 349, 46);
 		frame.getContentPane().add(btnNewButton_6);
	}
	
}
