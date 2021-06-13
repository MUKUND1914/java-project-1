package dao;

import java.util.List;

import model.EmpSkill;

public interface IEmpskillDao {
 List<EmpSkill> getAllEmpSkill();
 void addEmpSkill(EmpSkill emps);
 EmpSkill getEmpSkillById(int id);
 void updateEmpSkill(EmpSkill emps);
 void deleteEmpSkill(int id);
}
