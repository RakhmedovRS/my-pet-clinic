package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest
{
	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController ownerController;

	private Set<Owner> owners;
	private MockMvc mockMvc;

	@BeforeEach
	void setUp()
	{
		owners = new HashSet<>(Arrays.asList(
			Owner.builder().id(1L).build(),
			Owner.builder().id(2L).build()
		));

		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void findOwners() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/findOwners"))
			.andExpect(model().attributeExists("owner"));

		verifyZeroInteractions(ownerService);
	}

	@Test
	void processFindFormReturnMany() throws Exception
	{
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(new ArrayList<>(owners));

		mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/ownersList"))
			.andExpect(model().attribute("selections", hasSize(2)));
	}

	@Test
	void processFindFormReturnOne() throws Exception
	{
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Owner.builder().id(1L).build()));

		mockMvc.perform(MockMvcRequestBuilders.get("/owners"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"));
	}

	@Test
	void displayOwner() throws Exception
	{
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(MockMvcRequestBuilders.get("/owners/1"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/ownerDetails"))
			.andExpect(model().attribute("owner", hasProperty("id", is(1L))));
	}

	@Test
	void initCreationForm() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/owners/new"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/createOrUpdateOwnerForm"))
			.andExpect(model().attributeExists("owner"));
	}

	@Test
	void processCreationForm() throws Exception
	{
		when(ownerService.save(any())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(MockMvcRequestBuilders.post("/owners/new"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"))
			.andExpect(model().attributeExists("owner"));
	}

	@Test
	void initUpdateForm() throws Exception
	{
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/edit"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/createOrUpdateOwnerForm"))
			.andExpect(model().attributeExists("owner"));
	}

	@Test
	void processUpdateForm() throws Exception
	{
		when(ownerService.save(any())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/edit"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/owners/1"))
			.andExpect(model().attributeExists("owner"));

		verify(ownerService).save(any());
	}
}