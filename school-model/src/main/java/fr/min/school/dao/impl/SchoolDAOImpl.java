/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import fr.min.school.dao.SchoolDAO;
import fr.min.school.exception.TechnicalException;
import fr.min.school.model.School;
import fr.min.school.model.StudentClass;

/**
 * DAO implementation for schools.
 * 
 * @author Wilfried Petit
 * 
 */
public class SchoolDAOImpl extends GenericDAOImpl<School, Integer> implements SchoolDAO {

	@Override
	public void createSchool(final School school) {
		entityManager.persist(school);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findClassesBySchoolId(int)
	 */
	@Override
	public List<StudentClass> findClassesBySchoolId(final int id)
			throws TechnicalException {
		final School school = entityManager.find(School.class, id);
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
		final School school = (School) entityManager
				.createQuery("select s from School s where s.name=:name")
				.setParameter("name", schoolName).getSingleResult();
		return school.getClasses();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOById(int)
	 */
	@Override
	public School findSchoolById(final int id) throws TechnicalException {
		return entityManager.find(School.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.SchoolDAO#findSchoolDTOByName(java.lang.String)
	 */
	@Override
	public School findSchoolByName(final String schoolName)
			throws TechnicalException {
		return (School) entityManager
				.createQuery("select s from School s where s.name=:schoolName")
				.setParameter("schoolName", schoolName).getResultList();
	}

}
