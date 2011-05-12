/**
 * 
 */
package fr.min.school.dto.builder;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.dto.StudentClassDTO;
import fr.min.school.model.Student;
import fr.min.school.model.StudentClass;

/**
 * @author minimoi
 * 
 */
public class StudentClassDTOBuilder {

	/**
	 * Build a {@link StudentClass} from a {@link StudentClassDTO}. SchoolYear
	 * and Student are not set by the builder
	 * 
	 * @param studentClassDTO
	 *            the {@link StudentClassDTO} to build from
	 * @return the {@link StudentClass} built.
	 */
	public static StudentClass buildStudentClass(
			final StudentClassDTO studentClassDTO) {
		final StudentClass studentClass = new StudentClass();
		studentClass.setId(studentClassDTO.getId());
		studentClass.setSchoolYear(studentClassDTO.getSchoolYear());
		return studentClass;
	}

	/**
	 * Build a {@link StudentClassDTO} from a {@link StudentClass}.
	 * 
	 * @param studentClass
	 *            the {@link StudentClass} to build from
	 * @return the {@link StudentClassDTO} built
	 */
	public static StudentClassDTO buildStudentClassDTO(
			final StudentClass studentClass) {
		final StudentClassDTO studentClassDTO = new StudentClassDTO();
		studentClassDTO.setId(studentClass.getId());
		studentClassDTO.setSchoolYear(studentClass.getSchoolYear());
		for (final Student student : studentClass.getStudents()) {
			studentClassDTO.getStudents().add(student.getId());
		}
		return studentClassDTO;
	}

	/**
	 * Build a {@link List} of {@link StudentClassDTO} from a {@link List} of
	 * {@link StudentClass}.
	 * 
	 * @param studentClasses
	 *            the {@link List} of {@link StudentClass} to build from
	 * @return the {@link List} of {@link StudentClassDTO} built
	 */
	public static List<StudentClassDTO> buildStudentClassDTOList(
			final List<StudentClass> studentClasses) {
		final List<StudentClassDTO> studentClassDTOList = new ArrayList<StudentClassDTO>();
		if (studentClasses != null) {
			for (final StudentClass studentClass : studentClasses) {
				studentClassDTOList.add(StudentClassDTOBuilder
						.buildStudentClassDTO(studentClass));
			}
		}
		return studentClassDTOList;
	}

}
