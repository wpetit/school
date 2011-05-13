/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
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
public class Work implements Serializable {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 5211284344394885393L;

	/**
	 * The comment given by the teacher.
	 */
	private String comment;
	/**
	 * The date of the work.
	 */
	private Date date;
	/**
	 * The id of the work.
	 */
	private Integer id;
	/**
	 * The mark the student got for this work.
	 */
	private float mark;
	/**
	 * The name of the work.
	 */
	private String name;
	/**
	 * The students that have done the work.
	 */
	private List<Student> students;

	/**
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
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
	@ManyToMany()
	public List<Student> getStudents() {
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
	public void setId(final Integer id) {
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
	public void setStudents(final List<Student> students) {
		this.students = students;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Work [comment=" + this.comment + ", date=" + this.date
				+ ", id=" + this.id + ", mark=" + this.mark + ", name="
				+ this.name + ", students=" + this.students + "]";
	}
}
