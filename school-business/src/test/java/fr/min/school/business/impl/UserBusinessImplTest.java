/**
 * 
 */
package fr.min.school.business.impl;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import fr.min.school.dao.UserDAO;
import fr.min.school.model.User;
import fr.min.school.model.dto.UserDTO;

/**
 * Test class for UserBusinessImpl.
 * 
 * @author Wilfried Petit
 * 
 */
public class UserBusinessImplTest {

	private Mapper mapper;
	private UserBusinessImpl userBusiness;

	private UserDAO userDAO;

	@Before
	public void setUp() {
		userBusiness = new UserBusinessImpl();
		mapper = new DozerBeanMapper();
		userDAO = EasyMock.createMock(UserDAO.class);
		userBusiness.setUserDAO(userDAO);
		userBusiness.setMapper(mapper);
	}

	/**
	 * Test createUser with user null. User dao must not be called.
	 */
	@Test
	public void testCreateUserWithNullUser() {
		EasyMock.replay(userDAO);
		userBusiness.createUser(null);
		EasyMock.verify(userDAO);
	}

	/**
	 * Test createUser with valid user. User dao must be called.
	 */
	@Test
	public void testCreateUserWithValidUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin("test");
		userDAO.persist(EasyMock.anyObject(User.class));
		EasyMock.replay(userDAO);
		userBusiness.createUser(userDTO);
		EasyMock.verify(userDAO);
	}

	/**
	 * Test updateUser with user null. User dao must not be called.
	 */
	@Test
	public void testUpdateUserWithNullUser() {
		EasyMock.replay(userDAO);
		userBusiness.updateUser(null);
		EasyMock.verify(userDAO);
	}

	/**
	 * Test updateUser with valid user. User dao must be called.
	 */
	@Test
	public void testUpdateUserWithValidUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin("test");
		userDAO.save(EasyMock.anyObject(User.class));
		EasyMock.replay(userDAO);
		userBusiness.updateUser(userDTO);
		EasyMock.verify(userDAO);
	}

	/**
	 * Test deleteUser with user null. User dao must not be called.
	 */
	@Test
	public void testDeleteUserWithNullUser() {
		EasyMock.replay(userDAO);
		userBusiness.deleteUser(null);
		EasyMock.verify(userDAO);
	}

	/**
	 * Test deleteUser with valid user. User dao must be called.
	 */
	@Test
	public void testDeleteUserWithValidUser() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(1);
		userDTO.setLogin("test");
		userDAO.remove(1);
		EasyMock.replay(userDAO);
		userBusiness.deleteUser(userDTO);
		EasyMock.verify(userDAO);
	}
}
