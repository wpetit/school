/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.SchoolDAO;
import fr.min.school.dao.StudentClassDAO;
import fr.min.school.dto.SchoolDTO;
import fr.min.school.dto.StudentClassDTO;
import fr.min.school.dto.StudentDTO;
import fr.min.school.dto.builder.StudentClassDTOBuilder;
import fr.min.school.model.School;
import fr.min.school.model.StudentClass;

/**
 * @author minimoi
 * 
 */
public class StudentClassDAOImpl extends HibernateDaoSupport implements
		StudentClassDAO {

	private SchoolDAO schoolDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.min.school.dao.StudentClassDAO#addStudentToStudentClass(fr.min.school
	 * .dto.StudentClassDTO, fr.min.school.dto.StudentDTO)
	 */
	public void addStudentToStudentClass(final StudentClassDTO studentClassDTO,
			final StudentDTO studentDTO) {
		this.findStudentClassById(studentClassDTO.getId());

	}

	public void createStudentClass(final SchoolDTO schoolDTO,
			final StudentClassDTO studentClassDTO) {
		final School school = this.schoolDAO.findSchoolById(schoolDTO.getId());
		school.getClasses().add(
				StudentClassDTOBuilder.buildStudentClass(studentClassDTO));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<StudentClassDTO> findAll() {
		final Query query = this.getSessionFactory().getCurrentSession()
				.createQuery("from StudentClass");
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.min.school.dao.StudentClassDAO#createStudentClass(fr.min.school.dto
	 * .StudentClassDTO)
	 */
	private StudentClass findStudentClassById(final int id) {
		return (StudentClass) this.getSessionFactory().getCurrentSession()
				.get(StudentClass.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findStudentClassDTOById(int)
	 */
	public StudentClassDTO findStudentClassDTOById(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.min.school.dao.StudentClassDAO#findStudentClassDTOByName(java.lang
	 * .String)
	 */
	public StudentClassDTO findStudentClassDTOByName(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the schoolDAO
	 */
	public SchoolDAO getSchoolDAO() {
		return this.schoolDAO;
	}

	/**
	 * @param schoolDAO
	 *            the schoolDAO to set
	 */
	public void setSchoolDAO(final SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

}
