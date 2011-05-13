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
 * @author minimoi
 * 
 */
@Entity
public class SchoolYear implements Serializable {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -1292710296082324419L;
	/**
	 * The beginning of the first term.
	 */
	private Date firstTermBegin;
	/**
	 * The end of the the first term.
	 */
	private Date firstTermEnd;
	/**
	 * The id of the year.
	 */
	private Integer id;
	/**
	 * The beginning of the second term.
	 */
	private Date secondTermBegin;
	/**
	 * The end of the the second term.
	 */
	private Date secondTermEnd;
	/**
	 * The beginning of the third term.
	 */
	private Date thirdTermBegin;
	/**
	 * The end of the the first term.
	 */
	private Date thirdTermEnd;

	/**
	 * @return the firstTermBegin
	 */
	public Date getFirstTermBegin() {
		return this.firstTermBegin;
	}

	/**
	 * @return the firstTermEnd
	 */
	public Date getFirstTermEnd() {
		return this.firstTermEnd;
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
	 * @return the secondTermBegin
	 */
	public Date getSecondTermBegin() {
		return this.secondTermBegin;
	}

	/**
	 * @return the secondTermEnd
	 */
	public Date getSecondTermEnd() {
		return this.secondTermEnd;
	}

	/**
	 * @return the thirdTermBegin
	 */
	public Date getThirdTermBegin() {
		return this.thirdTermBegin;
	}

	/**
	 * @return the thirdTermEnd
	 */
	public Date getThirdTermEnd() {
		return this.thirdTermEnd;
	}

	/**
	 * @param firstTermBegin
	 *            the firstTermBegin to set
	 */
	public void setFirstTermBegin(final Date firstTermBegin) {
		this.firstTermBegin = firstTermBegin;
	}

	/**
	 * @param firstTermEnd
	 *            the firstTermEnd to set
	 */
	public void setFirstTermEnd(final Date firstTermEnd) {
		this.firstTermEnd = firstTermEnd;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param secondTermBegin
	 *            the secondTermBegin to set
	 */
	public void setSecondTermBegin(final Date secondTermBegin) {
		this.secondTermBegin = secondTermBegin;
	}

	/**
	 * @param secondTermEnd
	 *            the secondTermEnd to set
	 */
	public void setSecondTermEnd(final Date secondTermEnd) {
		this.secondTermEnd = secondTermEnd;
	}

	/**
	 * @param thirdTermBegin
	 *            the thirdTermBegin to set
	 */
	public void setThirdTermBegin(final Date thirdTermBegin) {
		this.thirdTermBegin = thirdTermBegin;
	}

	/**
	 * @param thirdTermEnd
	 *            the thirdTermEnd to set
	 */
	public void setThirdTermEnd(final Date thirdTermEnd) {
		this.thirdTermEnd = thirdTermEnd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchoolYear [firstTermBegin=" + this.firstTermBegin
				+ ", firstTermEnd=" + this.firstTermEnd + ", id=" + this.id
				+ ", secondTermBegin=" + this.secondTermBegin
				+ ", secondTermEnd=" + this.secondTermEnd + ", thirdTermBegin="
				+ this.thirdTermBegin + ", thirdTermEnd=" + this.thirdTermEnd
				+ "]";
	}
}
