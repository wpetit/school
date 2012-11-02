package fr.min.school.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

/**
 * Interface generique pour les service JPA
 * <p>
 * Toutes les exceptions sont de type RuntimeException (@see
 * org.springframework.dao.DataAccessException)
 * 
 * @author rebourgi
 * 
 * @param <T,PK> Table et primary key
 */
public interface GenericDAO<T, PK> {

	/**
	 * Synchronise objects entityManager dans la base
	 * 
	 * @throws DataAccessException
	 */
	public void flush();

	/**
	 * Save object persistant
	 * 
	 * @param o
	 * @throws DataAccessException
	 */
	public void save(T o);

	/**
	 * Persist un object dans la base
	 * 
	 * @param o
	 *            l'objet persistant à enregistrer
	 * @throws DataAccessException
	 */
	public void persist(T o);

	/**
	 * Charge un objet persistant à partir d'un id, retourne null si il n'existe
	 * pas
	 * 
	 * @param id
	 *            l'id de l'objet persistant
	 * @return T l'objet persistant trouvé en base
	 * @throws DataAccessException
	 */
	public T find(PK id);

	/**
	 * Charge un objet persistant à partir d'un id, retourne une exception si il
	 * n'existe pas
	 * 
	 * @param id
	 *            l'id de l'objet persistant
	 * @return T l'objet persistant trouvé en base
	 * @throws DataAccessException
	 */
	public T getReference(PK id);

	/**
	 * Charge tous les objets
	 * 
	 * @return List liste des objets
	 * @throws DataAccessException
	 */
	public List<T> findAll();

}
