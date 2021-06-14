package view;


import java.awt.Color;
import java.awt.Cursor;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.EmployeeController;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class RegistrationFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JFrame f;
	private JTextField tfirstname, tlastname, tuserid;
	private JPasswordField tpassword, tconformpassword;
	private JLabel lfirstname, llastname, luserid, lgender, lrole, lpassword, lconpassword;
	private JButton bsubmit;
	private static EmployeeController ec = null;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
    ButtonGroup bg;
    ButtonGroup bg1;
    private JRadioButton rdbtnNewRadioButton_2;
    private JRadioButton rdbtnNewRadioButton_3;
    private JRadioButton rdbtnNewRadioButton_4;
	

	public RegistrationFrame() throws ClassNotFoundException, SQLException {
         bg=new ButtonGroup(); 
         bg1=new ButtonGroup();
		p = new JPanel();
		p.setBackground(new Color(176, 196, 222));
		p.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		p.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(660, 726);
		setVisible(true);
		
		

		lfirstname = new JLabel("FIRST NAME");
		lfirstname.setFont(new Font("Apple Braille", Font.BOLD, 15));

		llastname = new JLabel("LAST NAME");
		llastname.setFont(new Font("Apple Braille", Font.BOLD, 15));

		luserid = new JLabel(" USER ID");
		luserid.setFont(new Font("Apple Braille", Font.BOLD, 15));

		lgender = new JLabel("GENDER");
		lgender.setFont(new Font("Apple Braille", Font.BOLD, 15));

		lrole = new JLabel("ROLE");
		lrole.setFont(new Font("Apple Braille", Font.BOLD, 15));

		lpassword = new JLabel("PASSWORD");
		lpassword.setFont(new Font("Apple Braille", Font.BOLD, 15));

		lconpassword = new JLabel("CONFORM PASSWORD");
		lconpassword.setFont(new Font("Apple Braille", Font.BOLD, 15));

		tfirstname = new JTextField();
		tfirstname.setColumns(10);

		tlastname = new JTextField();
		tfirstname.setColumns(10);

		tuserid = new JTextField();
		tuserid.setColumns(10);

		tpassword = new JPasswordField();
		tpassword.setColumns(10);

		tconformpassword = new JPasswordField();
		tconformpassword.setColumns(10);

		bsubmit = new JButton("SUBMIT");
		ec=new EmployeeController();
		bsubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String UFN, ULN, UID, UG, UR, UCP, UP;
				
				UFN = tfirstname.getText();
				ULN = tlastname.getText();
				UID = tuserid.getText();
				UG= bg.getSelection().getActionCommand();
				UR = bg1.getSelection().getActionCommand();
				UCP = new String(tconformpassword.getPassword());
				UP = new String(tpassword.getPassword());
				if (UP.equals(UCP)) {
					ec.addEmployee(UFN, ULN, UID, UP, UG, UR);
					int r = JOptionPane.showConfirmDialog(f, "Registed successfully ", "Registation",
							JOptionPane.YES_NO_OPTION);
					if (r == JOptionPane.YES_OPTION) {
						try {
							new LoginFrame();
							dispose();
						} catch (ClassNotFoundException e1) {

							e1.printStackTrace();
						} catch (SQLException e1) {

							e1.printStackTrace();
						}
					} else {
						f.dispose();
					}
				}

			}
		});

		p.add(bsubmit);
		p.add(lfirstname);
		p.add(tfirstname);
		p.add(llastname);
		p.add(tlastname);
		p.add(luserid);
		p.add(tuserid);
		p.add(lgender);
		p.add(lrole);
		p.add(lpassword);
		p.add(tpassword);
		p.add(lconpassword);
		p.add(tconformpassword);
		getContentPane().add(p);
		this.setTitle("FORM");

		lfirstname.setBounds(16, 119, 109, 16);
		llastname.setBounds(355, 119, 109, 16);
		luserid.setBounds(16, 213, 109, 16);
		lgender.setBounds(16,410,109,16);
		lrole.setBounds(16, 502, 109, 16);
		lpassword.setBounds(16, 310, 268, 16);
		lconpassword.setBounds(355, 310, 268, 16);

		tfirstname.setBounds(16, 140, 268, 33);
		tlastname.setBounds(355, 140, 268, 33);
		tuserid.setBounds(16, 234, 268, 33);
		tpassword.setBounds(16, 331, 268, 33);
		tconformpassword.setBounds(355, 331, 268, 33);

		bsubmit.setBounds(280, 622, 142, 40);
		bsubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		JLabel lblNewLabel = new JLabel("REGISTRATION FORM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(156, 21, 346, 46);
		p.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(443, 622, 122, 40);
		p.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton("MALE");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton.setBounds(97, 438, 103, 40);
		rdbtnNewRadioButton.setActionCommand("male");
		p.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("FEMALE");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_1.setBounds(238, 438, 103, 40);
		rdbtnNewRadioButton_1.setActionCommand("female");
		p.add(rdbtnNewRadioButton_1);
		
	
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("EMP");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_2.setBounds(97, 524, 103, 42);
		rdbtnNewRadioButton_2.setActionCommand("EMP");
		p.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("HRA");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_3.setBounds(238, 524, 103, 42);
		rdbtnNewRadioButton_3.setActionCommand("HRA");
		p.add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("PME");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_4.setBounds(380, 524, 103, 42);
		rdbtnNewRadioButton_4.setActionCommand("PME");
		p.add(rdbtnNewRadioButton_4);
         
		bg1.add(rdbtnNewRadioButton_2);
		bg1.add(rdbtnNewRadioButton_3);
		bg1.add(rdbtnNewRadioButton_4);
	}
}
