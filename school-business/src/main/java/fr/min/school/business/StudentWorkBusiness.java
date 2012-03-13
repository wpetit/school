/**
 * 
 */
package fr.min.school.business;

import java.util.List;

import fr.min.school.model.dto.StudentWorkDTO;

/**
 * @author Wilfried Petit
 * 
 */
public interface StudentWorkBusiness extends Business {

	/**
	 * Find the list of the student works for the work given.
	 * 
	 * @param workId
	 *            the id of the work to link student works.
	 * @return the list of the student works found.
	 */
	List<StudentWorkDTO> findStudentWorks(int workId);

	/**
	 * Calculate the average of the student works for the work given. The mark
	 * is taken in account only if the student was present.
	 * 
	 * @param workId
	 *            the id of the work to look for.
	 * @return the average of the student works.
	 * 
	 */
	float getStudentWorksAverage(int workId);

	/**
	 * Create a student work from a studentWorkDTO.
	 * 
	 * @param studentWork
	 *            the studentWorkDTO to build the studentWork from.
	 */
	void createStudentWork(StudentWorkDTO studentWork);
}
