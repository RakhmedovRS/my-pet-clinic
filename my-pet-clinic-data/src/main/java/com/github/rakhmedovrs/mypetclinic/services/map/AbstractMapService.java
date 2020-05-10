package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.BaseEntity;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>
{
	protected Map<Long, T> map = new HashMap<>();
	protected Long id = 1L;

	Set<T> findAll()
	{
		return new HashSet<>(map.values());
	}

	T findById(ID id)
	{
		return map.get(id);
	}

	T save(T entity)
	{
		if (entity != null && entity.getId() == null)
		{
			entity.setId(getNextId());
			map.put(entity.getId(), entity);
		}
		else
		{
			throw new RuntimeException("entity is null");
		}
		return entity;
	}

	void deleteById(ID id)
	{
		map.remove(id);
	}

	void delete(T entity)
	{
		map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
	}

	private Long getNextId()
	{
		return id++;
	}
}
