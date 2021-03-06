/**
 * 
 */
package fr.min.school.dao;

import fr.min.school.model.Work;

/**
 * This interface defines a work DAO.
 * 
 * @author Wilfried Petit
 * 
 */
public interface WorkDAO extends GenericDAO<Work, Integer> {

	/**
	 * Return the work found for the id given.
	 * 
	 * @param id
	 *            the id of the work to search.
	 * @return the work found.
	 */
	Work findWorkById(int id);

	/**
	 * Create a work.
	 * 
	 * @param work
	 *            the work to create.
	 */
	void createWork(Work work);
}
