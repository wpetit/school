/**
 * 
 */
package fr.min.school.business.impl;

import org.dozer.Mapper;

import fr.min.school.business.WorkBusiness;
import fr.min.school.dao.WorkDAO;
import fr.min.school.model.Work;
import fr.min.school.model.dto.WorkDTO;

/**
 * @author Wilfried Petit
 * 
 */
public class WorkBusinessImpl implements WorkBusiness {

	private WorkDAO workDAO;
	private Mapper mapper;

	/**
	 * @param workDAO
	 *            the workDAO to set
	 */
	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
	}

	/**
	 * @param mapper
	 *            the mapper to set
	 */
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.WorkBusiness#findWorkById(int)
	 */
	@Override
	public WorkDTO findWorkById(int id) {
		Work work = this.workDAO.findWorkById(id);
		return this.mapper.map(work, WorkDTO.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.business.WorkBusiness#createWork(fr.min.school.dto.WorkDTO)
	 */
	@Override
	public void createWork(WorkDTO work) {
		this.workDAO.createWork(this.mapper.map(work, Work.class));
	}

}
