/**
 * 
 */
package fr.min.school.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * This class represents a class for a school year given.
 * 
 * @author Wilfried Petit
 * 
 */
@Entity
public class StudentClass implements Model {
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
	 * Return the student class id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	/**
	 * Return the school year the student class belongs to.
	 * 
	 * @return the schoolYear
	 */
	@ManyToOne
	public SchoolYear getSchoolYear() {
		return schoolYear;
	}

	/**
	 * Return the students that belongs to the student class.
	 * 
	 * @return the students
	 */
	@OneToMany
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Set the student class id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Set the school year the student class belongs to.
	 * 
	 * @param schoolYear
	 *            the schoolYear to set
	 */
	public void setSchoolYear(final SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}

	/**
	 * Set the students that belong to the student class.
	 * 
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
		return "StudentClass [id=" + id + ", schoolYear=" + schoolYear
				+ ", students=" + students + "]";
	}

}
