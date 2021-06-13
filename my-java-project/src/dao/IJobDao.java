package dao;

import java.util.List;

import model.Job;

public interface IJobDao {
	List<Job> getAllJob();

	void addJob(Job job);

	Job getJobById(int id);

	void updateJob(Job j);

	void activateJob(Job j);

	void deactivateJob(Job j);

	void deleteJob(int id);

}
