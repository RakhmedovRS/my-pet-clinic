package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Vet;
import com.github.rakhmedovrs.mypetclinic.services.SpecialitiesService;
import com.github.rakhmedovrs.mypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService
{
	private final SpecialitiesService specialitiesService;

	public VetMapService(SpecialitiesService specialitiesService)
	{
		this.specialitiesService = specialitiesService;
	}

	@Override
	public Vet findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Vet save(Vet vet)
	{
		if (!vet.getSpecialities().isEmpty())
		{
			vet.getSpecialities().forEach(speciality ->
			{
				if (speciality.getId() == null)
				{
					speciality.setId(specialitiesService.save(speciality).getId());
				}
			});
		}

		return super.save(vet);
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

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
}
