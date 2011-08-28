/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.DisciplineDAO;
import fr.min.school.model.Discipline;

/**
 * @author Wilfried Petit
 * 
 */
public class DisciplineDAOImpl extends HibernateDaoSupport implements
		DisciplineDAO {

	/**
	 * @see fr.min.school.dao.DisciplineDAO#getAllDisciplines()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Discipline> getAllDisciplines() {
		final Query query = getSessionFactory().getCurrentSession()
				.createQuery("from Discipline");
		return query.list();
	}

	/**
	 * @see fr.min.school.dao.DisciplineDAO#createDiscipline(fr.min.school.model.Discipline)
	 */
	@Override
	public void createDiscipline(final Discipline discipline) {
		getSessionFactory().getCurrentSession().saveOrUpdate(discipline);
	}

	/**
	 * @see fr.min.school.dao.DisciplineDAO#getDisciplineRatio(int)
	 */
	@Override
	public float getDisciplineRatio(final int id) {
		final String ratioQuery = "select ratio from Discipline d where d.id=:id";
		final Query query = getSessionFactory().getCurrentSession()
				.createQuery(ratioQuery);
		query.setInteger("id", id);
		return (Float) query.uniqueResult();
	}

}
