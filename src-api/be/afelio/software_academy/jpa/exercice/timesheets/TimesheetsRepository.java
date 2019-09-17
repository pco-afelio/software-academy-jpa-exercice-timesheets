package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;

public interface TimesheetsRepository {

	java.util.List<? extends Employee> findAllEmployees();
	Employee findOneEmployeeById(long id);
	Employee findOneEmployeeByFirstnameAndName(String firstname, String name);
	Employee findOneEmployeeByLoginAndPassword(String login, String password);
	java.util.List<? extends Project> findAllProjects();
	Project findOneProjectById(long id);
	Project findOneProjectByName(String name);
	Prestation findOnePrestationById(long id);
	java.util.List<? extends Prestation> findAllPrestationsByEmployeeId(long id);
	java.util.List<? extends Prestation> findAllPrestationsByProjectId(long id);
	Prestation addPrestation(long employeeId, long projectId, String comment, 
			java.util.Date day, int duration);
	Prestation deletePrestation(long id);
}
