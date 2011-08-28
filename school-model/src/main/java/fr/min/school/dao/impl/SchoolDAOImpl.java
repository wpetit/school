/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.SchoolDAO;
import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;
import fr.min.school.model.StudentClass;

/**
 * @author Wilfried Petit
 * 
 */
public class SchoolDAOImpl extends HibernateDaoSupport implements SchoolDAO {

	@Override
	public void createSchool(final School school) {
		getSessionFactory().getCurrentSession().save(school);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<School> findAll() throws TechnicalException {
		final List<School> schools = getSessionFactory().getCurrentSession()
				.createQuery("from School").list();
		if (schools == null) {
			throw new TechnicalException("No school found");
		}
		return schools;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findClassesBySchoolId(int)
	 */
	@Override
	public List<StudentClass> findClassesBySchoolId(final int id)
			throws TechnicalException {
		final School school = (School) getSessionFactory().getCurrentSession()
				.get(School.class, id);
		if (school == null) {
			throw new TechnicalException("No school found for id : " + id);
		}
		return school.getClasses();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findClassesBySchoolName(java.lang.String)
	 */
	@Override
	public List<StudentClass> findClassesBySchoolName(final String schoolName)
			throws TechnicalException {
		final School school = (School) getSessionFactory().getCurrentSession()
				.get(School.class, schoolName);
		if (school == null) {
			throw new TechnicalException("No school found for name : "
					+ schoolName);
		}
		return school.getClasses();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOById(int)
	 */
	@Override
	public School findSchoolById(final int id) throws TechnicalException {
		final School school = (School) getSessionFactory().getCurrentSession()
				.get(School.class, id);
		if (school == null) {
			throw new TechnicalException("No school found for id : " + id);
		}
		return school;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOByName(java.lang.String)
	 */
	@Override
	public School findSchoolByName(final String schoolName)
			throws TechnicalException {
		final School school = (School) getSessionFactory().getCurrentSession()
				.get(School.class, schoolName);
		if (school == null) {
			throw new TechnicalException("No school found for name : "
					+ schoolName);
		}
		return school;
	}

}
