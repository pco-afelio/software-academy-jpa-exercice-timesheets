package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans.Project;

public class _06_TestFindOneProjectByName extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindJusticeLeagueByName() {
		Project p = this.repository.findOneProjectByName("Justice League");
		this.isJusticeLeague(p);
	}
}
