package view;

import java.awt.Container;
import java.sql.Statement ;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;


public class AllEmployeesFrame extends JFrame {
	JFrame frame;
	Container container;
	public AllEmployeesFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbconnection.getDBconnection();
		Statement s=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"empId", "FirstName", "LastName", "Roles","Gender", "Active"}, 0);
		ResultSet rst=s.executeQuery("select * from Employee where Roles='EMP'");
		model.addRow(new Object[]{"empId", "FirstName", "LastName", "Roles","Gender", "Active"});
		while(rst.next())
		{
		    int a = rst.getInt("empId");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Roles");
		    String e = rst.getString("Gender");
		    String f = rst.getString("Active");
		    model.addRow(new Object[]{a,b,c,d,e,f});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManger();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(50,20,500,500);
		    this.setVisible(true);
		    this.setBounds(10,10,600,600);
		    this.setTitle("Employee Data");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	

}

