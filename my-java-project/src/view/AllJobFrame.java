package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllJobFrame extends JFrame{
	JFrame frame;
	Container container;
	public AllJobFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbconnection.getDBconnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId","JobTitle", "JobDescription", "CompanyName", "Location","KeySkill","Salary","Activate"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Job");
		model.addRow(new Object[] {"JobId","JobTitle", "JobDescription", "CompanyName", "Location","KeySkill","Salary","Activate"});
		while(rst.next())
		{
		    int a = rst.getInt("JobId");
		    String b = rst.getString("JobTitle");
		    String c = rst.getString("JobDescription");
		    String d = rst.getString("CompanyName");
		    String e = rst.getString("Location");
		    String f = rst.getString("KeySkill");
		    String g = rst.getString("Salary");
		    String h = rst.getString("Active");
		    model.addRow(new Object[]{a,b,c,d,e,f,g,h});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(50,20,500,500);
		    this.setVisible(true);
		    this.setBounds(10,10,600,600);
		    this.setTitle("Job Data");
		}

	}
	
}	
