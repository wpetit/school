/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wilfried Petit
 * 
 */
@Entity
public class Work implements Serializable {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 5211284344394885393L;

	/**
	 * The date of the work.
	 */
	private Date date;
	/**
	 * The id of the work.
	 */
	private Integer id;
	/**
	 * The name of the work.
	 */
	private String name;

	/**
	 * The discipline evaluated.
	 */
	private Discipline discipline;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
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
	 * @return the discipline
	 */
	public Discipline getDiscipline() {
		return this.discipline;
	}

	/**
	 * @param discipline
	 *            the discipline to set
	 */
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Work [date=" + this.date + ", id=" + this.id + ", name="
				+ this.name + ", discipline=" + this.discipline + "]";
	}
}
