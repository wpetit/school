/**
 * 
 */
package fr.min.school.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstract class that defines a DAO implementation.
 * 
 * @author Wilfried Petit
 * 
 */
public abstract class DAOImpl {

	/**
	 * Entity Manager.
	 */
	@PersistenceContext(name="SchoolPersistenceUnit")
	protected EntityManager entityManager;
}
