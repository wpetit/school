/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import fr.min.school.model.School;
import fr.min.school.model.Student;
import fr.min.school.model.StudentClass;

/**
 * This interface defines a student class DAO.
 * 
 * @author Wilfried Petit
 * 
 */
public interface StudentClassDAO extends GenericDAO<StudentClass, Integer> {

	/**
	 * Add a student to a student class.
	 * 
	 * @param studentClass
	 *            the student class which to add the student
	 * @param student
	 *            the student to add
	 */
	void addStudentToStudentClass(StudentClass studentClass, Student student);

	/**
	 * Create a student class.
	 * 
	 * @param school
	 *            the school which to add the student class
	 * @param studentClass
	 *            the student class to create
	 */
	void createStudentClass(School school, StudentClass studentClass);

	/**
	 * Find all the student class.
	 * 
	 * @return the list of student class found
	 */
	List<StudentClass> findAll();

	/**
	 * Find a student class by its id.
	 * 
	 * @param id
	 *            the id of the class
	 * @return the student class found
	 */
	StudentClass findStudentClassById(int id);

	/**
	 * Find a student class by its name.
	 * 
	 * @param name
	 *            the name of the class
	 * @return the student class found
	 */
	StudentClass findStudentClassByName(String name);

}
