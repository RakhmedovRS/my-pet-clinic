package com.github.rakhmedovrs.mypetclinic.services;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 04-May-20
 */
public interface CRUDService<T, ID>
{
	T findById(ID id);

	T save(T entity);

	Set<T> findAll();

	void delete(T entity);

	void deleteById(ID id);
}
