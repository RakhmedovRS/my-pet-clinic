package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.model.PetType;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import com.github.rakhmedovrs.mypetclinic.services.PetService;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@Controller
@RequestMapping("/owners/{ownerID}")
public class PetController
{
	private final PetTypeService petTypeService;
	private final PetService petService;
	private final OwnerService ownerService;

	public PetController(PetTypeService petTypeService, PetService petService, OwnerService ownerService)
	{
		this.petTypeService = petTypeService;
		this.petService = petService;
		this.ownerService = ownerService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes()
	{
		return petTypeService.findAll();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerID") Long ownerID)
	{
		return ownerService.findById(ownerID);
	}

	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields("id");
	}
}
