package model;

public class EmpSkill extends Employee {

	private int EsId;
	private int empId;
	private int SkillId;
	private int ExpYear;

	public EmpSkill() {
		super();
	}

	public EmpSkill(int empId, int skillId, int expYear) {
		super();
		this.empId = empId;
		SkillId = skillId;
		ExpYear = expYear;
	}

	public int getEsId() {
		return EsId;
	}

	public void setEsId(int esId) {
		EsId = esId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSkillId() {
		return SkillId;
	}

	public void setSkillId(int skillId) {
		SkillId = skillId;
	}

	public int getExpYear() {
		return ExpYear;
	}

	public void setExpYear(int expYear) {
		ExpYear = expYear;
	}

	public String toString() {
		return "Empskill [EsId=" + EsId + ", empId=" + empId + ", SkillId=" + SkillId + ", ExpYear=" + ExpYear + "]";
	}

}
