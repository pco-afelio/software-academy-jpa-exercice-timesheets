package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans.Employee;

public class _04_TestFindAllEmployees extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindAllEmployees() {
		java.util.List<? extends Employee> list = this.repository.findAllEmployees();
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Employee e : list) {
			assertNotNull(e);
			assertEquals(e, this.repository.findOneEmployeeById(e.getId()));
		}
	}
}
