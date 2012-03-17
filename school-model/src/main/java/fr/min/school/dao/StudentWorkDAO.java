/**
 * 
 */
package fr.min.school.dao;

import java.util.List;

import fr.min.school.model.StudentWork;

/**
 * This interface manage studentWork.
 * 
 * @author Wilfried Petit
 * 
 */
public interface StudentWorkDAO extends GenericDAO<StudentWork, Integer> {
	
	List<StudentWork> findStudentWorks(int workId);

	float getStudentWorksAverage(int workId);

	void createStudentWork(StudentWork studentWork);
}
