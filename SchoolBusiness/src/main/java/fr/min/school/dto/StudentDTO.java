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
public class StudentDTO {

	private int age;
	private String firstname;
	private int id;
	private String name;

	private List<Integer> works;

	public StudentDTO() {
		this.works = new ArrayList<Integer>();
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
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
	 * @return the works
	 */
	public List<Integer> getWorks() {
		return this.works;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(final int age) {
		this.age = age;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
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

	/**
	 * @param works
	 *            the works to set
	 */
	public void setWorks(final List<Integer> works) {
		this.works = works;
	}
}
