/**
 * 
 */
package fr.min.school.business;

import java.util.List;

import fr.min.school.model.dto.ProfileDTO;
import fr.min.school.model.dto.UserDTO;

/**
 * User business.
 * 
 * @author Wilfried Petit
 * 
 */
public interface UserBusiness extends Business {

	/**
	 * Create a user from a login, a password and profiles.
	 * 
	 * @param login
	 *            the user login.
	 * @param password
	 *            the user password.
	 * @param profiles
	 *            profiles user belongs to.
	 */
	void createUser(String login, String password, List<ProfileDTO> profiles);

	/**
	 * Find a user by its login and its password.
	 * 
	 * @param login
	 *            the user login.
	 * @param password
	 *            the user password.
	 * @return the user found.
	 */
	UserDTO findUserByLoginPassword(String login, String password);

}
