package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService
{
	@Override
	public Owner findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Owner save(Owner entity)
	{
		return super.save(entity);
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

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName)
	{
		return null;
	}
}
