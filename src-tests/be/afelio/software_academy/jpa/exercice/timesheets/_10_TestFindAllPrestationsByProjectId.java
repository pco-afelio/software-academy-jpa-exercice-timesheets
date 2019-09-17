package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans.Prestation;

public class _10_TestFindAllPrestationsByProjectId extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindAllPrestationsByProjectId() {
		java.util.List<? extends Prestation> list = this.repository.findAllPrestationsByProjectId(1L);
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Prestation p : list) {
			assertNotNull(p);
			assertEquals(p, this.repository.findOnePrestationById(p.getId()));
		}
	}

}
