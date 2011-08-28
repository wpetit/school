/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wilfried Petit
 * 
 */
@Entity
public class Student implements Serializable {

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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
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
