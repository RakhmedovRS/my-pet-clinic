package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.Speciality;
import com.github.rakhmedovrs.mypetclinic.repositories.SpecialityRepository;
import com.github.rakhmedovrs.mypetclinic.services.SpecialitiesService;
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
public class VetSpecialitySDJpaService implements SpecialitiesService
{
	private final SpecialityRepository specialityRepository;

	public VetSpecialitySDJpaService(SpecialityRepository specialityRepository)
	{
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Speciality findById(Long id)
	{
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality entity)
	{
		return specialityRepository.save(entity);
	}

	@Override
	public Set<Speciality> findAll()
	{
		Set<Speciality> specialities = new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public void delete(Speciality entity)
	{
		specialityRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		specialityRepository.deleteById(id);
	}
}
