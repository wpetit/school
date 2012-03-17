package fr.min.school.dao;

import java.util.List;

import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;
import fr.min.school.model.StudentClass;

/**
 * This interface defines a school DAO.
 * 
 * @author Wilfried Petit
 * 
 */
public interface SchoolDAO extends GenericDAO<School, Integer> {

	/**
	 * Create a school.
	 * 
	 * @param school
	 *            the school to save
	 */
	void createSchool(School school);



	/**
	 * Return classes that depends on this school.
	 * 
	 * @param id
	 *            the school id
	 * @return the classes found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	List<StudentClass> findClassesBySchoolId(int id) throws TechnicalException;

	/**
	 * Return classes that depends on this school.
	 * 
	 * @param schoolName
	 *            the school name
	 * @return the classes found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	List<StudentClass> findClassesBySchoolName(String schoolName)
			throws TechnicalException;

	/**
	 * Return the school found for this id.
	 * 
	 * @param id
	 *            the school id
	 * @return the school found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	School findSchoolById(int id) throws TechnicalException;

	/**
	 * Return the school found for this name.
	 * 
	 * @param schoolName
	 *            the school name
	 * @return the school found
	 * @throws TechnicalException
	 *             if the school does not exist
	 */
	School findSchoolByName(String schoolName) throws TechnicalException;
}
