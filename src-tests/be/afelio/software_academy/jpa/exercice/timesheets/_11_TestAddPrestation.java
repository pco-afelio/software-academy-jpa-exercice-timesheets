package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;

public class _11_TestAddPrestation extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testAddPrestation() {
		long time = System.currentTimeMillis();
		long employeeId = 3L;
		long projectId = 2L;
		java.util.Date day = this.getStringAsDate("2017-06-30");
		String comment = String.valueOf(time);
		int duration = 3;
		
		Prestation p = this.repository.addPrestation(employeeId, projectId, comment, day, duration);
		assertNotNull(p);
		assertNotNull(p.getId());
		assertEquals(day, p.getDay());
		assertEquals(comment, p.getComment());
		assertEquals(duration, p.getDuration());
		this.isSuperman(p.getEmployee());
		this.isFortressOfSolitude(p.getProject());
		
		Prestation p2 = this.repository.findOnePrestationById(p.getId());
		assertNotNull(p2);
		assertEquals(p, p2);
	}
}
