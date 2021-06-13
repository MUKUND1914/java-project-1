package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.EmployeeController;
import model.Employee;
import java.awt.Font;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {
	      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		Container container;
	    JFrame f;
          JLabel Lusername,Lpassword;
          JTextField Tuser;
          JPasswordField TPassword;
          JButton Blogin,BRegister;
          EmployeeController empcontroller=null;
          private JButton btnNewButton;
          public LoginFrame() throws ClassNotFoundException,SQLException
          {
          	getContentPane().setBackground(new Color(176, 196, 222));
        	  container=getContentPane();
        	  Lusername =new JLabel("UserID ");
        	  Lpassword =new JLabel("Password");
        	  Tuser=new JTextField();
        	  TPassword=new JPasswordField();
        	  Blogin=new JButton("Login");
        	  Blogin.setFont(new Font("Tahoma", Font.BOLD, 10));
        	  empcontroller=new EmployeeController();
        	  Blogin.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String userId,password;
					userId=Tuser.getText();
					Employee emp=new Employee();
					password=new String(TPassword.getPassword());
					emp=empcontroller.checkLogin(userId, password);
					if((emp.getUserId())==null || (emp.getPassword()==null))
				   {
			            JFrame f=new JFrame();
			            JOptionPane.showMessageDialog(f, "Invalid! register");
		     		}
					else 
					{
						if(emp.getActive().equals("Active"))
						{
							if(emp.getRole().equals("HRA"))
							{
								try
								{
									new HRAHomeFrame();
									dispose();
								}
								catch(Exception s)
								{
									System.out.println(s);
								}
							}
							else if(emp.getRole().equals("PME"))
							{
								
								new PMEHomeFrame();
								dispose();
							}
							else
							{
								new EmployeeHome(emp);
								dispose();
							}
						}
						else
						{
							JFrame u=new JFrame();
							JOptionPane.showMessageDialog(u,"invalid user");
						}
					}
					
				}
			});
        	  
			BRegister=new JButton("Register");
			BRegister.setFont(new Font("Tahoma", Font.BOLD, 10));
			
			BRegister.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					try
					{
					if(e.getSource()==BRegister){
						new RegistrationFrame();
					 }
					}
				catch(Exception p)
					{
					System.out.println(p);
					}
					
				}
			} );
            container.setLayout(null);
        	Lusername.setBounds(50, 150, 100, 30);
    		Lpassword.setBounds(50, 250, 100, 30);
    		Tuser.setBounds(250, 150, 150, 30);
    		TPassword.setBounds(250, 250, 150, 30);
    		Blogin.setBounds(100, 400, 100, 30);
    		BRegister.setBounds(200, 400, 100, 30);
            
    		container.add(Lusername);
    		container.add(Tuser);
    		container.add(Lpassword);
    		container.add(TPassword);
    		container.add(Blogin);
    		container.add(BRegister);
    		
    		btnNewButton = new JButton("Clear");
    		btnNewButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				Tuser.setText("");
    				TPassword.setText("");
    			}
    		});
    		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
    		btnNewButton.setBounds(300, 400, 85, 30);
    		getContentPane().add(btnNewButton);
    		
    		JButton btnNewButton_1 = new JButton("EXIT");
    		btnNewButton_1.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				dispose();
    			}
    		});
    		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
    		btnNewButton_1.setBounds(381, 475, 100, 30);
    		getContentPane().add(btnNewButton_1);
            
            
            this.setVisible(true);
            this.setTitle("Login page");
            this.setBounds(300,300,505,552);
            this.setResizable(true);
          }
    public static void main(String[]args) throws ClassNotFoundException, SQLException
    {
      new LoginFrame();	
    }
}



