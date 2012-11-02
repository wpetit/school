package fr.min.school.webapp.client.service.admin.user;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.min.school.model.dto.ProfileDTO;
import fr.min.school.model.dto.UserDTO;

/**
 * The client side stub for the user RPC service.
 * 
 * @author Wilfried Petit
 */
@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {

	/**
	 * Retrieve all profiles.
	 * 
	 * @return profiles found.
	 */
	List<ProfileDTO> retrieveProfiles();

	/**
	 * Create the user given.
	 * 
	 * @param userDTO
	 *            the user to create.
	 */
	void createUser(final UserDTO userDTO);

	/**
	 * Update the user given.
	 * 
	 * @param userDTO
	 *            the user to update.
	 */
	void updateUser(final UserDTO userDTO);

	/**
	 * Retrieve all users.
	 * 
	 * @return users found.
	 */
	List<UserDTO> retrieveUsers();

	/**
	 * Delete the user given.
	 * 
	 * @param userDTO
	 *            the user to delete.
	 */
	void deleteUser(UserDTO userDTO);

}
