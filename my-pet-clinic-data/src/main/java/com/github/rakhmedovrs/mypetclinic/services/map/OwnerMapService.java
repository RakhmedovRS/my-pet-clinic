package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.services.CRUDService;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
public class OwnerMapService extends AbstractMapService<Owner, Long> implements CRUDService<Owner, Long>
{
	@Override
	public Owner findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Owner save(Owner entity)
	{
		return super.save(entity.getId(), entity);
	}

	@Override
	public Set<Owner> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Owner owner)
	{
		super.delete(owner);
	}
}
