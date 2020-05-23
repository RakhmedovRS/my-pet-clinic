package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Visit;
import com.github.rakhmedovrs.mypetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService
{
	@Override
	public Visit findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Visit save(Visit visit)
	{
		if (visit.getPet() == null
			|| visit.getPet().getOwner() == null
			|| visit.getPet().getId() == null
			|| visit.getPet().getOwner().getId() == null
		)
		{
			throw new RuntimeException("Invalid visit");
		}

		return super.save(visit);
	}

	@Override
	public Set<Visit> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Visit visit)
	{
		super.delete(visit);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
}
