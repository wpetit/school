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
	 * Serial ID.
	 */
	private static final long serialVersionUID = 6156343491842539547L;
	/**
	 * The id of the student class.
	 */
	private Integer id;
	/**
	 * The school year of the class.
	 */
	private SchoolYear schoolYear;
	/**
	 * The students that belongs to the class.
	 */
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

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentClass [id=" + this.id + ", schoolYear="
				+ this.schoolYear + ", students=" + this.students + "]";
	}

}
