package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.JobController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ActivateJobFrame {

	private JFrame frmActivateJob;
	private JTextField textField;
	JobController jobc=null;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	
	public ActivateJobFrame() throws ClassNotFoundException, SQLException {
		frmActivateJob = new JFrame();
		frmActivateJob.setTitle("Activate Job");
		frmActivateJob.setBounds(100, 100, 503, 426);
		frmActivateJob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmActivateJob.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Job Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(28, 91, 199, 42);
		frmActivateJob.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(225, 168, 175, 42);
		frmActivateJob.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ACTIVATE");
		jobc=new JobController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				jobc.activateJob(id);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(312, 255, 140, 42);
		frmActivateJob.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(247, 321, 107, 42);
		frmActivateJob.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmActivateJob.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(367, 321, 85, 42);
		frmActivateJob.getContentPane().add(btnNewButton_2);
		frmActivateJob.setVisible(true);
	}
}
