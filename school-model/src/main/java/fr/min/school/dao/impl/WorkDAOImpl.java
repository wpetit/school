/**
 * 
 */
package fr.min.school.dao.impl;

import fr.min.school.dao.WorkDAO;
import fr.min.school.model.Work;

/**
 * DAO implementation for works.
 * 
 * @author Wilfried Petit
 * 
 */
public class WorkDAOImpl extends DAOImpl implements WorkDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.WorkDAO#findWorkById()
	 */
	@Override
	public Work findWorkById(final int id) {
		return entityManager.find(Work.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.WorkDAO#createWork(fr.min.school.model.Work)
	 */
	@Override
	public void createWork(final Work work) {
		entityManager.persist(work);
	}
}
