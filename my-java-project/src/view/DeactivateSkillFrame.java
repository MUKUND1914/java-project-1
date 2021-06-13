package view;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.SkillController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeactivateSkillFrame {

	private JFrame frmDeactivateFrame;
	private JTextField textField;
    SkillController sc=null;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;


	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public DeactivateSkillFrame() throws ClassNotFoundException, SQLException {
		frmDeactivateFrame = new JFrame();
		frmDeactivateFrame.setTitle("Deactivate Frame");
		frmDeactivateFrame.setBounds(100, 100, 502, 502);
		frmDeactivateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDeactivateFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter SkillId :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 128, 120, 37);
		frmDeactivateFrame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(221, 128, 142, 37);
		frmDeactivateFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("DEACTIVATE");
		sc= new SkillController();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField.getText();
				int id=Integer.parseInt(s);
				sc.deactivateSkill(id);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(221, 196, 162, 43);
		frmDeactivateFrame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(" ");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(227, 260, 105, 37);
		frmDeactivateFrame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeactivateFrame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(229, 320, 85, 37);
		frmDeactivateFrame.getContentPane().add(btnNewButton_2);
		frmDeactivateFrame.setVisible(true);
	}



}
