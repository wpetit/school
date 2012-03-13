/**
 * 
 */
package fr.min.school.business;

import java.util.List;

import fr.min.school.model.dto.DisciplineDTO;

/**
 * Discipline business.
 * 
 * @author Wilfried Petit
 * 
 */
public interface DisciplineBusiness extends Business {

	/**
	 * Create a new discipline.
	 * 
	 * @param disciplineDTO
	 *            the discipline to create.
	 */
	void createDiscipline(DisciplineDTO disciplineDTO);

	/**
	 * Retrieve all disciplines.
	 * 
	 * @return disciplines found.
	 */
	List<DisciplineDTO> getAllDisciplines();

}
