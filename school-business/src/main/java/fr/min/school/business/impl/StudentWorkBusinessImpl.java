/**
 * 
 */
package fr.min.school.business.impl;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.business.StudentWorkBusiness;
import fr.min.school.dao.StudentDAO;
import fr.min.school.dao.StudentWorkDAO;
import fr.min.school.dao.WorkDAO;
import fr.min.school.model.Student;
import fr.min.school.model.StudentWork;
import fr.min.school.model.Work;
import fr.min.school.model.dto.StudentWorkDTO;

/**
 * This class manage the student work business.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentWorkBusinessImpl extends AbstractBusiness implements
		StudentWorkBusiness {

	private StudentWorkDAO studentWorkDAO;
	private WorkDAO workDAO;
	private StudentDAO studentDAO;

	/**
	 * Set the studentWordDAO use by the business.
	 * 
	 * @param studentWorkDAO
	 *            the studentWorkDAO to set
	 */
	public void setStudentWorkDAO(final StudentWorkDAO studentWorkDAO) {
		this.studentWorkDAO = studentWorkDAO;
	}

	/**
	 * Set the workDAO use by the business.
	 * 
	 * @param workDAO
	 *            the workDAO to set
	 */
	public void setWorkDAO(final WorkDAO workDAO) {
		this.workDAO = workDAO;
	}

	/**
	 * Set the studentDAO use by the business.
	 * 
	 * @param studentDAO
	 *            the studentDAO to set
	 */
	public void setStudentDAO(final StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.StudentWorkBusiness#findStudentWorks(int)
	 */
	@Override
	public List<StudentWorkDTO> findStudentWorks(final int workId) {
		final List<StudentWorkDTO> studentWorkDTOList = new ArrayList<StudentWorkDTO>();
		for (final StudentWork studentWork : studentWorkDAO
				.findStudentWorks(workId)) {
			studentWorkDTOList.add(mapper
					.map(studentWork, StudentWorkDTO.class));
		}
		return studentWorkDTOList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.StudentWorkBusiness#getStudentWorksAverage(int)
	 */
	@Override
	public float getStudentWorksAverage(final int workId) {
		return studentWorkDAO.getStudentWorksAverage(workId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.StudentWorkBusiness#createStudentWork(fr.min.school.dto.StudentWorkDTO)
	 */
	@Override
	public void createStudentWork(final StudentWorkDTO studentWorkDTO) {
		final StudentWork studentWork = mapper.map(studentWorkDTO,
				StudentWork.class);
		final Work work = workDAO
				.findWorkById(studentWorkDTO.getWork().getId());
		studentWork.setWork(work);
		final Student student = studentDAO.findStudentById(studentWorkDTO
				.getStudent().getId());
		studentWork.setStudent(student);
		studentWorkDAO.createStudentWork(studentWork);
	}
}
