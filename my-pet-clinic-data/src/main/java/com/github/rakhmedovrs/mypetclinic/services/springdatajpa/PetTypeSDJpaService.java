package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.PetType;
import com.github.rakhmedovrs.mypetclinic.repositories.PetTypeRepository;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
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
public class PetTypeSDJpaService implements PetTypeService
{
	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository)
	{
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id)
	{
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType entity)
	{
		return petTypeRepository.save(entity);
	}

	@Override
	public Set<PetType> findAll()
	{
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType entity)
	{
		petTypeRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		petTypeRepository.deleteById(id);
	}
}
