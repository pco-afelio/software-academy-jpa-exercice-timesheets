package be.afelio.software_academy.jpa.exercice.timesheets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.entities.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

	ProjectEntity findOneByName(String name);
}
