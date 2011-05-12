/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author minimoi
 * 
 */
@Entity
public class StudentClass implements Serializable {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 6156343491842539547L;
	private Integer id;
	private SchoolYear schoolYear;
	private List<Student> students;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the schoolYear
	 */
	@ManyToOne
	public SchoolYear getSchoolYear() {
		return this.schoolYear;
	}

	/**
	 * @return the students
	 */
	@OneToMany
	public List<Student> getStudents() {
		return this.students;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param schoolYear
	 *            the schoolYear to set
	 */
	public void setSchoolYear(final SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}

	/**
	 * @param students
	 *            the students to set
	 */
	public void setStudents(final List<Student> students) {
		this.students = students;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentClass [id=" + this.id + ", schoolYear="
				+ this.schoolYear + ", students=" + this.students + "]";
	}

}
