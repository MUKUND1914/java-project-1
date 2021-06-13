package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.Jdbconnection;
import dao.IJobDao;
import model.Job;

public class JobDaoimp implements IJobDao {
	Connection con = null;

	public JobDaoimp() throws ClassNotFoundException, SQLException {
		con = Jdbconnection.getDBconnection();
	}

	@Override
	public List<Job> getAllJob() {
		List<Job> alljob = new ArrayList<Job>();
		Job j = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from job");
			if (rs != null) {
				while (rs.next()) {
					j = new Job();
					j.setJobId(rs.getInt(1));
					j.setJobTitle(rs.getString(2));
					j.setJobDescription(rs.getString(3));
					j.setCompanyName(rs.getString(4));
					j.setLocation(rs.getString(5));
					j.setKeySkill(rs.getString(6));
					j.setSalary(rs.getString(7));
					j.setActive(rs.getString(8));
					alljob.add(j);
				}
			}
		} catch (SQLException w) {
			w.printStackTrace();
		}
		return alljob;
	}

	@Override
	public void addJob(Job job) {
		try {
			PreparedStatement p = con.prepareStatement(
					"insert into job(jobtitle,jobdescription,companyname,location,keyskill,salary,active) values(?,?,?,?,?,?,?)");
			p.setString(1, job.getJobTitle());
			p.setString(2, job.getJobDescription());
			p.setString(3, job.getCompanyName());
			p.setString(4, job.getLocation());
			p.setString(5, job.getKeySkill());
			p.setString(6, job.getSalary());
			p.setString(7, job.getActive());
			int i = p.executeUpdate();
			JFrame y = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(y, "Record inserted");
			} else {
				JOptionPane.showMessageDialog(y, "Not Inserted ");
			}
		} catch (Exception d) {
			d.printStackTrace();
		}

	}

	@Override
	public Job getJobById(int id) {
		Job j = null;
		try {
			PreparedStatement p = con.prepareStatement("select*from job where jobid=?");
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					j = new Job();
					j.setJobId(rs.getInt(1));
					j.setJobTitle(rs.getString(2));
					j.setJobDescription(rs.getString(3));
					j.setCompanyName(rs.getString(4));
					j.setLocation(rs.getString(5));
					j.setKeySkill(rs.getString(6));
					j.setSalary(rs.getString(7));
					j.setActive(rs.getString(8));

				}
			}
		} catch (Exception g) {
			g.printStackTrace();
		}

		return j;
	}

	@Override
	public void updateJob(Job j) {
		try {
			PreparedStatement pst = con.prepareStatement("update job set location=? where jobid=?");
			pst.setString(1, j.getLocation());
			pst.setInt(2, j.getJobId());
			int i = pst.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Record Upadted");
			} else {
				JOptionPane.showMessageDialog(f, "Failed to update");
			}

		} catch (Exception z) {
			z.printStackTrace();
		}

	}

	@Override
	public void activateJob(Job j) {
		try {
			PreparedStatement p = con.prepareStatement("update Job set active=? where JobId=?");
			p.setString(1, "Active");
			p.setInt(2, j.getJobId());
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Job activated");
			} else {
				JOptionPane.showMessageDialog(f, "Not activated ");
			}
		} catch (Exception h) {
			h.printStackTrace();
		}

	}

	@Override
	public void deactivateJob(Job j) {
		try {
			PreparedStatement p = con.prepareStatement("update Job set active=? where JobId=?");
			p.setString(1, "Deactive");
			p.setInt(2, j.getJobId());
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Job Deactivated ");
			} else {
				JOptionPane.showMessageDialog(f, "Failed to deactivate");
			}
		} catch (Exception d) {
			d.printStackTrace();
		}

	}

	@Override
	public void deleteJob(int id) {
		try {
			PreparedStatement p = con.prepareStatement("delete from job where jobid=?");
			p.setInt(1, id);
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Job Deleted");
			} else {
				JOptionPane.showMessageDialog(f, "Failed to delete");
			}
		} catch (Exception g) {
			g.printStackTrace();
		}

	}

}
