/**
 * 
 */
package fr.min.school.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author minimoi
 * 
 */
@Entity
public class School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2485483630021031653L;
	private String address;
	private List<StudentClass> classes;
	private Integer id;
	private String name;

	public School() {
		this.classes = new ArrayList<StudentClass>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final School other = (School) obj;
		if (this.address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!this.address.equals(other.address)) {
			return false;
		}
		if (this.classes == null) {
			if (other.classes != null) {
				return false;
			}
		} else if (!this.classes.equals(other.classes)) {
			return false;
		}
		if (this.id != other.id) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @return the classes
	 */
	@OneToMany(fetch = FetchType.EAGER)
	public List<StudentClass> getClasses() {
		return this.classes;
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
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final Integer prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.address == null) ? 0 : this.address.hashCode());
		result = prime * result
				+ ((this.classes == null) ? 0 : this.classes.hashCode());
		result = prime * result + this.id;
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * @param classes
	 *            the classes to set
	 */
	public void setClasses(final List<StudentClass> classes) {
		this.classes = classes;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [address=" + this.address + ", classes=" + this.classes
				+ ", id=" + this.id + ", name=" + this.name + "]";
	}

}
