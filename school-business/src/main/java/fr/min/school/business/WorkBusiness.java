/**
 * 
 */
package fr.min.school.business;

import fr.min.school.model.dto.WorkDTO;

/**
 * The interface offers method to manage works.
 * 
 * @author Wilfried Petit
 * 
 */
public interface WorkBusiness {

	/**
	 * Search a work by its id.
	 * 
	 * @param id
	 *            the id of the work.
	 * @return the work found
	 */
	WorkDTO findWorkById(int id);

	/**
	 * Create a work from the workDTO given.
	 * 
	 * @param work
	 *            the workDTO to create the work from.
	 */
	void createWork(WorkDTO work);
}
