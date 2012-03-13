/**
 * 
 */
package fr.min.school.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Wilfried Petit
 * 
 */
@Entity
public class Profile implements Model {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 8454709333491800904L;
	/**
	 * The profile id.
	 */
	private int id;
	/**
	 * The profile name
	 */
	private String name;

	/**
	 * Return the profile id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	/**
	 * Set the Profile id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Return the profile name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the profile name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
}
