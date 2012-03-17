package fr.min.school.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import fr.min.school.dao.GenericDAO;


/**
 * Implementation du DAO JPA Generique. Un EntityManager est injecté par Spring
 * 
 * @author rebourgi
 * @param <T,PK> Table et primary key
 */
public abstract class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {
	
	protected Class<T> type = null;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected GenericDAOImpl() {
		this.type = this.getParameterizedType(this.getClass());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Class<T> getParameterizedType(Class clazz) {
		Class<T> specificType = null;
		ParameterizedType parameterizedType = (ParameterizedType) clazz
				.getGenericSuperclass();
		specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return specificType;
	}
	
	/**
	 * @see fr.min.school.dao.GenericDAO#flush()
	 */
	public void flush() {
		entityManager.flush();
	}
	
	/**
	 * @see fr.min.school.dao.GenericDAO#persist(T)
	 */
	public void persist(T o) {
		entityManager.persist(o);
	}
	
	/**
	 * @see fr.min.school.dao.GenericDAO#remove(T)
	 */
	public void remove(T o) {
		entityManager.remove(o);
	}
	
	/**
	 * @see fr.min.school.dao.GenericDAO#refresh(T)
	 */
	public void refresh(T o) {
		entityManager.refresh(o);
	}
	
	public T find(PK primaryKey) {
		return entityManager.find(type, primaryKey);
	}
	
	public T getReference(PK primaryKey) {
		return entityManager.getReference(type, primaryKey);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("SELECT x FROM " + type.getSimpleName() + " x")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> getEntityList(String queryString) {
		Query query = entityManager.createQuery(queryString);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	protected T getSingleEntity(String queryString) {
		Query query = entityManager.createQuery(queryString);
		return (T) query.getSingleResult();
	}
	
}
