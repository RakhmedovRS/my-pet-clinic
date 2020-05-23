package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.Visit;
import com.github.rakhmedovrs.mypetclinic.repositories.VisitRepository;
import com.github.rakhmedovrs.mypetclinic.services.VisitService;
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
public class VisitSDJpaService implements VisitService
{
	private final VisitRepository visitRepository;

	public VisitSDJpaService(VisitRepository visitRepository)
	{
		this.visitRepository = visitRepository;
	}

	@Override
	public Visit findById(Long id)
	{
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit entity)
	{
		return visitRepository.save(entity);
	}

	@Override
	public Set<Visit> findAll()
	{
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public void delete(Visit entity)
	{
		visitRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id)
	{
		visitRepository.deleteById(id);
	}
}
