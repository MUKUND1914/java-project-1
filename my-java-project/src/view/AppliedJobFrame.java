package view;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AppliedJobFrame extends JFrame{

	JFrame frame;
	Container container;
	
	public AppliedJobFrame() throws ClassNotFoundException, SQLException{
		Connection conn=Jdbconnection.getDBconnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EJId","EmployeeId", "JobId", "Recruited"}, 0);
		ResultSet rst=stmt.executeQuery("select * from EmpJob");
		model.addRow(new Object[] {"EJId","empId", "JobId", "Recruited"});
		while(rst.next())
		{
		    int a = rst.getInt("EJId");
		    int b = rst.getInt("EmployeeId");
		    int c = rst.getInt("JobId");
		    String d = rst.getString("Recruited");
		    model.addRow(new Object[]{a,b,c,d});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(50,20,500,500);
		    this.setVisible(true);
		    this.setBounds(10,10,600,600);
		    this.setResizable(false);
		    this.setTitle("Information regarding Applied Jobs");
		}

	}
}
