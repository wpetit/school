/**
 * 
 */
package fr.min.school.dao.impl;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.WorkDAO;
import fr.min.school.model.Work;

/**
 * @author Wilfried Petit
 * 
 */
public class WorkDAOImpl extends JpaDaoSupport implements WorkDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.WorkDAO#findWorkById()
	 */
	@Override
	public Work findWorkById(final int id) {
		return getJpaTemplate().getEntityManager().find(Work.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.WorkDAO#createWork(fr.min.school.model.Work)
	 */
	@Override
	public void createWork(final Work work) {
		getJpaTemplate().getEntityManager().persist(work);
	}
}
