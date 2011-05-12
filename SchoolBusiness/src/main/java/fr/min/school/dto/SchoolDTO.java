/**
 * 
 */
package fr.min.school.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author minimoi
 * 
 */
public class SchoolDTO {

	private String address;
	private List<Integer> classes;
	private int id;

	private String name;

	public SchoolDTO() {
		this.classes = new ArrayList<Integer>();
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
	public List<Integer> getClasses() {
		return this.classes;
	}

	/**
	 * @return the id
	 */
	public int getId() {
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
	public void setClasses(final List<Integer> classes) {
		this.classes = classes;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchoolDTO [address=" + this.address + ", classes="
				+ this.classes + ", id=" + this.id + ", name=" + this.name
				+ "]";
	}

}
