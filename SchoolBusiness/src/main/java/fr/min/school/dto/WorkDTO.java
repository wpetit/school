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
public class WorkDTO {
	private String comment;
	private int id;
	private boolean isDone;
	private float mark;

	private String name;

	private List<Integer> students;

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
	 * @return the isDone
	 */
	public boolean isDone() {
		return this.isDone;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * @param isDone
	 *            the isDone to set
	 */
	public void setDone(final boolean isDone) {
		this.isDone = isDone;
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
}
