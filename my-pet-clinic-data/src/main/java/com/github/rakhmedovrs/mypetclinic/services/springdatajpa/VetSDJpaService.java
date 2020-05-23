package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.Vet;
import com.github.rakhmedovrs.mypetclinic.repositories.VetRepository;
import com.github.rakhmedovrs.mypetclinic.services.VetService;
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
public class VetSDJpaService implements VetService
{
	private final VetRepository vetRepository;

	public VetSDJpaService(VetRepository vetRepository)
	{
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id)
	{
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet entity)
	{
		return vetRepository.save(entity);
	}

	@Override
	public Set<Vet> findAll()
	{
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void delete(Vet entity)
	{
		vetRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		vetRepository.deleteById(id);
	}
}
