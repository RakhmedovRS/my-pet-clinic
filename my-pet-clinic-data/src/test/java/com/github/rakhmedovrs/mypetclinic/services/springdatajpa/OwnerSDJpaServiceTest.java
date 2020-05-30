package com.github.rakhmedovrs.mypetclinic.services.springdatajpa;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.repositories.OwnerRepository;
import com.github.rakhmedovrs.mypetclinic.repositories.PetRepository;
import com.github.rakhmedovrs.mypetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest
{
	@Mock
	private OwnerRepository ownerRepository;

	@Mock
	private PetRepository petRepository;

	@Mock
	private PetTypeRepository petTypeRepository;

	@InjectMocks
	private OwnerSDJpaService ownerSDJpaService;

	private static final Long ID = 1L;
	private static final String LAST_NAME = "vasilievich";

	private  Owner owner;

	@BeforeEach
	void setUp()
	{
		owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
	}

	@Test
	void findByLastName()
	{
		when(ownerRepository.findByLastName(any())).thenReturn(owner);

		Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);
		assertNotNull(owner);
		assertEquals(ID, owner.getId());
		assertEquals(LAST_NAME, owner.getLastName());

		verify(ownerRepository).findByLastName(any());
	}

	@Test
	void findById()
	{
		when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));

		Owner owner = ownerSDJpaService.findById(ID);
		assertNotNull(owner);
		assertEquals(ID, owner.getId());
	}

	@Test
	void findByBadId()
	{
		when(ownerRepository.findById(any())).thenReturn(Optional.empty());

		Owner owner = ownerSDJpaService.findById(ID);
		assertNull(owner);
	}

	@Test
	void save()
	{
		Owner newOwner = Owner.builder().id(1L).build();

		when(ownerRepository.save(any())).thenReturn(owner);

		Owner savedOwner = ownerSDJpaService.save(newOwner);
		assertNotNull(savedOwner);
	}

	@Test
	void findAll()
	{
		Set<Owner> owners1 = new HashSet<>(Arrays.asList(
			Owner.builder().id(2L).build(),
			Owner.builder().id(3L).build()
		));

		when(ownerRepository.findAll()).thenReturn(owners1);

		Set<Owner> owners2 = ownerSDJpaService.findAll();
		assertNotNull(owners2);
		assertEquals(owners1.size(), owners2.size());
	}

	@Test
	void delete()
	{
		ownerSDJpaService.delete(owner);
		verify(ownerRepository).delete(any());
	}

	@Test
	void deleteById()
	{
		ownerSDJpaService.deleteById(ID);
		verify(ownerRepository).deleteById(anyLong());
	}
}