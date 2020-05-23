package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.PetType;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService
{
	@Override
	public PetType findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public PetType save(PetType entity)
	{
		return super.save(entity);
	}

	@Override
	public Set<PetType> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(PetType entity)
	{
		super.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
}
