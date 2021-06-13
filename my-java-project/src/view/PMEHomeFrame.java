package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class PMEHomeFrame {

	private JFrame frame;

	public PMEHomeFrame() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 529, 710);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("WELCOME TO PME PORTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(98, 29, 343, 41);
		frame.getContentPane().add(lblNewLabel);

		/*1*/JButton btnNewButton = new JButton("VIEW SKILL WISE EMPLOYEE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewSkillWiseEmp();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(70, 85, 380, 41);
		frame.getContentPane().add(btnNewButton);

		/*2*/JButton btnNewButton_1 = new JButton("VIEW ALL SKILL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AllSkillFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(70, 160, 380, 41);
		frame.getContentPane().add(btnNewButton_1);

		/*3*/JButton btnNewButton_2 = new JButton("ADD AN JOB");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AddJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(70, 235, 380, 41);
		frame.getContentPane().add(btnNewButton_2);

		/*4*/JButton btnNewButton_3 = new JButton("VIEW ALL JOB");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AllJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(70, 311, 380, 41);
		frame.getContentPane().add(btnNewButton_3);

		/*5*/JButton btnNewButton_4 = new JButton("VIEW SKILL WISE JOB");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewSkillWiseJob();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(70, 389, 380, 41);
		frame.getContentPane().add(btnNewButton_4);

		/*6*/JButton btnNewButton_5 = new JButton("VIEW EMP WHO HAVE APPLIED FOR JOB");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AppliedJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_5.setBounds(70, 466, 380, 41);
		frame.getContentPane().add(btnNewButton_5);

		/*7*/JButton btnNewButton_6 = new JButton("DEACTIVATE JOB");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeactivateJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_6.setBounds(70, 538, 380, 41);
		frame.getContentPane().add(btnNewButton_6);

		/*8*/JButton btnNewButton_7 = new JButton("LOGOUT");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new LoginFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_7.setBounds(118, 612, 293, 41);
		frame.getContentPane().add(btnNewButton_7);
		frame.setVisible(true);
	}
}
