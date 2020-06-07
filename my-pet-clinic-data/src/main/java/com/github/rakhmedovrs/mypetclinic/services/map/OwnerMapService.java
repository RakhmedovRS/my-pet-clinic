package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import com.github.rakhmedovrs.mypetclinic.services.PetService;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService
{
	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerMapService(PetTypeService petTypeService, PetService petService)
	{
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findById(Long id)
	{
		return super.findById(id);
	}

	@Override
	public Owner save(Owner owner)
	{
		if (owner != null)
		{
			if (owner.getPets() != null)
			{
				owner.getPets().forEach(pet ->
				{
					if (pet.getPetType() != null)
					{
						if (pet.getPetType().getId() == null)
						{
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					}
					else
					{
						throw new RuntimeException("PetType is required");
					}

					if (pet.getId() == null)
					{
						pet.setId(petService.save(pet).getId());
					}
				});
			}
			return super.save(owner);
		}
		return null;
	}

	@Override
	public Set<Owner> findAll()
	{
		return super.findAll();
	}

	@Override
	public void delete(Owner owner)
	{
		super.delete(owner);
	}

	@Override
	public void deleteById(Long id)
	{
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName)
	{
		return map.values()
			.stream()
			.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
			.findFirst()
			.orElse(null);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName)
	{
		return map.values().stream()
			.filter(owner -> owner.getLastName().startsWith(lastName))
			.collect(Collectors.toList());
	}
}
