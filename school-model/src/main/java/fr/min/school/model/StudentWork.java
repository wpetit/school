/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Association between a work and a student.
 * 
 * @author Wilfried Petit
 * 
 */
@Entity
public class StudentWork implements Serializable {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 7945694111019138263L;

	/**
	 * The id of the student work association.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * The work the student has done.
	 */
	private Work work;
	/**
	 * The student that has done the work.
	 */
	private Student student;
	/**
	 * The mark the stugent got.
	 */
	private float mark;
	/**
	 * If the student was absent or not.
	 */
	private boolean absent;

	/**
	 * The comment given by the teacher.
	 */
	private String comment;

	/**
	 * @return the work
	 */
	public Work getWork() {
		return this.work;
	}

	/**
	 * @param work
	 *            the work to set
	 */
	public void setWork(final Work work) {
		this.work = work;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return this.student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(final Student student) {
		this.student = student;
	}

	/**
	 * @return the mark
	 */
	public float getMark() {
		return this.mark;
	}

	/**
	 * @param mark
	 *            the mark to set
	 */
	public void setMark(final float mark) {
		this.mark = mark;
	}

	/**
	 * @return the absent
	 */
	public boolean isAbsent() {
		return this.absent;
	}

	/**
	 * @param absent
	 *            the absent to set
	 */
	public void setAbsent(final boolean absent) {
		this.absent = absent;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentWork [id=" + this.id + ", work=" + this.work
				+ ", student=" + this.student + ", mark=" + this.mark
				+ ", absent=" + this.absent + ", comment=" + this.comment + "]";
	}
}
