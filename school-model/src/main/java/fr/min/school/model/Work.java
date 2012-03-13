/**
 * 
 */
package fr.min.school.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class defines a work.
 * 
 * @author Wilfried Petit
 * 
 */
@Entity
public class Work implements Model {
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
	 * Return the work id.
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	/**
	 * Return the work name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the work id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Set the work name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Return the work date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set the work date.
	 * 
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * Return the work discipline.
	 * 
	 * @return the discipline
	 */
	public Discipline getDiscipline() {
		return discipline;
	}

	/**
	 * Set the work discipline.
	 * 
	 * @param discipline
	 *            the discipline to set
	 */
	public void setDiscipline(final Discipline discipline) {
		this.discipline = discipline;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Work [date=" + date + ", id=" + id + ", name=" + name
				+ ", discipline=" + discipline + "]";
	}
}
