package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;

public class _07_TestFindAllProjects extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindAllProjects() {
		java.util.List<? extends Project> list = this.repository.findAllProjects();
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Project p : list) {
			assertNotNull(p);
			assertNotNull(p.getId());
			assertEquals(p, this.repository.findOneProjectById(p.getId()));
		}
	}
}
