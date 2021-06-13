package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmployeeController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeactivateEmpFrame {

	private JFrame frmDeactivateFrame;
	private JTextField textField;

    EmployeeController ec=null;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeactivateEmpFrame() throws ClassNotFoundException, SQLException {
		frmDeactivateFrame = new JFrame();
		frmDeactivateFrame.setTitle("Deactivate Frame");
		frmDeactivateFrame.setBounds(100, 100, 501, 501);
		frmDeactivateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDeactivateFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Employee Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(80, 119, 188, 41);
		frmDeactivateFrame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(218, 194, 145, 48);
		frmDeactivateFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("DEACTIVATE");
		ec=new EmployeeController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(textField.getText());
				ec.deactivateEmployee(id);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(268, 294, 151, 48);
		frmDeactivateFrame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(218, 363, 108, 41);
		frmDeactivateFrame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeactivateFrame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(358, 363, 85, 41);
		frmDeactivateFrame.getContentPane().add(btnNewButton_2);
		frmDeactivateFrame.setVisible(true);
	}

	

}
