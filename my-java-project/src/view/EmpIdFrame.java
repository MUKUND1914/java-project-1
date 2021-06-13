package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EmpIdFrame {

	private JFrame frmEmployeeView;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public EmpIdFrame() {
		frmEmployeeView = new JFrame();
		frmEmployeeView.setTitle("EMPLOYEE VIEW ");
		frmEmployeeView.setBounds(100, 100, 501, 509);
		frmEmployeeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEmployeeView.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Employee Id :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(69, 104, 212, 44);
		frmEmployeeView.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(173, 174, 194, 44);
		frmEmployeeView.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(textField.getText());
				try {
					new SelectEmployeeDataFrame(id);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(275, 250, 122, 54);
		frmEmployeeView.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmployeeView.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(330, 379, 111, 54);
		frmEmployeeView.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("CLEAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2.setBounds(154, 250, 111, 54);
		frmEmployeeView.getContentPane().add(btnNewButton_2);
		frmEmployeeView.setVisible(true);
	}
}
