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
import dao.ISkillDao;
import model.Skill;

public class SkillDaoimp implements ISkillDao {
	Connection con = null;

	public SkillDaoimp() throws ClassNotFoundException, SQLException {
		con = Jdbconnection.getDBconnection();
	}

	@Override
	public List<Skill> getAllSkill() {
		List<Skill> allskill = new ArrayList<Skill>();
		try {
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select *from skill");
			if (r != null) {
				Skill s = null;
				while (r.next()) {
					s = new Skill();
					s.setSkillId(r.getInt(1));
					s.setSkillName(r.getString(2));
					s.setSkillDescription(r.getString(3));
					s.setActive(r.getString(4));
					allskill.add(s);
				}
			}
		} catch (Exception q) {
			q.printStackTrace();
		}
		return allskill;
	}

	@Override
	public void addSkill(Skill skill) {
		try {
			PreparedStatement p = con
					.prepareStatement("insert into skill (skillname,skilldescription,active) values(?,?,?)");
			p.setString(1, skill.getSkillName());
			p.setString(2, skill.getSkillDescription());
			p.setString(3, skill.getActive());
	
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Record Added");
			} else {
				JOptionPane.showMessageDialog(f, "Failed to add");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Skill getSkillById(int id) {
		Skill s = new Skill();
		try {
			PreparedStatement p = con.prepareStatement("select*From skill where skillid=?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if (r != null) {
				while (r.next()) {
					s.setSkillId(r.getInt(1));
					s.setSkillName(r.getString(2));
					s.setSkillDescription(r.getString(3));
					s.setActive(r.getString(4));
				}
			}
		} catch (Exception a) {
			a.printStackTrace();
		}
		return s;
	}

	@Override
	public void updateSkill(Skill skill) {
		try {
			PreparedStatement p = con
					.prepareStatement("update skill set skillname=?,skilldescription=? where skillid=?");
			p.setString(1, skill.getSkillName());
			p.setString(2, skill.getSkillDescription());
			p.setInt(3, skill.getSkillId());
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Record Updated");
			} else {
				JOptionPane.showMessageDialog(f, "Failed to update");
			}
		} catch (Exception g) {
			g.printStackTrace();
		}

	}

	@Override
	public void activateSkill(Skill skill) {
		try {
			PreparedStatement p = con.prepareStatement("update skill set active=? where skillid=?");
			p.setString(1, "Active");
			p.setInt(2, skill.getSkillId());
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Activated");
			} else {
				JOptionPane.showMessageDialog(f, "invalid User");
			}
		} catch (Exception q) {
			q.printStackTrace();
		}

	}

	@Override
	public void deactivateSkill(Skill skill) {
		try {
			PreparedStatement p = con.prepareStatement("update skill set active=? where skillid=?");
			p.setString(1, "Deactive");
			p.setInt(2, skill.getSkillId());
			int i = p.executeUpdate();
			JFrame f = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(f, "Deactivated");
			} else {
				JOptionPane.showMessageDialog(f, "invalid User");
			}
		} catch (Exception q) {
			q.printStackTrace();
		}

	}

	@Override
	public void deleteSkill(int id) {
		try {
			PreparedStatement p = con.prepareStatement("delete from skill where skillid=?");
			p.setInt(1, id);
			int i = p.executeUpdate();
			JFrame g = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(g, "Skill Deleted");
			} else {
				JOptionPane.showMessageDialog(g, "Invalid User");
			}
		} catch (Exception a) {
			a.printStackTrace();
		}
	}

}
