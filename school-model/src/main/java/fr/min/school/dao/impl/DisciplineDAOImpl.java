/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.DisciplineDAO;
import fr.min.school.model.Discipline;

/**
 * @author Wilfried Petit
 * 
 */
public class DisciplineDAOImpl extends JpaDaoSupport implements DisciplineDAO {

	/**
	 * @see fr.min.school.dao.DisciplineDAO#getAllDisciplines()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Discipline> getAllDisciplines() {
		return getJpaTemplate().find("select d from Discipline d");
	}

	/**
	 * @see fr.min.school.dao.DisciplineDAO#createDiscipline(fr.min.school.model.Discipline)
	 */
	@Override
	public void createDiscipline(final Discipline discipline) {
		getJpaTemplate().persist(discipline);
	}

	/**
	 * @see fr.min.school.dao.DisciplineDAO#getDisciplineRatio(int)
	 */
	@Override
	public float getDisciplineRatio(final int id) {
		final Discipline discipline = getJpaTemplate().find(Discipline.class,
				id);
		return discipline.getRatio();
	}

}
