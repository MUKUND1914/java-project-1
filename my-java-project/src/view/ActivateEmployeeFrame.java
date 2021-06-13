package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.SQLException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmployeeController;
import java.awt.Font;

public class ActivateEmployeeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel lempid;
	JTextField tempid;
	JButton bsubmit;
	JFrame f;

	EmployeeController ec = null;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	public ActivateEmployeeFrame() throws ClassNotFoundException, SQLException {
		ec = new EmployeeController();
		lempid = new JLabel("Enter Employee Id :");
		tempid = new JTextField();
		bsubmit = new JButton("Activate");
		bsubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int id;
				String i = tempid.getText();
				id = Integer.parseInt(i);
				try {
					ec.activateEmployee(id);
				} catch (Exception a) {
					a.printStackTrace();
				}

			}
		});
		lempid.setBounds(30, 150, 135, 40);
		tempid.setBounds(200, 150, 100, 40);
		bsubmit.setBounds(200, 250, 80, 40);
		this.getContentPane().add(lempid);
		this.getContentPane().add(tempid);
		getContentPane().add(bsubmit);

		setTitle("ACTIVATE EMPLOYEE");
		getContentPane().setLayout(null);

		btnNewButton = new JButton("CLEAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempid.setText(" ");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(105, 250, 73, 40);
		getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(288, 250, 73, 40);
		getContentPane().add(btnNewButton_1);
		setSize(500, 500);
		setVisible(true);
	}

}
