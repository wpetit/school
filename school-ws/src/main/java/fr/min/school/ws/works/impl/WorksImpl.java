package fr.min.school.ws.works.impl;

//import fr.min.school.business.StudentWorkBusiness;
//import fr.min.school.business.WorkBusiness;
//import fr.min.school.model.dto.StudentWorkDTO;
//import fr.min.school.model.dto.WorkDTO;
import fr.min.school.ws.works.Works;
import fr.min.school.ws.works.works.CreateStudentWork;
import fr.min.school.ws.works.works.CreateWork;
import fr.min.school.ws.works.works.CreateWorkResponse;
import fr.min.school.ws.works.works.GetWorkResults;
import fr.min.school.ws.works.works.GetWorkResultsResponse;
import fr.min.school.ws.works.works.StudentWork;
import fr.min.school.ws.works.works.Work;

/**
 * @author Wilfried Petit
 * 
 */
public class WorksImpl implements Works {

	// private WorkBusiness workBusiness;
	// private StudentWorkBusiness studentWorkBusiness;

	/**
	 * @return the workBusiness
	 */
	// public WorkBusiness getWorkBusiness() {
	// return workBusiness;
	// }

	/**
	 * @param workBusiness
	 *            the workBusiness to set
	 */
	// public void setWorkBusiness(final WorkBusiness workBusiness) {
	// this.workBusiness = workBusiness;
	// }

	/**
	 * @return the studentWorkBusiness
	 */
	// public StudentWorkBusiness getStudentWorkBusiness() {
	// return studentWorkBusiness;
	// }

	/**
	 * @param studentWorkBusiness
	 *            the studentWorkBusiness to set
	 */
	// public void setStudentWorkBusiness(
	// final StudentWorkBusiness studentWorkBusiness) {
	// this.studentWorkBusiness = studentWorkBusiness;
	// }

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.ws.works.Works#getWorkResults(fr.min.school.ws.works.works.GetWorkResults)
	 */
	@Override
	public GetWorkResultsResponse getWorkResults(final GetWorkResults parameters) {
		final int workId = parameters.getWorkId();
		final GetWorkResultsResponse response = new GetWorkResultsResponse();
		// response.setAverage(studentWorkBusiness.getStudentWorksAverage(workId));
		// for (final StudentWorkDTO studentWorkDTO : studentWorkBusiness
		// .findStudentWorks(workId)) {
		// final StudentWork studentWork = new StudentWork();
		// studentWork.setAbsent(studentWorkDTO.isAbsent());
		// studentWork.setMark(studentWorkDTO.getMark());
		// studentWork.setStudentId(studentWorkDTO.getId());
		// studentWork.setComment(studentWorkDTO.getComment());
		// response.getStudentWork().add(studentWork);
		// }
		return response;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.ws.works.Works#createStudentWork(fr.min.school.ws.works.works.CreateStudentWork)
	 */
	@Override
	public void createStudentWork(final CreateStudentWork parameters) {
		final StudentWork studentWork = parameters.getStudentWork();
		// final StudentWorkDTO studentWorkDTO = new StudentWorkDTO();
		// // studentWorkDTO.setStudent(studentWork.getStudentId());
		// // studentWorkDTO.setWork(studentWork);
		// studentWorkDTO.setAbsent(studentWork.isAbsent());
		// studentWorkDTO.setComment(studentWork.getComment());
		// final boolean absent = studentWork.isAbsent();
		// if (!absent && studentWork.getMark() != null) {
		// studentWorkDTO.setMark(studentWork.getMark());
		// }
		// studentWorkBusiness.createStudentWork(studentWorkDTO);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.ws.works.Works#createWork(fr.min.school.ws.works.works.CreateWork)
	 */
	@Override
	public CreateWorkResponse createWork(final CreateWork parameters) {
		final Work work = parameters.getWork();
		final CreateWorkResponse cr = new CreateWorkResponse();
		System.err.println(work.getDate().isNil());
		System.err.println(work.getDate().getValue());
		cr.setId(1);
		return cr;
		// final WorkDTO workDTO = new WorkDTO();
		// workDTO.setDate(work.getDate().getValue().getTime());
		// // workDTO.setDisciplineId(work.getDisciplineId());
		// workDTO.setName(work.getName());
		// workBusiness.createWork(workDTO);
	}
}
