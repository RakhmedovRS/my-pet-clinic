package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Vet;
import com.github.rakhmedovrs.mypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService
{
	@Override
	public Vet findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Vet save(Vet entity)
	{
		return super.save(entity.getId(), entity);
	}

	@Override
	public Set<Vet> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Vet vet)
	{
		super.delete(vet);
	}
}
