/**
 * 
 */
package fr.min.school.dao;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.min.school.model.User;

/**
 * @author Wilfried Petit
 * 
 */
public class UserDAOTest extends TestCase {

	/**
	 * UserDao call for tests.
	 */
	private UserDAO userDao;

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
		userDao = (UserDAO) applicationContext.getBean("userDao");
	}

	/**
	 * Test method findUserByLoginPassword of {@link UserDAO} with invalid
	 * login/password data.
	 */
	@Test
	public void testFindUserByLoginPasswordWithInvalidDatas() {
		User user = userDao.findUserByLoginPassword("login", "password");
		Assert.assertNull(user);
	}
}
