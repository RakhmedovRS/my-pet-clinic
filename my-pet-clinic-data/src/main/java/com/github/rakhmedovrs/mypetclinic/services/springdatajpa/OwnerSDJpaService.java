package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.repositories.OwnerRepository;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService
{
	private final OwnerRepository ownerRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository)
	{
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner findByLastName(String lastName)
	{
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Owner findById(Long id)
	{
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner entity)
	{
		return ownerRepository.save(entity);
	}

	@Override
	public Set<Owner> findAll()
	{
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public void delete(Owner entity)
	{
		ownerRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		ownerRepository.deleteById(id);
	}
}
