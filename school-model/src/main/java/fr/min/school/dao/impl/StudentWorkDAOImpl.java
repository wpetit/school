/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import fr.min.school.dao.StudentWorkDAO;
import fr.min.school.model.StudentWork;

/**
 * This class manage student works.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentWorkDAOImpl extends DAOImpl implements StudentWorkDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#findStudentWorks(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentWork> findStudentWorks(final int workId) {
		return entityManager
				.createQuery("select s from StudentWork where s.work.id=:id")
				.setParameter("id", workId).getResultList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#getStudentWorksAverage(int)
	 */
	@Override
	public float getStudentWorksAverage(final int workId) {
		return (Float) entityManager
				.createQuery(
						"select avg(s.mark) from StudentWork where s.work.id=id")
				.setParameter("id", workId).getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#createStudentWork(fr.min.school.model.StudentWork)
	 */
	@Override
	public void createStudentWork(final StudentWork studentWork) {
		entityManager.persist(studentWork);
	}
}
