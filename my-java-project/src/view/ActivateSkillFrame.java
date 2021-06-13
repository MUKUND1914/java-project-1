package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.SkillController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ActivateSkillFrame {

	private JFrame frmActivateSkil;
	private JTextField textField;
    SkillController sc=null;


	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ActivateSkillFrame() throws ClassNotFoundException, SQLException {
		frmActivateSkil = new JFrame();
		frmActivateSkil.setTitle("Activate Skil");
		frmActivateSkil.setBounds(100, 100, 500, 503);
		frmActivateSkil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmActivateSkil.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter SkillId :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(59, 120, 143, 42);
		frmActivateSkil.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(212, 120, 187, 45);
		frmActivateSkil.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ACTIVATE");
		sc=new SkillController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				sc.activateSkill(id);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(148, 277, 138, 42);
		frmActivateSkil.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmActivateSkil.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(308, 277, 103, 42);
		frmActivateSkil.getContentPane().add(btnNewButton_1);
		frmActivateSkil.setVisible(true);
	}
}
