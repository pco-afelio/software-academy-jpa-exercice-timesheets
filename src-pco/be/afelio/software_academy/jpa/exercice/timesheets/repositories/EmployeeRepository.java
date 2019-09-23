package be.afelio.software_academy.jpa.exercice.timesheets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	EmployeeEntity findOneByFirstnameAndName(String firstname, String name);
	EmployeeEntity findOneByLoginAndPassword(String login, String password);
}
