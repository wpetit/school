/**
 * 
 */
package fr.min.school.business.impl;

import java.util.ArrayList;
import java.util.List;

import fr.min.school.business.DisciplineBusiness;
import fr.min.school.dao.DisciplineDAO;
import fr.min.school.model.Discipline;
import fr.min.school.model.dto.DisciplineDTO;

/**
 * This class manage the discipline business.
 * 
 * @author Wilfried Petit
 * 
 */
public class DisciplineBusinessImpl extends AbstractBusiness implements
		DisciplineBusiness {

	private DisciplineDAO disciplineDAO;

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
	 * @see fr.min.school.business.DisciplineBusiness#getAllDisciplines()
	 */
	@Override
	public List<DisciplineDTO> getAllDisciplines() {
		final List<DisciplineDTO> allDisciplineDTO = new ArrayList<DisciplineDTO>();
		for (final Discipline discipline : disciplineDAO.getAllDisciplines()) {
			allDisciplineDTO.add(mapper.map(discipline, DisciplineDTO.class));
		}
		return allDisciplineDTO;
	}

}
