package be.afelio.software_academy.jpa.exercice.timesheets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.entities.PrestationEntity;

public interface PrestationRepository extends JpaRepository<PrestationEntity, Integer> {
	
	List<PrestationEntity> findAllByEmployeeId(int id);
	List<PrestationEntity> findAllByProjectId(int id);
}
