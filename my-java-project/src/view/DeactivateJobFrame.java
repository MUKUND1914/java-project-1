package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.JobController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeactivateJobFrame {

	private JFrame frmDeactivateJob;

   JobController jobc=null;
   private JTextField textField;
   private JButton btnNewButton_1;
   private JButton btnNewButton_2;

	
	public DeactivateJobFrame() throws ClassNotFoundException, SQLException {
		frmDeactivateJob = new JFrame();
		frmDeactivateJob.setTitle("Deactivate job");
		frmDeactivateJob.setBounds(100, 100, 502, 506);
		frmDeactivateJob.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDeactivateJob.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter job Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(70, 116, 171, 46);
		frmDeactivateJob.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(203, 203, 184, 40);
		frmDeactivateJob.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("DEACTIVATE");
		jobc=new JobController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				jobc.deactivateJob(id);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(286, 273, 154, 46);
		frmDeactivateJob.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLEAN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(286, 329, 139, 40);
		frmDeactivateJob.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeactivateJob.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(286, 385, 139, 40);
		frmDeactivateJob.getContentPane().add(btnNewButton_2);
		frmDeactivateJob.setVisible(true);
	}

	

}
