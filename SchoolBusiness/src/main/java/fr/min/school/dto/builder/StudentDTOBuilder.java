/**
 * 
 */
package fr.min.school.dto.builder;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.dto.StudentDTO;
import fr.min.school.model.Student;
import fr.min.school.model.Work;

/**
 * @author minimoi
 * 
 */
public final class StudentDTOBuilder {

	/**
	 * No constructor.
	 */
	private StudentDTOBuilder() {

	}

	/**
	 * Build a {@link Student} from a {@link StudentDTO}.
	 * 
	 * @param studentDTO
	 *            the {@link StudentDTO} to build from
	 * @return the {@link Student} built.
	 */
	public static Student buildStudent(final StudentDTO studentDTO) {
		final Student student = new Student();
		student.setId(studentDTO.getId());
		student.setBirthday(studentDTO.getBirthday());
		student.setFirstname(studentDTO.getFirstname());
		student.setName(studentDTO.getName());
		return student;
	}

	/**
	 * Build a {@link StudentDTO} from a {@link Student}.
	 * 
	 * @param student
	 *            the {@link Student} to build from
	 * @return the {@link StudentDTO} built
	 */
	public static StudentDTO buildStudentDTO(final Student student) {
		final StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setBirthday(student.getBirthday());
		studentDTO.setFirstname(student.getFirstname());
		studentDTO.setName(student.getName());
		if (student.getWorks() != null) {
			for (final Work works : student.getWorks()) {
				studentDTO.getWorks().add(works.getId());
			}
		}
		return studentDTO;
	}

	/**
	 * Build a {@link List} of {@link StudentDTO} from a {@link List} of
	 * {@link Student}.
	 * 
	 * @param students
	 *            the {@link List} of {@link Student} to build from
	 * @return the {@link List} of {@link StudentDTO} built
	 */
	public static List<StudentDTO> buildStudentDTOList(
			final List<Student> students) {
		final List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
		if (students != null) {
			for (final Student student : students) {
				studentDTOList.add(StudentDTOBuilder.buildStudentDTO(student));
			}
		}
		return studentDTOList;
	}

	/**
	 * Build a {@link List} of {@link Student} from a {@link List} of
	 * {@link StudentDTO}.
	 * 
	 * @param studentDTOList
	 *            the {@link List} of {@link StudentDTO} to build from
	 * @return the {@link List} of {@link Student} built
	 */
	public static List<Student> buildStudentList(
			final List<StudentDTO> studentDTOList) {
		final List<Student> students = new ArrayList<Student>();
		if (studentDTOList != null) {
			for (final StudentDTO studentDTO : studentDTOList) {
				students.add(StudentDTOBuilder.buildStudent(studentDTO));
			}
		}
		return students;
	}
}
