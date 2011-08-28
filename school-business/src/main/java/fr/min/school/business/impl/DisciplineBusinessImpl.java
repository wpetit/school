/**
 * 
 */
package fr.min.school.business.impl;

import java.util.List;

import org.dozer.Mapper;

import fr.min.school.business.DisciplineBusiness;
import fr.min.school.dao.DisciplineDAO;
import fr.min.school.model.Discipline;
import fr.min.school.model.dto.DisciplineDTO;

/**
 * @author Wilfried Petit
 * 
 */
public class DisciplineBusinessImpl implements DisciplineBusiness {

	private DisciplineDAO disciplineDAO;
	private Mapper mapper;

	/**
	 * @param disciplineDAO
	 *            the disciplineDAO to set
	 */
	public void setDisciplineDAO(final DisciplineDAO disciplineDAO) {
		this.disciplineDAO = disciplineDAO;
	}

	/**
	 * @see fr.min.school.business.DisciplineBusiness#createDiscipline(fr.min.school.model.dto.DisciplineDTO)
	 */
	@Override
	public void createDiscipline(final DisciplineDTO disciplineDTO) {
		final Discipline discipline = mapper.map(disciplineDTO,
				Discipline.class);
		disciplineDAO.createDiscipline(discipline);
	}

	/**
	 * @see fr.min.school.business.DisciplineBusiness#getAllDiscipline()
	 */
	@Override
	public List<DisciplineDTO> getAllDiscipline() {
		// TODO Auto-generated method stub
		return null;
	}

}
