package fr.min.school.ws.works.impl;

import fr.min.school.business.StudentWorkBusiness;
import fr.min.school.business.WorkBusiness;
import fr.min.school.dto.StudentWorkDTO;
import fr.min.school.dto.WorkDTO;
import fr.min.school.ws.works.Works;
import fr.min.school.ws.works.works.CreateStudentWork;
import fr.min.school.ws.works.works.CreateWork;
import fr.min.school.ws.works.works.GetWorkResults;
import fr.min.school.ws.works.works.GetWorkResultsResponse;
import fr.min.school.ws.works.works.StudentWork;
import fr.min.school.ws.works.works.Work;

/**
 * @author Wilfried Petit
 * 
 */
public class WorksImpl implements Works {

	private WorkBusiness workBusiness;
	private StudentWorkBusiness studentWorkBusiness;

	/**
	 * @return the workBusiness
	 */
	public WorkBusiness getWorkBusiness() {
		return this.workBusiness;
	}

	/**
	 * @param workBusiness
	 *            the workBusiness to set
	 */
	public void setWorkBusiness(WorkBusiness workBusiness) {
		this.workBusiness = workBusiness;
	}

	/**
	 * @return the studentWorkBusiness
	 */
	public StudentWorkBusiness getStudentWorkBusiness() {
		return this.studentWorkBusiness;
	}

	/**
	 * @param studentWorkBusiness
	 *            the studentWorkBusiness to set
	 */
	public void setStudentWorkBusiness(StudentWorkBusiness studentWorkBusiness) {
		this.studentWorkBusiness = studentWorkBusiness;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.ws.works.Works#getWorkResults(fr.min.school.ws.works.works.GetWorkResults)
	 */
	@Override
	public GetWorkResultsResponse getWorkResults(GetWorkResults parameters) {
		int workId = parameters.getWorkId();
		GetWorkResultsResponse response = new GetWorkResultsResponse();
		response.setAverage(this.studentWorkBusiness
				.getStudentWorksAverage(workId));
		for (StudentWorkDTO studentWorkDTO : this.studentWorkBusiness
				.findStudentWorks(workId)) {
			StudentWork studentWork = new StudentWork();
			studentWork.setAbsent(studentWorkDTO.isAbsent());
			studentWork.setMark(studentWorkDTO.getMark());
			studentWork.setStudentId(studentWorkDTO.getId());
			studentWork.setComment(studentWorkDTO.getComment());
			response.getStudentWork().add(studentWork);
		}
		return response;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.ws.works.Works#createStudentWork(fr.min.school.ws.works.works.CreateStudentWork)
	 */
	@Override
	public void createStudentWork(CreateStudentWork parameters) {
		StudentWork studentWork = parameters.getStudentWork();
		StudentWorkDTO studentWorkDTO = new StudentWorkDTO();
		studentWorkDTO.setStudentId(studentWork.getStudentId());
		studentWorkDTO.setWorkId(studentWork.getWorkId());
		studentWorkDTO.setAbsent(studentWork.isAbsent());
		studentWorkDTO.setComment(studentWork.getComment());
		boolean absent = studentWork.isAbsent();
		if (!absent && studentWork.getMark() != null) {
			studentWorkDTO.setMark(studentWork.getMark());
		}
		this.studentWorkBusiness.createStudentWork(studentWorkDTO);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.ws.works.Works#createWork(fr.min.school.ws.works.works.CreateWork)
	 */
	@Override
	public void createWork(CreateWork parameters) {
		Work work = parameters.getWork();
		WorkDTO workDTO = new WorkDTO();
		workDTO.setDate(work.getDate().toGregorianCalendar().getTime());
		workDTO.setDisciplineId(work.getDisciplineId());
		workDTO.setName(work.getName());
		this.workBusiness.createWork(workDTO);
	}
}
