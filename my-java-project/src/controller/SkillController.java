package controller;

import java.sql.SQLException;
import java.util.List;

import dao.ISkillDao;
import daoimp.SkillDaoimp;
import model.Skill;

public class SkillController {
	ISkillDao s = null;

	public SkillController() throws ClassNotFoundException, SQLException {
		s = new SkillDaoimp();
	}

	public void addSkill(String SN, String SD) {
		Skill sa = new Skill();
		sa.setSkillName(SN);
		sa.setSkillDescription(SD);
		if(SN.equals("Leagership"))
		{
			sa.setActive("Active");
		}
		else
		{
			sa.setActive("Deactive");
		}
		
		s.addSkill(sa);
	}

	public void getAllSkills() {
		List<Skill> allSkillList = s.getAllSkill();
		for (Skill ski : allSkillList) {
			System.out.println(ski);
		}

	}

	public void getSkillById(int id) {
		s.getSkillById(id);
	}

	public void updateSkill(String sname, String sdesc, int id) {
		Skill sk = null;
		sk = s.getSkillById(id);
		sk.setSkillName(sname);
		sk.setSkillDescription(sdesc);

		s.updateSkill(sk);

	}

	public void activateSkill(int id) {
		Skill skill = null;
		skill = s.getSkillById(id);
		s.activateSkill(skill);

	}

	public void deactivateSkill(int id) {
		Skill skill = null;
		skill = s.getSkillById(id);
		s.deactivateSkill(skill);
	}

	public void deleteSkill(int id) {
		s.deleteSkill(id);
	}

}
