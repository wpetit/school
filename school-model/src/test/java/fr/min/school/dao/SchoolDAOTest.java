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

import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;

/**
 * @author Wilfried Petit
 * 
 */
public class SchoolDAOTest extends TestCase {

	/**
	 * SchoolDao call for tests.
	 */
	private SchoolDAO schoolDao;

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"ModelContext.xml");
		schoolDao = (SchoolDAO) applicationContext.getBean("schoolDao");
	}

	/**
	 * Test method saveOrUpdate of {@link SchoolDAO} with valid school data.
	 */
	@Test
	public void testSaveOrUpdateWithValidSchoolData() {
		final School school = new School();
		school.setName("Collège de Chatelaudren");
		school.setAddress("Chatelaudren");
		schoolDao.createSchool(school);

		List<School> schoolsFound;
		try {
			schoolsFound = schoolDao.findAll();
			for (final School schoolFound : schoolsFound) {
				Assert.assertEquals(school.getAddress(),
						schoolFound.getAddress());
				Assert.assertEquals(school.getName(), schoolFound.getName());
			}
		} catch (final TechnicalException e) {
			Assert.fail();
		}

	}
}
