/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import fr.min.school.dao.StudentClassDAO;
import fr.min.school.model.School;
import fr.min.school.model.Student;
import fr.min.school.model.StudentClass;

/**
 * @author Wilfried Petit
 * 
 */
public class StudentClassDAOImpl extends JpaDaoSupport implements
		StudentClassDAO {

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
		getJpaTemplate().persist(studentClass);
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
		getJpaTemplate().persist(school);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<StudentClass> findAll() {
		return getJpaTemplate().find("select s from StudentClass s");
	}

	@Override
	public StudentClass findStudentClassById(final int id) {
		return getJpaTemplate().find(StudentClass.class, id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findStudentClassByName(java.lang.String)
	 */
	@Override
	public StudentClass findStudentClassByName(final String name) {
		return (StudentClass) getJpaTemplate().find(
				"select s from StudentClass s where s.name=?1", name).get(0);
	}
}
