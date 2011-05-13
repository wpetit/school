/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import fr.min.school.dto.SchoolDTO;
import fr.min.school.dto.StudentClassDTO;
import fr.min.school.dto.StudentDTO;

/**
 * @author minimoi
 * 
 */
public interface StudentClassDAO {

	/**
	 * Add a student to a student class.
	 * 
	 * @param studentClassDTO
	 *            the student class which to add the student
	 * @param studentDTO
	 *            the student to add
	 */
	void addStudentToStudentClass(StudentClassDTO studentClassDTO,
			StudentDTO studentDTO);

	/**
	 * Create a student class.
	 * 
	 * @param schoolDTO
	 *            the school which to add the student class
	 * @param studentClassDTO
	 *            the student class to create
	 */
	void createStudentClass(SchoolDTO schoolDTO, StudentClassDTO studentClassDTO);

	/**
	 * Find all the student class.
	 * 
	 * @return the list of student class found
	 */
	List<StudentClassDTO> findAll();

	/**
	 * Find a student class by its id.
	 * 
	 * @param id
	 *            the id of the class
	 * @return the student class found
	 */
	StudentClassDTO findStudentClassDTOById(int id);

	/**
	 * Find a student class by its name.
	 * 
	 * @param name
	 *            the name of the class
	 * @return the student class found
	 */
	StudentClassDTO findStudentClassDTOByName(String name);

}
