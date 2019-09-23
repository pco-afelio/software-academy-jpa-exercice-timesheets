package be.afelio.software_academy.jpa.exercice.timesheets;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.afelio.software_academy.jpa.exercice.timesheets.entities.*;
import be.afelio.software_academy.jpa.exercice.timesheets.repositories.*;

@Repository
public class TimesheetRepositoryImpl implements TimesheetsRepository {

	@Autowired EmployeeRepository employeeRepository;
	@Autowired ProjectRepository projectRepository;
	@Autowired PrestationRepository prestationRepository;
	
	@Override
	public List<EmployeeEntity> findAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@Override
	public EmployeeEntity findOneEmployeeById(long id) {
		return employeeRepository.findOne((int) id);
	}
	
	@Override
	public EmployeeEntity findOneEmployeeByFirstnameAndName(String firstname, String name) {
		return employeeRepository.findOneByFirstnameAndName(firstname, name);
	}
	
	@Override
	public EmployeeEntity findOneEmployeeByLoginAndPassword(String login, String password) {
		return employeeRepository.findOneByLoginAndPassword(login, password);
	}
	
	@Override
	public List<ProjectEntity> findAllProjects() {
		return projectRepository.findAll();
	}
	
	@Override
	public ProjectEntity findOneProjectById(long id) {
		return projectRepository.findOne((int) id);
	}
	
	@Override
	public ProjectEntity findOneProjectByName(String name) {
		return projectRepository.findOneByName(name);
	}
	
	@Override
	public PrestationEntity findOnePrestationById(long id) {
		return prestationRepository.findOne((int) id);
	}
	
	@Override
	public List<PrestationEntity> findAllPrestationsByEmployeeId(long id) {
		return prestationRepository.findAllByEmployeeId((int) id);
	}
	
	@Override
	public List<PrestationEntity> findAllPrestationsByProjectId(long id) {
		return prestationRepository.findAllByProjectId((int) id);
	}
	
	@Override
	public PrestationEntity addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
		PrestationEntity prestation = null;
		if (duration > 0 ) {
			EmployeeEntity employee = findOneEmployeeById(employeeId);
			if (employee != null) {
				ProjectEntity project = findOneProjectById(projectId);
				if (project != null) {
					prestation = new PrestationEntity();
					prestation.setEmployee(employee);
					prestation.setProject(project);
					prestation.setDay(day);
					prestation.setComment(comment);
					prestation.setDuration(duration);
					prestationRepository.save(prestation);
				}
			}
		}
		return prestation;
	}
	
	@Override
	public PrestationEntity deletePrestation(long id) {
		PrestationEntity prestation = findOnePrestationById(id);
		if (prestation != null) {
			prestationRepository.delete(prestation);
		}
		return prestation;
	}
	
	
}
