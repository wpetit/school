package fr.min.school.dao;

import java.util.List;

import fr.min.school.dto.SchoolDTO;
import fr.min.school.dto.StudentClassDTO;
import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;

/**
 * @author minimoi
 * 
 */
public interface SchoolDAO {

	/**
	 * Create a school.
	 * 
	 * @param school
	 *            the school to save
	 */
	void createSchool(SchoolDTO school);

	/**
	 * Retreive all the school.
	 * 
	 * @return the schools found
	 * @throws TechnicalException
	 *             if no school was found
	 */
	List<SchoolDTO> findAll() throws TechnicalException;

	/**
	 * Return classes that depends on this school.
	 * 
	 * @param id
	 *            the school id
	 * @return the classes found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	List<StudentClassDTO> findClassesBySchoolId(int id)
			throws TechnicalException;

	/**
	 * Return classes that depends on this school.
	 * 
	 * @param schoolName
	 *            the school name
	 * @return the classes found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	List<StudentClassDTO> findClassesBySchoolName(String schoolName)
			throws TechnicalException;

	/**
	 * Return the school found for this id.
	 * 
	 * @param id
	 *            the school id
	 * @return the school found
	 */
	School findSchoolById(final int id);

	/**
	 * Return the school found for this id.
	 * 
	 * @param id
	 *            the school id
	 * @return the school found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	SchoolDTO findSchoolDTOById(int id) throws TechnicalException;

	/**
	 * Return the school found for this name.
	 * 
	 * @param schoolName
	 *            the school name
	 * @return the school found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	SchoolDTO findSchoolDTOByName(String schoolName) throws TechnicalException;
}
