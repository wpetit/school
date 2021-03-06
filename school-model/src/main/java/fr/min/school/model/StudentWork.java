/**
 * 
 */
package fr.min.school.model;

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
public class StudentWork implements Model {
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
		return work;
	}

	/**
	 * Set the work the student has done.
	 * 
	 * @param work
	 *            the work to set
	 */
	public void setWork(final Work work) {
		this.work = work;
	}

	/**
	 * Return the student that has done the work.
	 * 
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Set the student that has done the work.
	 * 
	 * @param student
	 *            the student to set
	 */
	public void setStudent(final Student student) {
		this.student = student;
	}

	/**
	 * Return the mark got by the student for the work.
	 * 
	 * @return the mark
	 */
	public float getMark() {
		return mark;
	}

	/**
	 * Set the mark got by the student for the work.
	 * 
	 * @param mark
	 *            the mark to set
	 */
	public void setMark(final float mark) {
		this.mark = mark;
	}

	/**
	 * Return <true> if the student was absent for the work.
	 * 
	 * @return the absent
	 */
	public boolean isAbsent() {
		return absent;
	}

	/**
	 * Set the presence of the student for the work.
	 * 
	 * @param absent
	 *            the absent to set
	 */
	public void setAbsent(final boolean absent) {
		this.absent = absent;
	}

	/**
	 * Set the student work id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Return the student work id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the comment the teacher gave to the student work.
	 * 
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * Return the comment the teacher gave to the student work.
	 * 
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StudentWork [id=" + id + ", work=" + work + ", student="
				+ student + ", mark=" + mark + ", absent=" + absent
				+ ", comment=" + comment + "]";
	}
}
