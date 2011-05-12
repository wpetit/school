/**
 * 
 */
package fr.min.school.dto.builder;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.dto.WorkDTO;
import fr.min.school.model.Student;
import fr.min.school.model.Work;

/**
 * @author minimoi
 * 
 */
public class WorkDTOBuilder {

	/**
	 * Build a {@link Work} from a {@link WorkDTO}. Students are not set by the
	 * builder.
	 * 
	 * @param workDTO
	 *            the {@link WorkDTO} to build from
	 * @return the {@link Work} built
	 */
	public static Work buildWork(final WorkDTO workDTO) {
		final Work work = new Work();
		work.setComment(workDTO.getComment());
		work.setDone(workDTO.isDone());
		work.setId(workDTO.getId());
		work.setMark(workDTO.getMark());
		work.setName(workDTO.getName());
		return work;
	}

	/**
	 * Build a {@link WorkDTO} form a {@link Work}.
	 * 
	 * @param work
	 *            the work to build from
	 * @return the {@link WorkDTO} built
	 */
	public static WorkDTO buildWorkDTO(final Work work) {
		final WorkDTO workDTO = new WorkDTO();
		workDTO.setId(work.getId());
		workDTO.setDone(work.isDone());
		workDTO.setComment(work.getComment());
		workDTO.setMark(work.getMark());
		if (work.getStudents() != null) {
			for (final Student student : work.getStudents()) {
				workDTO.getStudents().add(student.getId());
			}
		}
		return workDTO;
	}

	/**
	 * Build a {@link List} of {@link WorkDTO} from a {@link List} of
	 * {@link Work}
	 * 
	 * @param works
	 *            the {@link List} of {@link Work} to build from
	 * @return the {@link List} of {@link WorkDTO} built
	 */
	public static List<WorkDTO> buildWorkDTOList(final List<Work> works) {
		final List<WorkDTO> workDTOList = new ArrayList<WorkDTO>();
		if (works != null) {
			for (final Work work : works) {
				workDTOList.add(WorkDTOBuilder.buildWorkDTO(work));
			}
		}
		return workDTOList;
	}

	/**
	 * Build a {@link List} of {@link Work} from a {@link List} of
	 * {@link WorkDTO} Students are not set by the builder.
	 * 
	 * @param workDTOList
	 *            the {@link List} of {@link WorkDTO} to build from
	 * @return the {@link List} of {@link Work} built
	 */
	public static List<Work> buildWorkList(final List<WorkDTO> workDTOList) {
		final List<Work> works = new ArrayList<Work>();
		if (workDTOList != null) {
			for (final WorkDTO workDTO : workDTOList) {
				works.add(WorkDTOBuilder.buildWork(workDTO));
			}
		}
		return works;
	}

}
