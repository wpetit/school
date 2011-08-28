/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
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
public class School implements Serializable {
	/**
     * 
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

	private String text;
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
		this.classes = new ArrayList<StudentClass>();
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @return the classes
	 */
	@OneToMany(fetch = FetchType.EAGER)
	public List<StudentClass> getClasses() {
		return this.classes;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * @param classes
	 *            the classes to set
	 */
	public void setClasses(final List<StudentClass> classes) {
		this.classes = classes;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [address=" + this.address + ", classes=" + this.classes
				+ ", id=" + this.id + ", name=" + this.name + "]";
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}

}
