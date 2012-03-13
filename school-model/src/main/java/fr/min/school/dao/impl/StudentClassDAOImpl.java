/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import fr.min.school.dao.StudentClassDAO;
import fr.min.school.model.School;
import fr.min.school.model.Student;
import fr.min.school.model.StudentClass;

/**
 * DAO implementation for student classes.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentClassDAOImpl extends DAOImpl implements StudentClassDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#addStudentToStudentClass(fr.min.school.StudentClass,
	 *      fr.min.school.Student)
	 */
	@Override
	public void addStudentToStudentClass(final StudentClass studentClass,
			final Student student) {
		studentClass.getStudents().add(student);
		entityManager.persist(studentClass);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#createStudentClass(fr.min.school.School,
	 *      fr.min.school.StudentClass)
	 */
	@Override
	public void createStudentClass(final School school,
			final StudentClass studentClass) {
		entityManager.persist(school);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<StudentClass> findAll() {
		return entityManager.createQuery("select s from StudentClass s")
				.getResultList();
	}

	@Override
	public StudentClass findStudentClassById(final int id) {
		return entityManager.find(StudentClass.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findStudentClassByName(java.lang.String)
	 */
	@Override
	public StudentClass findStudentClassByName(final String name) {
		return (StudentClass) entityManager
				.createQuery("select s from StudentClass s where s.name=:name")
				.setParameter("name", name).getSingleResult();
	}
}
