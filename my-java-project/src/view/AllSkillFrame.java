package view;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class AllSkillFrame extends JFrame {
	JFrame frame;
	Container container;
	public AllSkillFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbconnection.getDBconnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"SkillId", "SkillName", "SkillDescription", "Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Skill");
		model.addRow(new Object[] {"SkillId", "SkillName", "SkillDescription", "Active"});
		
		while(rst.next())
		{
		    int a = rst.getInt("SkillId");
		    String b = rst.getString("SkillName");
		    String c = rst.getString("SkillDescription");
		    String d = rst.getString("Active");
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
		    this.setTitle("Skill Information");
		}
		
	}	
}		
		
		
		
		
		
		
		
