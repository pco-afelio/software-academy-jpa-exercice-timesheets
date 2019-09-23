package be.afelio.software_academy.jpa.exercice.timesheets.entities;

import java.util.*;

import javax.persistence.*;

import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;

@Entity(name="Prestation")
@Table(name="prestation")
public class PrestationEntity implements Prestation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Date day;
	private int duration;
	private String comment;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project")
	private ProjectEntity project;
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name="employee")
	private EmployeeEntity employee;
	
	public Date getDay() {
		return day;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public ProjectEntity getProject() {
		return project;
	}
	
	public void setProject(ProjectEntity project) {
		this.project = project;
	}
	
	public EmployeeEntity getEmployee() {
		return employee;
	}
	
	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}
	
	public Long getId() {
		if (id == null) {
			return null;
		}
		return Long.valueOf(id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, day, duration, employee, id, project);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PrestationEntity))
			return false;
		PrestationEntity other = (PrestationEntity) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(day, other.day) && duration == other.duration
				&& Objects.equals(employee, other.employee) && Objects.equals(id, other.id)
				&& Objects.equals(project, other.project);
	}
}
