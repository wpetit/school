/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.SchoolDAO;
import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;
import fr.min.school.model.StudentClass;

/**
 * @author Wilfried Petit
 * 
 */
public class SchoolDAOImpl extends JpaDaoSupport implements SchoolDAO {

	@Override
	public void createSchool(final School school) {
		getJpaTemplate().persist(school);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<School> findAll() throws TechnicalException {
		final List<School> schools = getJpaTemplate().find(
				"select s from School s");
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
		final School school = getJpaTemplate().find(School.class, id);
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
		final School school = (School) getJpaTemplate().find(
				"select s from School s where s.name=?1", schoolName).get(0);
		return school.getClasses();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOById(int)
	 */
	@Override
	public School findSchoolById(final int id) throws TechnicalException {
		return getJpaTemplate().find(School.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOByName(java.lang.String)
	 */
	@Override
	public School findSchoolByName(final String schoolName)
			throws TechnicalException {
		return (School) getJpaTemplate().find(
				"select s from School s where s.name=?1", schoolName);
	}

}
