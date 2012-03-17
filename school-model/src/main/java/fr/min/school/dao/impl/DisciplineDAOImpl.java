/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import fr.min.school.dao.DisciplineDAO;
import fr.min.school.model.Discipline;

/**
 * DAO implementation for disciplines.
 * 
 * @author Wilfried Petit
 * 
 */
public class DisciplineDAOImpl extends GenericDAOImpl<Discipline, Integer> implements DisciplineDAO {

	/**
	 * @see fr.min.school.dao.DisciplineDAO#getAllDisciplines()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Discipline> getAllDisciplines() {
		return entityManager.createQuery("select d from Discipline d")
				.getResultList();
	}

	/**
	 * @see fr.min.school.dao.DisciplineDAO#createDiscipline(fr.min.school.model.Discipline)
	 */
	@Override
	public void createDiscipline(final Discipline discipline) {
		entityManager.persist(discipline);
	}

	/**
	 * @see fr.min.school.dao.DisciplineDAO#getDisciplineRatio(int)
	 */
	@Override
	public float getDisciplineRatio(final int id) {
		final Discipline discipline = entityManager.find(Discipline.class, id);
		return discipline.getRatio();
	}

}
