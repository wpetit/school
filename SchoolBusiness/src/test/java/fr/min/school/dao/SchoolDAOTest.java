/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.min.school.dto.SchoolDTO;
import fr.min.school.exception.TechnicalException;

/**
 * @author minimoi
 * 
 */
public class SchoolDAOTest extends TestCase {

	private SchoolDAO schoolDao;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
		this.schoolDao = (SchoolDAO) applicationContext.getBean("schoolDao");
	}

	/**
	 * Test method saveOrUpdate of {@link SchoolDAO} with valid school data
	 */
	@Test
	public void testSaveOrUpdateWithValidSchoolData() {
		final SchoolDTO school = new SchoolDTO();
		school.setName("Collège de Chatelaudren");
		school.setAddress("Chatelaudren");
		this.schoolDao.createSchool(school);

		List<SchoolDTO> schoolsFound;
		try {
			schoolsFound = this.schoolDao.findAll();
			System.out.println(schoolsFound);
			for (final SchoolDTO schoolFound : schoolsFound) {
				Assert.assertEquals(school.getAddress(),
						schoolFound.getAddress());
				Assert.assertEquals(school.getName(), schoolFound.getName());
			}
		} catch (final TechnicalException e) {
			Assert.fail();
		}

	}
}
