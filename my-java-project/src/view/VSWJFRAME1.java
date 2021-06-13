package view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbconnection;

public class VSWJFRAME1 extends JFrame {

	private JFrame frame;

	Container container;

	public VSWJFRAME1(String s) throws ClassNotFoundException, SQLException {
		Connection conn = Jdbconnection.getDBconnection();
		frame = new JFrame();
		JButton bExit=new JButton("Exit");
		bExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[] {"jobtitle","jobdescription","salary","active"}, 0);
		model.addRow(new Object[] {"JOBTILE","JOBDESCRIPTION","SALARY","ACTIVE"});
		PreparedStatement p= conn.prepareStatement("select jobtitle,jobdescription,salary,active from Job where KeySkill=?");
	    p.setString(1,s);
	    
		ResultSet rst=p.executeQuery();
		while (rst.next()) {
			String a = rst.getString("jobtitle");
			String b = rst.getString("jobdescription");
			String c= rst.getString("salary");
			String d=rst.getString("active");
			model.addRow(new Object[] { a, b , c, d });
			table.setModel(model);
			container = getContentPane();
			container.setLayout(null);
			JScrollPane sp = new JScrollPane(table);
			container.add(sp);
			container.add(table);
			table.setBounds(10, 10, 500, 500);
			bExit.setBounds(550,550,100 ,80);
			this.setVisible(true);
			this.setBounds(10, 10, 700, 700);
			this.setTitle("Job Data");
		}
	}

	

}
