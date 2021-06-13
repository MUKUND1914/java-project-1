package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class HRAHomeFrame {

	private JFrame frame;
	JButton bSetActive, bSetActiveJob, bSetDeactive, bSetDeactiveJob, bViewAllEmp, bViewJob, bViewSelectEmp, bAddSkill,
	bViewSkill, bSetActiveSkill, bSetDeactiveSkill;
	private JLabel lblNewLabel;
	private JButton btnNewButton;



	/**
	 * Create the application.
	 */
	public HRAHomeFrame() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 568, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		/*1*/bSetActive = new JButton("Active Users");
		bSetActive.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bSetActive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ActivateEmployeeFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*2*/bSetActiveJob = new JButton("Activate Job");
		bSetActiveJob.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bSetActiveJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				 try {
					new ActivateJobFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*3*/bSetDeactive = new JButton("Deactivate Employee");
		bSetDeactive.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bSetDeactive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					new DeactivateEmpFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*4*/bSetDeactiveJob = new JButton("Deactivate Job");
		bSetDeactiveJob.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bSetDeactiveJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new DeactivateJobFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*5*/bViewAllEmp = new JButton("View All Employee");
		bViewAllEmp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bViewAllEmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					new AllEmployeesFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		/*6*/bViewJob = new JButton("View All Job");
		bViewJob.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bViewJob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new AllJobFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*7*/bViewSelectEmp = new JButton("View Employee By Id");
		bViewSelectEmp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bViewSelectEmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EmpIdFrame();

			}
		});

	

		/*8*/bViewSkill = new JButton("View All Skill");
		bViewSkill.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bViewSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new AllSkillFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*9*/bSetActiveSkill = new JButton("Activate Skill");
		bSetActiveSkill.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bSetActiveSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ActivateSkillFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		/*10*/bSetDeactiveSkill = new JButton("Deactivate Skill");
		bSetDeactiveSkill.setFont(new Font("Tahoma", Font.PLAIN, 22));
		bSetDeactiveSkill.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new DeactivateSkillFrame();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		
		bViewAllEmp.setBounds(117, 85, 320, 40);
		bSetActive.setBounds(117, 185, 320, 40);
		bSetDeactive.setBounds(117, 135, 320, 40);
		bViewSelectEmp.setBounds(117, 237, 320, 40);
		bViewSkill.setBounds(117, 287, 320, 40);
		bSetDeactiveSkill.setBounds(117, 389, 320, 40);
		bSetActiveSkill.setBounds(117, 439, 320, 40);
		bViewJob.setBounds(117, 489, 320, 39);
		bSetDeactiveJob.setBounds(117, 538, 320, 40);
		bSetActiveJob.setBounds(117, 588, 320, 33);
		frame.getContentPane().setLayout(null);

	
		frame.getContentPane().add(bSetActive);
		frame.getContentPane().add(bSetDeactive);
		frame.getContentPane().add(bViewAllEmp);
		frame.getContentPane().add(bViewSelectEmp);
		frame.getContentPane().add(bViewSkill);
		frame.getContentPane().add(bSetDeactiveSkill);
		frame.getContentPane().add(bSetActiveSkill);
		frame.getContentPane().add(bViewJob);
		frame.getContentPane().add(bSetDeactiveJob);
		frame.getContentPane().add(bSetActiveJob);
		
		lblNewLabel = new JLabel("HRA PORTAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(107, 10, 310, 40);
		frame.getContentPane().add(lblNewLabel);
		
		/*11*/JButton btnAddSkill = new JButton("Add Skill");
		btnAddSkill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						new AddSkillFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnAddSkill.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAddSkill.setBounds(117, 337, 320, 40);
		frame.getContentPane().add(btnAddSkill);
		
		/*12*/btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(156, 631, 241, 42);
		frame.getContentPane().add(btnNewButton);
		
	}
}
