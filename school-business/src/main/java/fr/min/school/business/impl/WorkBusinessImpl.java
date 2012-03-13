/**
 * 
 */
package fr.min.school.business.impl;

import fr.min.school.business.WorkBusiness;
import fr.min.school.dao.WorkDAO;
import fr.min.school.model.Work;
import fr.min.school.model.dto.WorkDTO;

/**
 * This class manage the work business.
 * 
 * @author Wilfried Petit
 * 
 */
public class WorkBusinessImpl extends AbstractBusiness implements WorkBusiness {

	private WorkDAO workDAO;

	/**
	 * Set the workDAO use by the business.
	 * 
	 * @param workDAO
	 *            the workDAO to set
	 */
	public void setWorkDAO(final WorkDAO workDAO) {
		this.workDAO = workDAO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.WorkBusiness#findWorkById(int)
	 */
	@Override
	public WorkDTO findWorkById(final int id) {
		final Work work = workDAO.findWorkById(id);
		return mapper.map(work, WorkDTO.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.WorkBusiness#createWork(fr.min.school.dto.WorkDTO)
	 */
	@Override
	public void createWork(final WorkDTO work) {
		workDAO.createWork(mapper.map(work, Work.class));
	}

}
