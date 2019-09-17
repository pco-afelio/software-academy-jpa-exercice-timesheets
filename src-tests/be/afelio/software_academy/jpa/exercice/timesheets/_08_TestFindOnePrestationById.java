package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;

public class _08_TestFindOnePrestationById extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindSendmailById() {
		Prestation p = this.repository.findOnePrestationById(1L);
		this.isSendmail(p);
	}
	
	@Test
	public void testFindReadmailById() {
		Prestation p = this.repository.findOnePrestationById(2L);
		this.isReadmail(p);
	}

}
