/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import fr.min.school.model.Student;

/**
 * This interface defines a student DAO.
 * 
 * @author Wilfried Petit
 * 
 */
public interface StudentDAO extends GenericDAO<Student, Integer> {
	/**
	 * Find a student by its id.
	 * 
	 * @param id
	 *            the id of the student.
	 * @return the student found.
	 */
	Student findStudentById(int id);

	/**
	 * Create a student with the fields filled in the student.
	 * 
	 * @param student
	 *            the student that contains the information about the student.
	 */
	void createStudent(Student student);

	/**
	 * Find the list of the students that have the name given.
	 * 
	 * @param name
	 *            the name of the students to search.
	 * @return the list of students found.
	 */
	List<Student> findStudentsByName(String name);

	/**
	 * Find the list of the students that have the firstname and the name given.
	 * 
	 * @param firstname
	 *            the firstname of the students to search.
	 * @param name
	 *            the name of the students to search.
	 * @return the list of students found.
	 */
	List<Student> findStudentsByFirstnameAndName(String firstname, String name);
}
