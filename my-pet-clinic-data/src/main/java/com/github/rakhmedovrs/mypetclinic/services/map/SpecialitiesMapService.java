package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Speciality;
import com.github.rakhmedovrs.mypetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService
{
	@Override
	public Speciality findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality speciality)
	{
		return super.save(speciality);
	}

	@Override
	public Set<Speciality> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Speciality speciality)
	{
		super.delete(speciality);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}
}
