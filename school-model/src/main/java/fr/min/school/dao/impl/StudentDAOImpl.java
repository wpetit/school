/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.StudentDAO;
import fr.min.school.model.Student;

/**
 * The implementation of the {@link StudentDAO}.
 * 
 * @author Wilfried Petit
 * 
 */
public class StudentDAOImpl extends JpaDaoSupport implements StudentDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentById(int)
	 */
	@Override
	public Student findStudentById(final int id) {
		return getJpaTemplate().find(Student.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#createStudent(fr.min.school.Student)
	 */
	@Override
	public void createStudent(final Student student) {
		getJpaTemplate().persist(student);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentDAO#findStudentsByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findStudentsByName(final String name) {
		return getJpaTemplate().find("select s from Student s where s.name=?1",
				name);
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
		return getJpaTemplate().find(
				"select s from Student s where s.firsname=?1, s.name=?2",
				firstname, name);
	}

}
