/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.SchoolDAO;
import fr.min.school.dto.SchoolDTO;
import fr.min.school.dto.StudentClassDTO;
import fr.min.school.dto.builder.SchoolDTOBuilder;
import fr.min.school.dto.builder.StudentClassDTOBuilder;
import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;

/**
 * @author minimoi
 * 
 */
public class SchoolDAOImpl extends HibernateDaoSupport implements SchoolDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.min.school.dao.SchoolDAO#saveOrUpdateSchool(fr.min.school.model.School
	 * )
	 */
	public void createSchool(final SchoolDTO school) {
		this.getSessionFactory().getCurrentSession()
				.save(SchoolDTOBuilder.buildSchool(school));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<SchoolDTO> findAll() throws TechnicalException {
		final List<School> schools = this.getSessionFactory()
				.getCurrentSession().createQuery("from School").list();
		if (schools == null) {
			throw new TechnicalException("No school found");
		}
		return SchoolDTOBuilder.buildSchoolDTOList(schools);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findClassesById(int)
	 */
	public List<StudentClassDTO> findClassesBySchoolId(final int id)
			throws TechnicalException {
		final School school = (School) this.getSessionFactory()
				.getCurrentSession().get(School.class, id);
		if (school == null) {
			throw new TechnicalException("No school found for id : " + id);
		}
		return StudentClassDTOBuilder.buildStudentClassDTOList(school
				.getClasses());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findClassesByName(java.lang.String)
	 */
	public List<StudentClassDTO> findClassesBySchoolName(final String schoolName)
			throws TechnicalException {
		final School school = (School) this.getSessionFactory()
				.getCurrentSession().get(School.class, schoolName);
		if (school == null) {
			throw new TechnicalException("No school found for name : "
					+ schoolName);
		}
		return StudentClassDTOBuilder.buildStudentClassDTOList(school
				.getClasses());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolById(int)
	 */
	public School findSchoolById(final int id) {
		return (School) this.getSessionFactory().getCurrentSession()
				.get(School.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolById(int)
	 */
	public SchoolDTO findSchoolDTOById(final int id) throws TechnicalException {
		final School school = (School) this.getSessionFactory()
				.getCurrentSession().get(School.class, id);
		if (school == null) {
			throw new TechnicalException("No school found for id : " + id);
		}
		return SchoolDTOBuilder.buildSchoolDTO(school);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOByName(java.lang.String)
	 */
	public SchoolDTO findSchoolDTOByName(final String schoolName)
			throws TechnicalException {
		final School school = (School) this.getSessionFactory()
				.getCurrentSession().get(School.class, schoolName);
		if (school == null) {
			throw new TechnicalException("No school found for name : "
					+ schoolName);
		}
		return SchoolDTOBuilder.buildSchoolDTO(school);
	}

}
