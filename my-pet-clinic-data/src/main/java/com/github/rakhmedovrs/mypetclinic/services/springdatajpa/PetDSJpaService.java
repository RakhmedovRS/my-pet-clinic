package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.Pet;
import com.github.rakhmedovrs.mypetclinic.repositories.PetRepository;
import com.github.rakhmedovrs.mypetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@Service
@Profile("springdatajpa")
public class PetDSJpaService implements PetService
{
	private final PetRepository petRepository;

	public PetDSJpaService(PetRepository petRepository)
	{
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id)
	{
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet entity)
	{
		return petRepository.save(entity);
	}

	@Override
	public Set<Pet> findAll()
	{
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet entity)
	{
		petRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		petRepository.findById(id);
	}
}
