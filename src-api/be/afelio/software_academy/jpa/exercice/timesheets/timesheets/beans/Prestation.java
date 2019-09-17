package be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans;

public interface Prestation {

	Long getId();

	java.util.Date getDay();

	Employee getEmployee();

	Project getProject();

	int getDuration();

	String getComment();

}