/**
 * 
 */
package fr.min.school.business.impl;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.business.UserBusiness;
import fr.min.school.dao.ProfileDAO;
import fr.min.school.dao.UserDAO;
import fr.min.school.model.Profile;
import fr.min.school.model.User;
import fr.min.school.model.dto.ProfileDTO;
import fr.min.school.model.dto.UserDTO;

/**
 * This class manage the user business.
 * 
 * @author Wilfried Petit
 * 
 */
public class UserBusinessImpl extends AbstractBusiness implements UserBusiness {

	/** User dao. **/
	private UserDAO userDAO;

	/** Profile DAO. **/
	private ProfileDAO profileDAO;

	/**
	 * Set the userDAO use by the business.
	 * 
	 * @param userDAO
	 *            the userDAO to set
	 */
	public void setUserDAO(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Set the profileDAO use by the business.
	 * 
	 * @param profileDAO
	 *            the profileDAO to set
	 */
	public void setProfileDAO(final ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	@Override
	public void createUser(final UserDTO userDTO) {
		User user = mapper.map(userDTO, User.class);
		userDAO.createUser(user);
	}

	@Override
	public void updateUser(final UserDTO userDTO) {
		User user = mapper.map(userDTO, User.class);
		userDAO.refresh(user);
	}

	@Override
	public UserDTO findUserByLoginPassword(final String login,
			final String password) {
		return mapper.map(userDAO.findUserByLoginPassword(login, password),
				UserDTO.class);
	}

	@Override
	public List<ProfileDTO> retrieveProfiles() {
		List<ProfileDTO> profileDTOs = new ArrayList<ProfileDTO>();
		for (Profile profile : profileDAO.findAll()) {
			profileDTOs.add(mapper.map(profile, ProfileDTO.class));
		}
		return profileDTOs;
	}
}
