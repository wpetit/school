/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.StudentWorkDAO;
import fr.min.school.model.StudentWork;

/**
 * This class manage student works.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentWorkDAOImpl extends JpaDaoSupport implements StudentWorkDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#findStudentWorks(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentWork> findStudentWorks(final int workId) {
		return getJpaTemplate().find(
				"select s from StudentWork where s.work.id=?1", workId);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#getStudentWorksAverage(int)
	 */
	@Override
	public float getStudentWorksAverage(final int workId) {
		return (Float) getJpaTemplate().find(
				"select avg(s.mark) from StudentWork where s.work.id=?1",
				workId).get(0);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#createStudentWork(fr.min.school.model.StudentWork)
	 */
	@Override
	public void createStudentWork(final StudentWork studentWork) {
		getJpaTemplate().persist(studentWork);
	}
}
