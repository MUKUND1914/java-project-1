package controller;

import java.sql.SQLException;
import java.util.List;

import dao.IJobDao;
import daoimp.JobDaoimp;
import model.Job;

public class JobController {
	IJobDao jobdao = null;

	public JobController() throws ClassNotFoundException, SQLException {
		jobdao = new JobDaoimp();
	}

	public void addJob(String JBT, String JD, String CN, String LC, String KS, String JS) {
		Job j = new Job();
		j.setJobTitle(JBT);
		j.setJobDescription(JD);
		j.setCompanyName(CN);
		j.setLocation(LC);
		j.setKeySkill(KS);
		j.setSalary(JS);
		if (JBT.equals("HR")) {
			j.setActive("Active");
		} else {
			j.setActive("Deactive");
		}
		jobdao.addJob(j);
	}

	public void getAllJob() {
		List<Job> allJobList = jobdao.getAllJob();
		for (Job j : allJobList) {
			System.out.println(j);
		}

	}

	public void getJobById(int id) {
		jobdao.getJobById(id);
	}

	public void updateJob(int id, String loc) {
		Job j = new Job();
		j = jobdao.getJobById(id);
		j.setLocation(loc);

		try {
			jobdao.updateJob(j);
		} catch (Exception w) {
			w.printStackTrace();
		}
	}

	public void deactivateJob(int s) {
		try {
			Job j = jobdao.getJobById(s);
			jobdao.deactivateJob(j);
		} catch (Exception d) {
			d.printStackTrace();

		}
	}

	public void activateJob(int s) {
		Job j = jobdao.getJobById(s);
		jobdao.activateJob(j);
	}

	public void deleteJob(int id) {
		try {
			jobdao.deleteJob(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
