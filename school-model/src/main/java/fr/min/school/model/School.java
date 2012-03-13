/**
 * 
 */
package fr.min.school.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This class represents a school.
 * 
 * @author Wilfried Petit
 * 
 */
@Entity
public class School implements Model {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 2485483630021031653L;
	/**
	 * The address of the school.
	 */
	private String address;
	/**
	 * The classes belongs to the school.
	 */
	private List<StudentClass> classes;
	/**
	 * The id of the school.
	 */
	private Integer id;
	/**
	 * The name of the school.
	 */
	private String name;

	/**
	 * Constructor of a school.
	 */
	public School() {
		classes = new ArrayList<StudentClass>();
	}

	/**
	 * Return the school address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Return the school classes.
	 * 
	 * @return the classes
	 */
	@OneToMany(fetch = FetchType.EAGER)
	public List<StudentClass> getClasses() {
		return classes;
	}

	/**
	 * Return the school id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	/**
	 * Return the school name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the school address.
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * Set the school classes.
	 * 
	 * @param classes
	 *            the classes to set
	 */
	public void setClasses(final List<StudentClass> classes) {
		this.classes = classes;
	}

	/**
	 * Set the school id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Set the school name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [address=" + address + ", classes=" + classes + ", id="
				+ id + ", name=" + name + "]";
	}

}
