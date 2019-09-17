package be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans;

public interface Employee {

	Long getId();

	String getFirstname();

	String getName();

	String getLogin();

	String getPassword();

	java.util.List<? extends Project> getManagedProjects();

	java.util.List<? extends Prestation> getPrestations();

}