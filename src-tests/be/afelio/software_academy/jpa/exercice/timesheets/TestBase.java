package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans.*;

public class TestBase {
	
	public void isBatman(Employee e) {
		assertNotNull(e);
		assertEquals(Long.valueOf(1), e.getId());
		assertEquals("bruce", e.getFirstname());
		assertEquals("wayne", e.getName());
		assertEquals("batman", e.getLogin());
		assertEquals("I am Batman", e.getPassword());
	}
	
	public void isWonderwoman(Employee e) {
		assertNotNull(e);
		assertEquals(Long.valueOf(2), e.getId());
		assertEquals("diana", e.getFirstname());
		assertEquals("prince", e.getName());
		assertEquals("wonder", e.getLogin());
		assertEquals("woman", e.getPassword());
	}
	
	public void isSuperman(Employee e) {
		assertNotNull(e);
		assertEquals(Long.valueOf(3), e.getId());
		assertEquals("clark", e.getFirstname());
		assertEquals("kent", e.getName());
		assertEquals("superman", e.getLogin());
		assertEquals("kal-el", e.getPassword());
	}
	
	public void isJusticeLeague(Project p) {
		assertNotNull(p);
		assertEquals(Long.valueOf(1), p.getId());
		assertEquals("Justice League", p.getName());
		assertEquals("Superheros League", p.getDescription());
		assertEquals(getStringAsDate("2017-06-21"), p.getStartDate());
		assertNull(p.getEndDate());
		isBatman(p.getManager());
	}
	
	public void isFortressOfSolitude(Project p) {
		assertNotNull(p);
		assertEquals(Long.valueOf(2), p.getId());
		assertEquals("Fortress of Solitude", p.getName());
		assertEquals("Be alone", p.getDescription());
		assertEquals(getStringAsDate("2017-06-21"), p.getStartDate());
		assertNull(p.getEndDate());
		isSuperman(p.getManager());
	}
	
	public void isSendmail(Prestation p) {
		assertNotNull(p);
		assertEquals(Long.valueOf(1), p.getId());
		assertEquals(getStringAsDate("2017-06-22"), p.getDay());
		assertEquals(2, p.getDuration());
		assertEquals("Send email", p.getComment());
		isBatman(p.getEmployee());
		isJusticeLeague(p.getProject());
	}
	
	public void isReadmail(Prestation p) {
		assertNotNull(p);
		assertEquals(Long.valueOf(2), p.getId());
		assertEquals(getStringAsDate("2017-06-23"), p.getDay());
		assertEquals(1, p.getDuration());
		assertEquals("Read email", p.getComment());
		isWonderwoman(p.getEmployee());
		isJusticeLeague(p.getProject());
	}
	
	public void isRespondmail(Prestation p) {
		assertNotNull(p);
		assertEquals(Long.valueOf(3), p.getId());
		assertEquals(getStringAsDate("2017-06-23"), p.getDay());
		assertEquals(1, p.getDuration());
		assertEquals("Send response", p.getComment());
		isWonderwoman(p.getEmployee());
		isJusticeLeague(p.getProject());
	}
	
	protected java.util.Date getStringAsDate(String s) {
		java.sql.Date d = java.sql.Date.valueOf(s);
		return new java.util.Date(d.getTime());
	}
}
