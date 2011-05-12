/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
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
	 * Serial ID
	 */
	private static final long serialVersionUID = 5211284344394885393L;
	private String comment;

	private boolean done;
	private Integer id;
	private float mark;
	private String name;
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
	 * @return the done
	 */
	public boolean isDone() {
		return this.done;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * @param done
	 *            the done to set
	 */
	public void setDone(final boolean done) {
		this.done = done;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Work [comment=" + this.comment + ", done=" + this.done
				+ ", id=" + this.id + ", mark=" + this.mark + ", name="
				+ this.name + ", students=" + this.students + "]";
	}
}
