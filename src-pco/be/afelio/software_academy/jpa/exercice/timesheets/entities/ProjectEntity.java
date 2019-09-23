package be.afelio.software_academy.jpa.exercice.timesheets.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;

@Entity(name="Project")
@Table(name="project")
public class ProjectEntity implements Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manager")
	private EmployeeEntity manager;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public EmployeeEntity getManager() {
		return manager;
	}
	
	public void setManager(EmployeeEntity manager) {
		this.manager = manager;
	}
	
	public Long getId() {
		if (id == null) {
			return null;
		}
		return Long.valueOf(id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, endDate, id, manager, name, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProjectEntity))
			return false;
		ProjectEntity other = (ProjectEntity) obj;
		return Objects.equals(description, other.description) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(id, other.id) && Objects.equals(manager, other.manager)
				&& Objects.equals(name, other.name) && Objects.equals(startDate, other.startDate);
	}
}
