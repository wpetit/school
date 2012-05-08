/**
 * 
 */
package fr.min.school.dao;

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
	 * Find a user by its login and its password. Return null if no one has been
	 * found.
	 * 
	 * @param login
	 *            its login.
	 * @param password
	 *            its password.
	 * @return the user found.
	 */
	User findUserByLoginPassword(final String login, final String password);

	/**
	 * Create a user.
	 * 
	 * @param user
	 *            the user to create.
	 */
	void createUser(final User user);
}
