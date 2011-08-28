/**
 * 
 */
package fr.min.school.dao;

import fr.min.school.model.Work;

/**
 * This class mange works.
 * 
 * @author Wilfried Petit
 * 
 */
public interface WorkDAO {

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
