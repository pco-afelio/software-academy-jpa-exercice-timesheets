package be.afelio.software_academy.jpa.exercice.timesheets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.timesheets.beans.Project;

public class _03_TestFindOneEmployeeByLoginAndPassword extends TestBase {

	private TimesheetsRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindBatmanByLoginAndPassword() {
		Employee e = this.repository.findOneEmployeeByLoginAndPassword("batman", "I am Batman");
		this.isBatman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(1, list.size());
		this.isJusticeLeague(list.get(0));
	}
	
	@Test
	public void testFindWonderwomanByLoginAndPassword() {
		Employee e = repository.findOneEmployeeByLoginAndPassword("wonder", "woman");
		this.isWonderwoman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(0, list.size());
	}

}
