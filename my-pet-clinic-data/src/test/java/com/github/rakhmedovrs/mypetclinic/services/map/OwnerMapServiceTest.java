package com.github.rakhmedovrs.mypetclinic.services.map;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
class OwnerMapServiceTest
{
	private OwnerMapService ownerMapService;
	private final Long ownerID = 1L;
	private final String lastName = "Vasilievich";

	@BeforeEach
	void setUp()
	{
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		ownerMapService.save(Owner.builder().id(ownerID).lastName(lastName).build());
	}

	@Test
	void findById()
	{
		Owner owner = ownerMapService.findById(ownerID);
		assertEquals(ownerID, owner.getId());
	}

	@Test
	void saveExistId()
	{
		Long id = 2L;

		Owner owner = Owner.builder().id(id).build();
		ownerMapService.save(owner);

		Owner saved = ownerMapService.findById(id);
		assertEquals(owner, saved);
	}

	@Test
	void saveNoId()
	{
		Owner saved = ownerMapService.save(Owner.builder().build());
		assertNotNull(saved);
		assertNotNull(saved.getId());
	}

	@Test
	void findAll()
	{
		Set<Owner> owners = ownerMapService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void delete()
	{
		ownerMapService.delete(ownerMapService.findById(ownerID));
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void deleteById()
	{
		ownerMapService.deleteById(ownerID);
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void findByLastName()
	{
		Owner owner = ownerMapService.findByLastName(lastName);
		assertEquals(ownerID, owner.getId());
	}

	@Test
	void findByInvalidLastName()
	{
		Owner owner = ownerMapService.findByLastName("hfghfghfgh");
		assertNull(owner);
	}
}