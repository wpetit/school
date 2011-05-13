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

	/**
	 * The schoolDao to manage schools.
	 */
	private SchoolDAO schoolDAO;

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#addStudentToStudentClass(fr.min.school.dto.StudentClassDTO,
	 *      fr.min.school.dto.StudentDTO)
	 */
	@Override
	public void addStudentToStudentClass(final StudentClassDTO studentClassDTO,
			final StudentDTO studentDTO) {
		this.findStudentClassById(studentClassDTO.getId());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#createStudentClass(fr.min.school.dto.SchoolDTO,
	 *      fr.min.school.dto.StudentClassDTO)
	 */
	@Override
	public void createStudentClass(final SchoolDTO schoolDTO,
			final StudentClassDTO studentClassDTO) {
		final School school = this.schoolDAO.findSchoolById(schoolDTO.getId());
		school.getClasses().add(
				StudentClassDTOBuilder.buildStudentClass(studentClassDTO));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<StudentClassDTO> findAll() {
		final Query query = this.getSessionFactory().getCurrentSession()
				.createQuery("from StudentClass");
		return query.list();
	}

	private StudentClass findStudentClassById(final int id) {
		return (StudentClass) this.getSessionFactory().getCurrentSession()
				.get(StudentClass.class, id);
	}

	@Override
	public StudentClassDTO findStudentClassDTOById(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findStudentClassDTOByName(java.lang.String)
	 */
	@Override
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
