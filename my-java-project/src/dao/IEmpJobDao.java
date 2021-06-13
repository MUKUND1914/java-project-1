package dao;

import java.util.List;

import model.Empjob;

public interface IEmpJobDao {
List<Empjob> getAllEmpJob(); 
void addEmpJob(Empjob emj);
Empjob getEmpJobById(int i);
void updateEmpJob(Empjob emj);
void deleteEmpJob(int id);
}
