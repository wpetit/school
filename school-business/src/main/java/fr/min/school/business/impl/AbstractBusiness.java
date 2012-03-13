/**
 * 
 */
package fr.min.school.business.impl;

import org.dozer.Mapper;

import fr.min.school.business.Business;

/**
 * Abstraction of a business component.
 * 
 * @author Wilfried Petit
 * 
 */
public abstract class AbstractBusiness implements Business {
	protected Mapper mapper;

	/**
	 * Dozer mapper to map models to dtos.
	 * 
	 * @param mapper
	 *            the mapper to set
	 */
	public void setMapper(final Mapper mapper) {
		this.mapper = mapper;
	}
}
