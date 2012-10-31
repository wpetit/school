/**
 * 
 */
package fr.min.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	 * Profile the user belongs to.
	 */
	private Profile profile;

	/**
	 * The user login.
	 */
	private String login;

	/**
	 * The user password.
	 */
	private String password;

	/**
	 * The user firstname.
	 */
	private String firstname;

	/**
	 * The user name.
	 */
	private String name;

	/**
	 * The user email.
	 */
	private String email;

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
	@ManyToOne
	public Profile getProfile() {
		return profile;
	}

	/**
	 * Set the User profile.
	 * 
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(final Profile profile) {
		this.profile = profile;
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

	/**
	 * Set the User email.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Return the User email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the User firstname.
	 * 
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Return the User firstname.
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Set the User name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the User name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
