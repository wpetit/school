/**
 * 
 */
package fr.min.school.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author minimoi
 * 
 */
public class WorkDTO {
	/**
	 * The comment the teacher has given to the student.
	 */
	private String comment;
	/**
	 * The id of the workDTO.
	 */
	private int id;
	/**
	 * The date of the work.
	 */
	private Date date;
	/**
	 * The mark the student got.
	 */
	private float mark;
	/**
	 * The name of the work.
	 */
	private String name;

	/**
	 * The list of students that have done the work.
	 */
	private List<Integer> students;

	/**
	 * Constructor.
	 */
	public WorkDTO() {
		this.students = new ArrayList<Integer>();
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the mark
	 */
	public float getMark() {
		return this.mark;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the students
	 */
	public List<Integer> getStudents() {
		return this.students;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @param mark
	 *            the mark to set
	 */
	public void setMark(final float mark) {
		this.mark = mark;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param students
	 *            the students to set
	 */
	public void setStudents(final List<Integer> students) {
		this.students = students;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}
}
