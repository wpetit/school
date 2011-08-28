/**
 * 
 */
package fr.min.school.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;

import fr.min.school.business.StudentWorkBusiness;
import fr.min.school.dao.StudentDAO;
import fr.min.school.dao.StudentWorkDAO;
import fr.min.school.dao.WorkDAO;
import fr.min.school.model.Student;
import fr.min.school.model.StudentWork;
import fr.min.school.model.Work;
import fr.min.school.model.dto.StudentWorkDTO;

/**
 * @author Wilfried Petit
 * 
 */
public class StudentWorkBusinessImpl implements StudentWorkBusiness {

	private StudentWorkDAO studentWorkDAO;
	private WorkDAO workDAO;
	private StudentDAO studentDAO;
	private Mapper mapper;

	/**
	 * @param studentWorkDAO
	 *            the studentWorkDAO to set
	 */
	public void setStudentWorkDAO(StudentWorkDAO studentWorkDAO) {
		this.studentWorkDAO = studentWorkDAO;
	}

	/**
	 * @param workDAO
	 *            the workDAO to set
	 */
	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
	}

	/**
	 * @param studentDAO
	 *            the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * @param mapper
	 *            the mapper to set
	 */
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.StudentWorkBusiness#findStudentWorks(int)
	 */
	@Override
	public List<StudentWorkDTO> findStudentWorks(int workId) {
		List<StudentWorkDTO> studentWorkDTOList = new ArrayList<StudentWorkDTO>();
		for (StudentWork studentWork : this.studentWorkDAO
				.findStudentWorks(workId)) {
			studentWorkDTOList.add(this.mapper.map(studentWork,
					StudentWorkDTO.class));
		}
		return studentWorkDTOList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.StudentWorkBusiness#getStudentWorksAverage(int)
	 */
	@Override
	public float getStudentWorksAverage(int workId) {
		return this.studentWorkDAO.getStudentWorksAverage(workId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.StudentWorkBusiness#createStudentWork(fr.min.school.dto.StudentWorkDTO)
	 */
	@Override
	public void createStudentWork(StudentWorkDTO studentWorkDTO) {
		StudentWork studentWork = this.mapper.map(studentWorkDTO,
				StudentWork.class);
		Work work = this.workDAO.findWorkById(studentWorkDTO.getWork().getId());
		studentWork.setWork(work);
		Student student = this.studentDAO.findStudentById(studentWorkDTO
				.getStudent().getId());
		studentWork.setStudent(student);
		this.studentWorkDAO.createStudentWork(studentWork);
	}
}
