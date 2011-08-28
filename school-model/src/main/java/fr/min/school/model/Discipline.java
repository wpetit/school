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
 * Discipline class as Maths or English.
 * 
 * @author Wilfried Petit
 * 
 */
@Entity
public class Discipline implements Serializable {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -5913207097601847788L;

	/**
	 * The id of the discipline.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * The name of the discipline.
	 */
	private String name;

	/**
	 * The ration of the discipline.
	 */
	private int ratio;

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the ratio
	 */
	public int getRatio() {
		return this.ratio;
	}

	/**
	 * @param ratio
	 *            the ratio to set
	 */
	public void setRatio(final int ratio) {
		this.ratio = ratio;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Discipline [id=" + this.id + ", name=" + this.name + ", ratio="
				+ this.ratio + "]";
	}
}