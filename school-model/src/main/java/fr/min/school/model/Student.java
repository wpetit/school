/**
 * 
 */
package fr.min.school.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wilfried Petit
 * 
 */
@Entity
public class Student implements Model {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 6264370191320323638L;

	/**
	 * The birthday of the student.
	 */
	private Date birthday;
	/**
	 * The firstname of the student.
	 */
	private String firstname;
	/**
	 * The id of the student.
	 */
	private Integer id;
	/**
	 * The name of the student.
	 */
	private String name;

	/**
	 * Return the student firstname.
	 * 
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Return the student id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	/**
	 * Return the student name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the student firstname.
	 * 
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Set the student id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Set the student name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Return the student birthday.
	 * 
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Set the student birthday.
	 * 
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(final Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [birthday=" + birthday + ", firstname=" + firstname
				+ ", id=" + id + ", name=" + name + "]";
	}
}
