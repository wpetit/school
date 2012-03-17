/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import fr.min.school.model.Discipline;

/**
 * This interface defines a discipline DAO.
 * 
 * @author Wilfried Petit
 * 
 */
public interface DisciplineDAO extends GenericDAO<Discipline, Integer> {

	/**
	 * Returns all disciplines.
	 * 
	 * @return the discipline list retrieved.
	 */
	List<Discipline> getAllDisciplines();

	/**
	 * Create a new discipline.
	 * 
	 * @param discipline
	 *            the discipline to create.
	 */
	void createDiscipline(Discipline discipline);

	/**
	 * Retrieve the discipline ratio for the discipline that have the id given.
	 * 
	 * @param id
	 *            the discipline id we want the ratio.
	 * @return the ratio retrieved.
	 */
	float getDisciplineRatio(int id);

}
