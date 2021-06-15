package daoimp;

import config.Jdbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.IEmployeeDAO;
import model.Employee;

public class EmployeeDAOimp implements IEmployeeDAO {
	Connection con = null;

	public EmployeeDAOimp() throws ClassNotFoundException, SQLException {
		con = Jdbconnection.getDBconnection();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allData = new ArrayList<Employee>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select*from employee");
			if (rs != null) {
				Employee emp = null;
				while (rs.next()) {
					emp.setEmpId(rs.getInt(1));
					emp.setFirstName(rs.getString(2));
					emp.setLastName(rs.getString(3));
					emp.setUserId(rs.getString(4));
					emp.setPassword(rs.getString(5));
					emp.setRole(rs.getString(6));
					emp.setGender(rs.getString(7));
					emp.setActive(rs.getString(8));
					allData.add(emp);
				}

			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return allData;
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			PreparedStatement pst = con.prepareStatement(
					"insert into employee(firstname, lastname, userid, passwords, roles, gender, active) values (?,?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserId());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getRole());
			pst.setString(6, emp.getGender());
			pst.setString(7, emp.getActive());
			int i = pst.executeUpdate();
			JFrame g = new JFrame();
			if (i == 1) {

				JOptionPane.showConfirmDialog(g, "You have successfully Added an Employee...");
			} else {

				JOptionPane.showConfirmDialog(g, "Never mind.... Retry... Insertion Failed");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = new Employee();
		try {
			PreparedStatement pst = con.prepareStatement("Select * from employee where empid=?");
			pst.setInt(1, id);
			ResultSet rst = pst.executeQuery();
			if (rst != null) {
				while(rst.next())
				{
				emp.setEmpId(rst.getInt(1));
				emp.setFirstName(rst.getString(2));
				emp.setLastName(rst.getString(3));
				emp.setUserId(rst.getString(4));
				emp.setPassword(rst.getString(5));
				emp.setRole(rst.getString(6));
				emp.setGender(rst.getString(7));
				emp.setActive(rst.getString(8));
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = con.prepareStatement("update employee set Passwords=? where empid=?");
		    pst.setString(1,emp.getPassword());
		    pst.setInt(2,emp.getEmpId());
			int i = pst.executeUpdate();
			JFrame g = new JFrame();
			if (i == 1) {

				JOptionPane.showConfirmDialog(g, "You have successfully updated an Employee Record.....");
			} else {

				JOptionPane.showConfirmDialog(g, "World is so cruel.. So the Updation Failed...");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void diactivateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = con.prepareStatement("update employee set active=? where empid=? and Roles='EMP'");
			pst.setString(1, "Deactive");
			pst.setInt(2, emp.getEmpId());
			int i = pst.executeUpdate();
			JFrame g = new JFrame();
			if (i == 1) {

				JOptionPane.showConfirmDialog(g, "Feeling sad for him... Deactivation Successfull...");
			} else {

				JOptionPane.showConfirmDialog(g, "I think he got another chance.. Deactivation failed..");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void activateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
            int id=emp.getEmpId();
			PreparedStatement pst = con.prepareStatement("update employee set active=? where empid=?");
			pst.setString(1, "Active");
			pst.setInt(2, id);
			int i = pst.executeUpdate();
			JFrame f = new JFrame();
			if (i==1) {

				JOptionPane.showMessageDialog(f, "There you go you have successfully activated an Employee...");
			} else {

				JOptionPane.showMessageDialog(f, " activation failed...");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = con.prepareStatement("delete from employee where empid=?");
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			JFrame g = new JFrame();
			if (i == 1) {
				// System.out.println("Employee Deleted...");
				JOptionPane.showConfirmDialog(g, "You are here for deleting and you have succeeded...");
			} else {
				// System.out.println("Deletion Failed...");
				JOptionPane.showConfirmDialog(g, "Deletion Failed...");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		}
	}

	@Override
	public Employee checkLogin(String Userid, String Password) {
		Employee emp = new Employee();
		try {
			PreparedStatement pst = con.prepareStatement("select * from employee where  userid=? and passwords=?");
			pst.setString(1, Userid);
			pst.setString(2, Password);
			ResultSet rst = pst.executeQuery();
			if (rst != null) {
				if (rst.next()) {
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserId(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setRole(rst.getString(6));
					emp.setGender(rst.getString(7));
					emp.setActive(rst.getString(8));
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

}
