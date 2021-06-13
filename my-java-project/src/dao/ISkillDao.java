package dao;

import java.util.List;

import model.Skill;

public interface ISkillDao {
	List<Skill> getAllSkill();

	void addSkill(Skill skill);

	Skill getSkillById(int id);

	void updateSkill(Skill skill);

	void activateSkill(Skill skill);

	void deactivateSkill(Skill skill);

	void deleteSkill(int id);
}
