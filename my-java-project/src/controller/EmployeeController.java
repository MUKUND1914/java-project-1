package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.IEmpJobDao;
import dao.IEmployeeDAO;
import dao.IEmpskillDao;
import daoimp.EmpJobdaoimp;
import daoimp.EmpSkillDaoimp;
import daoimp.EmployeeDAOimp;
import model.EmpSkill;
import model.Empjob;
//import dao.IEmpSkillDao;
//import dao.IEmployeeDao;
import model.Employee;

public class EmployeeController {
	IEmployeeDAO empDao = null;
	IEmpskillDao empskillDao = null;
	IEmpJobDao empjobDao = null;
	Employee emp = null;

	public EmployeeController() throws ClassNotFoundException, SQLException {
		empDao = new EmployeeDAOimp();
		empskillDao=new EmpSkillDaoimp();
		empjobDao=new EmpJobdaoimp();
	}

	public Employee checkLogin(String UserId, String Password) {
		Employee emp = empDao.checkLogin(UserId, Password);
		return emp;
	}

	public void addEmployee(String UFN, String ULN, String UID, String UP, String UG, String UR) {
		Employee emp = new Employee();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		emp.setFirstName(UFN);

		emp.setLastName(ULN);

		emp.setUserId(UID);

		emp.setPassword(UP);

		emp.setRole(UR);

		emp.setGender(UG);
		if (UR.equals("HRA")||UR.equals("PME")) {
			emp.setActive("Active");
		} else {
			emp.setActive("Deactivate");
		}
		// calling dao method for insert record
		empDao.addEmployee(emp);
	}

	public void getAllEmployees() {

		List<Employee> allEmpList = empDao.getAllEmployee();
		for (Employee emp : allEmpList) {
			System.out.println(emp);
		}
	}

	public void getEmployeeById(int s) {

			
			empDao.getEmployeeById(s);
			
		
	}

	public Employee updateEmployee(int id, String pass) {
		try {
			emp = new Employee();
			emp = empDao.getEmployeeById(id);
			emp.setPassword(pass);

			empDao.updateEmployee(emp);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return emp;
	}

	public void deactivateEmployee(int s) {

		Employee emp = empDao.getEmployeeById(s);
		empDao.diactivateEmployee(emp);
	}

	public void activateEmployee(int id) {
		Employee emp=empDao.getEmployeeById(id);
		empDao.activateEmployee(emp);
	}

	public void deleteEmployee() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Employee ID you wish to Delete: ");
			id = Integer.parseInt(reader.readLine());
			empDao.deleteEmployee(id);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void addEmpSkill(int s1, int s2, int s3) {
		EmpSkill esk = new EmpSkill();
		
		esk.setEmpId(s1);
		esk.setSkillId(s2);
		esk.setExpYear(s3);
		empskillDao.addEmpSkill(esk);
		
	}

	public void getAllEmpSkills() {

		List<EmpSkill> allEmpSkillList = empskillDao.getAllEmpSkill();
		for (EmpSkill esk : allEmpSkillList) {
			System.out.println(esk);
		}
	}

	public void getEmpSkillById() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int id;
			// System.out.println("Enter EmpSkillId whose record you want to access:");
			id = Integer.parseInt(reader.readLine());
			EmpSkill esk = empskillDao.getEmpSkillById(id);
			// System.out.println(esk);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateEmpSkill(int id, int expyear) {

		EmpSkill esk = empskillDao.getEmpSkillById(id);
		esk.getExpYear();
		empskillDao.updateEmpSkill(esk);

	}

	public void DeleteEmpSkill() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter ESId whose record you want to delete:");
			id = Integer.parseInt(reader.readLine());
			empskillDao.deleteEmpSkill(id);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void addEmpJob(int s1, int s2, String s3) {
		Empjob ejb = new Empjob();
		// BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("Enter whether recruited or not :");
		ejb.setEmpId(s1);
		ejb.setJobId(s2);
		ejb.setRecruited(s3);
		empjobDao.addEmpJob(ejb);
	}

	public void getAllEmpJobs() {

		List<Empjob> allEmpJobList = empjobDao.getAllEmpJob();
		for (Empjob ejb : allEmpJobList) {
			System.out.println(ejb);
		}
	}

	public void getEmpJobById() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmpJobId whose record you want to access:");
			id = Integer.parseInt(reader.readLine());
			Empjob ejb = empjobDao.getEmpJobById(id);
			System.out.println(ejb);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateEmpJob(int id, String rec) {

		Empjob ejb = empjobDao.getEmpJobById(id);

		ejb.setRecruited(rec);
		empjobDao.updateEmpJob(ejb);

	}

	public void DeleteEmpJob() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EJId whose record you want to delete:");
			id = Integer.parseInt(reader.readLine());
			empjobDao.deleteEmpJob(id);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
