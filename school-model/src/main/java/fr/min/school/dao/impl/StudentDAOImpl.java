/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.StudentDAO;
import fr.min.school.model.Student;

/**
 * The implementation of the {@link StudentDAO}.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentById(int)
	 */
	@Override
	public Student findStudentById(final int id) {
		return (Student) this.getSessionFactory().getCurrentSession()
				.get(Student.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#createStudent(fr.min.school.Student)
	 */
	@Override
	public Student createStudent(final Student student) {
		this.getSessionFactory().getCurrentSession().save(student);
		return student;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentsByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentsByName(final String name) {
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(Student.class);
		Criterion nameCriterion = Restrictions.eq("name", name);
		criteria.add(nameCriterion);
		return criteria.list();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentsByFirstnameAndName(java.lang.String,
	 *      java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentsByFirstnameAndName(final String firstname,
			final String name) {
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(Student.class);
		Criterion firstnameCriterion = Restrictions.eq("firstame", firstname);
		Criterion nameCriterion = Restrictions.eq("name", name);
		criteria.add(firstnameCriterion);
		criteria.add(nameCriterion);
		return criteria.list();
	}

}
