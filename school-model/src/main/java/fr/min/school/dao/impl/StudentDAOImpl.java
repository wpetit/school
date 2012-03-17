/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import fr.min.school.dao.StudentDAO;
import fr.min.school.model.Student;

/**
 * The implementation of the {@link StudentDAO}.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentDAOImpl extends GenericDAOImpl<Student, Integer> implements StudentDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentById(int)
	 */
	@Override
	public Student findStudentById(final int id) {
		return entityManager.find(Student.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#createStudent(fr.min.school.Student)
	 */
	@Override
	public void createStudent(final Student student) {
		entityManager.persist(student);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentsByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentsByName(final String name) {
		return entityManager
				.createQuery("select s from Student s where s.name=:name")
				.setParameter("name", name).getResultList();
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
		return entityManager
				.createQuery(
						"select s from Student s where s.firstname=:firstname, s.name=:firstname")
				.setParameter("firstname", firstname)
				.setParameter("name", name).getResultList();
	}

}
