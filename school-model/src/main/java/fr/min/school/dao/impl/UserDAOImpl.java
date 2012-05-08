/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import fr.min.school.dao.UserDAO;
import fr.min.school.model.Profile;
import fr.min.school.model.User;

/**
 * DAO implementation for users.
 * 
 * @author Wilfried Petit
 * 
 */
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements
		UserDAO {

	/**
	 * @see fr.min.school.dao.UserDAO#findUserById(int)
	 */
	@Override
	public User findUserById(final int id) {
		return entityManager.find(User.class, id);
	}

	/**
	 * @see fr.min.school.dao.UserDAO#findUserByLoginPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public User findUserByLoginPassword(final String login,
			final String password) {
		try {
			return (User) entityManager
					.createQuery(
							"select u from User u where u.login=:login and u.password=:password")
					.setParameter("login", login)
					.setParameter("password", password).getSingleResult();
		} catch (NoResultException noResultException) {
			return null;
		}
	}

	/**
	 * @see fr.min.school.dao.UserDAO#createUser(java.lang.String,
	 *      java.lang.String, java.util.List)
	 */
	@Override
	public void createUser(final String login, final String password,
			final List<Profile> profiles) {
		final User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setProfiles(profiles);
		entityManager.persist(user);
	}

}
