/**
 * 
 */
package fr.min.school.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import fr.min.school.dao.SchoolDAO;
import fr.min.school.dao.StudentClassDAO;
import fr.min.school.dao.StudentDAO;
import fr.min.school.model.School;
import fr.min.school.model.Student;
import fr.min.school.model.StudentClass;

/**
 * @author Wilfried Petit
 * 
 */
public class StudentClassDAOImpl extends HibernateDaoSupport implements
		StudentClassDAO {

	/**
	 * The schoolDao to manage schools.
	 */
	private SchoolDAO schoolDAO;

	/**
	 * The studentDAO to manage students.
	 */
	private StudentDAO studentDAO;

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#addStudentToStudentClass(fr.min.school.StudentClass,
	 *      fr.min.school.Student)
	 */
	@Override
	public void addStudentToStudentClass(final StudentClass studentClass,
			final Student student) {
		this.getSessionFactory().getCurrentSession().saveOrUpdate(studentClass);
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
		this.getSessionFactory().getCurrentSession().saveOrUpdate(school);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<StudentClass> findAll() {
		final Query query = this.getSessionFactory().getCurrentSession()
				.createQuery("from StudentClass");
		return query.list();
	}

	@Override
	public StudentClass findStudentClassById(final int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.min.school.dao.StudentClassDAO#findStudentClassByName(java.lang.String)
	 */
	@Override
	public StudentClass findStudentClassByName(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the schoolDAO
	 */
	public SchoolDAO getSchoolDAO() {
		return this.schoolDAO;
	}

	/**
	 * @param schoolDAO
	 *            the schoolDAO to set
	 */
	public void setSchoolDAO(final SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	/**
	 * @param studentDAO
	 *            the studentDAO to set
	 */
	public void setStudentDAO(final StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return this.studentDAO;
	}

}
