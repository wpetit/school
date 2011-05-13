/**
 * 
 */
package fr.min.school.dto.builder;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.dto.SchoolDTO;
import fr.min.school.model.School;
import fr.min.school.model.StudentClass;

/**
 * @author minimoi
 * 
 */
public final class SchoolDTOBuilder {

	/**
	 * No constructor.
	 */
	private SchoolDTOBuilder() {
	}

	/**
	 * Build a {@link School} from a {@link SchoolDTO}. Student classes are not
	 * set by the builder.
	 * 
	 * @param schoolDTO
	 *            the {@link SchoolDTO} to build from
	 * @return the {@link School} built
	 */
	public static School buildSchool(final SchoolDTO schoolDTO) {
		final School school = new School();
		school.setId(schoolDTO.getId());
		school.setName(schoolDTO.getName());
		school.setAddress(schoolDTO.getAddress());
		return school;
	}

	/**
	 * Build a {@link SchoolDTO} from a {@link School}.
	 * 
	 * @param school
	 *            the school to build from
	 * @return the school dto built
	 */
	public static SchoolDTO buildSchoolDTO(final School school) {
		final SchoolDTO schoolDto = new SchoolDTO();
		schoolDto.setAddress(school.getAddress());
		schoolDto.setId(school.getId());
		schoolDto.setName(school.getName());
		for (final StudentClass studentClass : school.getClasses()) {
			schoolDto.getClasses().add(studentClass.getId());
		}
		return schoolDto;
	}

	/**
	 * Build a {@link List} of {@link SchoolDTO} from a {@link List} of
	 * {@link School}.
	 * 
	 * @param schools
	 *            the schools to build form
	 * @return the list created (empty if schools is null or empty)
	 */
	public static List<SchoolDTO> buildSchoolDTOList(final List<School> schools) {
		final List<SchoolDTO> schoolDtoList = new ArrayList<SchoolDTO>();
		if (schools != null) {
			for (final School school : schools) {
				schoolDtoList.add(SchoolDTOBuilder.buildSchoolDTO(school));
			}
		}
		return schoolDtoList;
	}

	/**
	 * Build a {@link List} of {@link School} from a {@link List} of
	 * {@link SchoolDTO}.
	 * 
	 * @param schoolDTOList
	 *            the {@link List} of {@link SchoolDTO} to build from
	 * @return the {@link List} of {@link School} built
	 */
	public static List<School> buildSchoolList(
			final List<SchoolDTO> schoolDTOList) {
		final List<School> schools = new ArrayList<School>();
		if (schoolDTOList != null) {
			for (final SchoolDTO schoolDTO : schoolDTOList) {
				schools.add(SchoolDTOBuilder.buildSchool(schoolDTO));
			}
		}
		return schools;
	}

}
