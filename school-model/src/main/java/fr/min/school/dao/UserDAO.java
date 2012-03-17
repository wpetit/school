/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import fr.min.school.model.Profile;
import fr.min.school.model.User;

/**
 * This interface defines a user DAO.
 * 
 * @author Wilfried Petit
 * 
 */
public interface UserDAO extends GenericDAO<User, Integer> {

	/**
	 * Find a user by its id.
	 * 
	 * @param id
	 *            the user id.
	 * @return the user found.
	 */
	User findUserById(final int id);

	/**
	 * Find a user by its login and its password.
	 */
	User findUserByLoginPassord(final String login, final String password);

	/**
	 * Create a user.
	 * 
	 * @param login
	 *            the user login.
	 * @param password
	 *            the user password.
	 * @param profiles
	 *            profiles the user belongs to.
	 */
	void createUser(final String login, final String password,
			final List<Profile> profiles);
}
