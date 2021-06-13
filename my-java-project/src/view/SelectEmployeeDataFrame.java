package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

public class SelectEmployeeDataFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	Container container;

	public SelectEmployeeDataFrame(int id) throws ClassNotFoundException, SQLException {
		Connection conn = Jdbconnection.getDBconnection();
		Statement stmt = conn.createStatement();
		frame = new JFrame();
		JTable table = new JTable();
		EmpIdFrame empId = new EmpIdFrame();
		DefaultTableModel model = new DefaultTableModel(
				new String[] { "empid", "firstname", "lastname", "role", "gender", "active" }, 0);
		PreparedStatement pst = conn.prepareStatement("select * from employee where empid=?");
		pst.setInt(1, id);
		model.addRow(new Object[] { "EMPID", "FIRST NAME", "LAST NAME", "ROLES", "GENDER", "ACTIVE" });
		ResultSet rst = pst.executeQuery();
		if (rst != null) {
			if (rst.next()) {
				int a = rst.getInt("EmpId");
				String b = rst.getString("FirstName");
				String c = rst.getString("LastName");
				String d = rst.getString("Roles");
				String e = rst.getString("Gender");
				String f = rst.getString("Active");
				model.addRow(new Object[] { a, b, c, d, e, f });
			}
		}

		table.setModel(model);
		container = getContentPane();
		setLayoutManger();
		JScrollPane sp = new JScrollPane(table);

		container.add(sp);
		container.add(table);

		table.setBounds(50,20,500,500);
		this.setVisible(true);
		this.setBounds(10, 10, 600, 600);
		this.setTitle("Selected Employee Data");
	}

	private void setLayoutManger() {
		container.setLayout(null);

	}

}
