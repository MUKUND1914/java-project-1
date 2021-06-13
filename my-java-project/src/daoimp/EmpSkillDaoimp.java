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
import dao.IEmpskillDao;
import model.EmpSkill;

public class EmpSkillDaoimp implements IEmpskillDao {
	Connection con = null;

	public EmpSkillDaoimp() throws ClassNotFoundException, SQLException {
		con = Jdbconnection.getDBconnection();
	}

	public List<EmpSkill> getAllEmpSkill() {
		List<EmpSkill> allemp = new ArrayList<EmpSkill>();
		EmpSkill emps = null;
		try {
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select*from empskill");
			while (r.next()) {
				emps = new EmpSkill();
				emps.setEsId(r.getInt(1));
				emps.setEmpId(r.getInt(2));
				emps.setSkillId(r.getInt(3));
				emps.setExpYear(r.getInt(4));
				allemp.add(emps);
			}
		} catch (SQLException a) {
			a.printStackTrace();
		}
		return allemp;
	}

	@Override
	public void addEmpSkill(EmpSkill emps) {
		try {
			PreparedStatement p = con
					.prepareStatement("insert into empskill (employeeid,skillid,expyear) values(?,?,?)");
			p.setInt(1, emps.getEmpId());
			p.setInt(2, emps.getSkillId());
			p.setInt(3, emps.getExpYear());
			int i = p.executeUpdate();
			JFrame d = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(d, "skill inserted");
			} else {
				JOptionPane.showMessageDialog(d, "not inserted");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	@Override
	public EmpSkill getEmpSkillById(int id) {
		EmpSkill skill = null;
		try {
			PreparedStatement q = con.prepareStatement("select*from empskill where esid=?");
			q.setInt(1, id);
			ResultSet rs = q.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					skill = new EmpSkill();
					skill.setEsId(rs.getInt(1));
					skill.setEmpId(rs.getInt(2));
					skill.setSkillId(rs.getInt(3));
					skill.setExpYear(rs.getInt(4));
				}
			}
		} catch (SQLException f) {
			f.printStackTrace();
		}
		return skill;
	}

	@Override
	public void updateEmpSkill(EmpSkill emps) {
		try {
			PreparedStatement e = con.prepareStatement("upadte empskill set expyear=? where esid=?");
			e.setInt(1, emps.getExpYear());
			e.setInt(2, emps.getEsId());
			int i = e.executeUpdate();
			JFrame n = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(n, "Updated");
			} else {
				JOptionPane.showMessageDialog(n, "invalid detail");

			}
		} catch (SQLException m) {
			m.printStackTrace();
		}

	}

	@Override
	public void deleteEmpSkill(int id) {
		try {
			PreparedStatement g = con.prepareStatement("delete from  empskill where esid=?");
			g.setInt(1, id);
			int i = g.executeUpdate();
			JFrame t = new JFrame();
			if (i == 1) {
				JOptionPane.showMessageDialog(t, "record deleted");
			} else {
				JOptionPane.showMessageDialog(t, "delection failed");
			}
		} catch (SQLException j) {
			j.printStackTrace();
		}

	}

}
