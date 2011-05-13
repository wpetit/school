/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author minimoi
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
	 * The works the student has done.
	 */
	private List<Work> works;

	/**
	 * Constructor.
	 */
	public Student() {
		this.works = new ArrayList<Work>();
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
	 * @return the works
	 */
	@ManyToMany(mappedBy = "students")
	public List<Work> getWorks() {
		return this.works;
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
	 * @param works
	 *            the works to set
	 */
	public void setWorks(final List<Work> works) {
		this.works = works;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return this.birthday;
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
		return "Student [birthday=" + this.birthday + ", firstname="
				+ this.firstname + ", id=" + this.id + ", name=" + this.name
				+ ", works=" + this.works + "]";
	}

}
