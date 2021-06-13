package view;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.SkillController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddSkillFrame {

	private JFrame frmAddSkilFramel;
	private JTextField textField;
	private JTextField textField_1;
	SkillController sc = null;

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public AddSkillFrame() throws ClassNotFoundException, SQLException {
		frmAddSkilFramel = new JFrame();
		frmAddSkilFramel.setTitle("Add Skil Framel ");
		frmAddSkilFramel.setBounds(100, 100, 505, 503);
		frmAddSkilFramel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddSkilFramel.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Skill Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(66, 103, 148, 40);
		frmAddSkilFramel.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Skill Description");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(66, 218, 148, 40);
		frmAddSkilFramel.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(256, 103, 178, 40);
		frmAddSkilFramel.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(260, 218, 174, 40);
		frmAddSkilFramel.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("INSERT");
		sc = new SkillController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sname, sdesc;
				sname = textField.getText();
				sdesc = textField_1.getText();
				sc.addSkill(sname, sdesc);
				

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(256, 298, 141, 47);
		frmAddSkilFramel.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.setBounds(256, 355, 141, 40);
		frmAddSkilFramel.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAddSkilFramel.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(256, 405, 141, 40);
		frmAddSkilFramel.getContentPane().add(btnNewButton_2);
		frmAddSkilFramel.setVisible(true);
	}
}
