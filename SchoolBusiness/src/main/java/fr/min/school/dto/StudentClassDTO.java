/**
 * 
 */
package fr.min.school.dto;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.model.SchoolYear;

/**
 * @author minimoi
 * 
 */
public class StudentClassDTO {

	/**
	 * The id of the student class.
	 */
	private Integer id;
	/**
	 * The school year.
	 */
	private SchoolYear schoolYear;
	/**
	 * The list of students that belongs to the class.
	 */
	private List<Integer> students;

	/**
	 * Constructor.
	 */
	public StudentClassDTO() {
		this.students = new ArrayList<Integer>();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the schoolYear
	 */
	public SchoolYear getSchoolYear() {
		return this.schoolYear;
	}

	/**
	 * @return the students
	 */
	public List<Integer> getStudents() {
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
	public void setStudents(final List<Integer> students) {
		this.students = students;
	}
}
