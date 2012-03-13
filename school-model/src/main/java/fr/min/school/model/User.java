/**
 * 
 */
package fr.min.school.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * A school application user.
 * 
 * @author Wilfried Petit
 * 
 */
@Entity
public class User implements Model {

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = -98549091371927406L;

	/**
	 * The user id.
	 */
	private int id;

	/**
	 * Profiles the user belongs to.
	 */
	private List<Profile> profiles;

	/**
	 * The user login.
	 */
	private String login;

	/**
	 * The user password.
	 */
	private String password;

	/**
	 * Return the User id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	/**
	 * Set the User id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Return the User profiles.
	 * 
	 * @return the profiles
	 */
	@ManyToMany
	public List<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * Set the User profiles.
	 * 
	 * @param profiles
	 *            the profiles to set
	 */
	public void setProfiles(final List<Profile> profiles) {
		this.profiles = profiles;
	}

	/**
	 * Return the User login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Set the User login.
	 * 
	 * @param login
	 *            the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * Return the User password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the User password.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

}
