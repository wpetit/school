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
	public List<StudentWork> findStudentWorks(int workId) {
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(StudentWork.class);
		Criterion workIdCriterion = Restrictions.eq("work.id", workId);
		criteria.add(workIdCriterion);
		return criteria.list();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentWorkDAO#getStudentWorksAverage(int)
	 */
	@Override
	public float getStudentWorksAverage(int workId) {
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(StudentWork.class);
		Criterion workIdCriterion = Restrictions.eq("work.id", workId);
		criteria.add(workIdCriterion);
		Criterion presentCriterion = Restrictions.eq("absent", false);
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
	public void createStudentWork(StudentWork studentWork) {
		this.getSessionFactory().getCurrentSession().save(studentWork);
	}
}
