package be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans;

public interface Project {

	Long getId();

	String getName();

	String getDescription();

	java.util.Date getStartDate();

	java.util.Date getEndDate();

	Employee getManager();

}