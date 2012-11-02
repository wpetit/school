/**
 * 
 */
package fr.min.school.dao.impl;

import javax.persistence.NoResultException;

import fr.min.school.dao.UserDAO;
import fr.min.school.model.User;

/**
 * DAO implementation for users.
 * 
 * @author Wilfried Petit
 * 
 */
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements
		UserDAO {

	@Override
	public User findUserById(final int id) {
		return entityManager.find(User.class, id);
	}

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

	@Override
	public void remove(int id) {
		entityManager.remove(entityManager.find(User.class, id));
	}
}
