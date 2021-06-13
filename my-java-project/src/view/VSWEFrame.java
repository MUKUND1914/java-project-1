package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;

public class VSWEFrame extends JFrame {

	JFrame frame;
	Container container;

	public VSWEFrame(String name) throws ClassNotFoundException, SQLException {
		Connection conn = Jdbconnection.getDBconnection();
		frame = new JFrame();
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[] { "firstname", "secondname","roles","gender", "active" }, 0);
		model.addRow(new Object[] { "FIRST NAME", "LAST NAME","ROLES","GENDER","ACTIVE" });
		PreparedStatement p= conn.prepareStatement("select * from Employee where empId in(select EmployeeId from EmpSkill where SkillId in(select SkillId from Skill where SkillName=?))");
	    p.setString(1, name);
	    
		ResultSet rst=p.executeQuery();
		while (rst.next()) {
			String a = rst.getString("firstname");
			String b = rst.getString("lastname");
			String c= rst.getString("roles");
			String d=rst.getString("gender");
			String e=rst.getString("active");
			model.addRow(new Object[] { a, b , c, d, e });
			table.setModel(model);
			container = getContentPane();
			container.setLayout(null);
			JScrollPane sp = new JScrollPane(table);
			container.add(sp);
			container.add(table);
			table.setBounds(10, 10, 800, 900);
			this.setVisible(true);
			this.setBounds(10, 10, 800, 900);
			this.setTitle("Job Data");
		}
	}
}
