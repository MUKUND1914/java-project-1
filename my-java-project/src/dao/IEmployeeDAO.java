package dao;

import java.util.List;

import model.Employee;

public interface IEmployeeDAO {

	List<Employee> getAllEmployee();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void diactivateEmployee(Employee emp);
	void activateEmployee(Employee emp);
	void deleteEmployee(int id);
	Employee checkLogin(String Userid,String Password);
	
	
}
