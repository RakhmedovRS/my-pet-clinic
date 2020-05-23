package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Pet;
import com.github.rakhmedovrs.mypetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@Service
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService
{
	@Override
	public Pet findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Pet save(Pet entity)
	{
		return super.save(entity);
	}

	@Override
	public Set<Pet> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Pet pet)
	{
		super.delete(pet);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
}
