/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.UserDAO;
import fr.min.school.model.Profile;
import fr.min.school.model.User;

/**
 * @author Wilfried Petit
 * 
 */
public class UserDAOImpl extends JpaDaoSupport implements UserDAO {

	/**
	 * @see fr.min.school.dao.UserDAO#findUserById(int)
	 */
	@Override
	public User findUserById(final int id) {
		return getJpaTemplate().find(User.class, id);
	}

	/**
	 * @see fr.min.school.dao.UserDAO#findUserByLoginPassord(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public User findUserByLoginPassord(final String login, final String password) {
		return (User) getJpaTemplate().find(
				"select u from user u where u.login=?1 and u.password=?2",
				login, password).get(0);
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
		getJpaTemplate().persist(user);
	}

}
