/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.StudentWorkDAO;
import fr.min.school.model.StudentWork;

/**
 * This class manage student works.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentWorkDAOImpl extends HibernateDaoSupport implements
		StudentWorkDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#findStudentWorks(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentWork> findStudentWorks(final int workId) {
		final Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(StudentWork.class);
		final Criterion workIdCriterion = Restrictions.eq("work.id", workId);
		criteria.add(workIdCriterion);
		return criteria.list();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#getStudentWorksAverage(int)
	 */
	@Override
	public float getStudentWorksAverage(final int workId) {
		final Criteria criteria = getSessionFactory().getCurrentSession()
				.createCriteria(StudentWork.class);
		final Criterion workIdCriterion = Restrictions.eq("work.id", workId);
		criteria.add(workIdCriterion);
		final Criterion presentCriterion = Restrictions.eq("absent", false);
		criteria.add(presentCriterion);
		criteria.setProjection(Projections.avg("mark"));
		return (Float) criteria.uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#createStudentWork(fr.min.school.model.StudentWork)
	 */
	@Override
	public void createStudentWork(final StudentWork studentWork) {
		getSessionFactory().getCurrentSession().save(studentWork);
	}
}
