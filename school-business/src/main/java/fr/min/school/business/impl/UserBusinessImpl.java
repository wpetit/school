/**
 * 
 */
package fr.min.school.business.impl;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.business.UserBusiness;
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

	/**
	 * User dao.
	 */
	private UserDAO userDAO;

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
	 * @see fr.min.school.business.UserBusiness#createUser(java.lang.String,
	 *      java.lang.String, java.util.List)
	 */
	@Override
	public void createUser(final String login, final String password,
			final List<ProfileDTO> profiles) {
		final List<Profile> realProfiles = new ArrayList<Profile>();
		for (final ProfileDTO profile : profiles) {
			mapper.map(profile, Profile.class);
		}
		userDAO.createUser(login, password, realProfiles);
	}

	/**
	 * @see fr.min.school.business.UserBusiness#findUserByLoginPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public UserDTO findUserByLoginPassword(final String login,
			final String password) {
		User user = userDAO.findUserByLoginPassword(login, password);
		if (user != null) {
			return mapper.map(user, UserDTO.class);
		} else {
			return null;
		}
	}
}
