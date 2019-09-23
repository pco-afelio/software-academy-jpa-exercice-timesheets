package be.afelio.software_academy.jpa.exercice.timesheets.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;

@Entity(name="Employee")
@Table(name="employee")
public class EmployeeEntity implements Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String firstname;
	private String login;
	private String password;
	@OneToMany(mappedBy="manager", fetch=FetchType.LAZY)
	private List<ProjectEntity> managedProjects;
	
	@OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
	private List<PrestationEntity> prestations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ProjectEntity> getManagedProjects() {
		return managedProjects;
	}

	public void setManagedProjects(List<ProjectEntity> managedProjects) {
		this.managedProjects = managedProjects;
	}

	public List<PrestationEntity> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<PrestationEntity> prestations) {
		this.prestations = prestations;
	}

	public Long getId() {
		if (id == null) {
			return null;
		}
		return Long.valueOf(id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, login, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EmployeeEntity))
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		return Objects.equals(firstname, other.firstname) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
}
