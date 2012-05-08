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
	 * Retrieve the profile list.
	 * 
	 * @return the profile list.
	 */
	List<ProfileDTO> retrieveProfiles();

	/**
	 * Create a user from a userDTO.
	 * 
	 * @param userDTO
	 *            the user.
	 */
	void createUser(UserDTO userDTO);

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
