package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.model.Pet;
import com.github.rakhmedovrs.mypetclinic.model.PetType;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import com.github.rakhmedovrs.mypetclinic.services.PetService;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import javax.validation.Valid;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@Controller
@RequestMapping("/owners/{ownerID}")
public class PetController
{
	private static final String CREATE_OF_UPDATE_PET_FORM = "pets/createOrUpdatePetForm";

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

	@GetMapping("/pets/new")
	public String initCreationForm(Owner owner, Model model)
	{
		Pet pet = Pet.builder().build();
		owner.getPets().add(pet);

		model.addAttribute("pet", pet);
		return CREATE_OF_UPDATE_PET_FORM;
	}

	@PostMapping("/pets/new")
	public String processCreationForm(Owner owner, @Valid Pet pet,
	                                  BindingResult bindingResult, Model model)
	{
		if (pet.isNew() && owner.getPets().contains(pet))
		{
			bindingResult.rejectValue("name", "duplicate", "already exists");
		}

		owner.getPets().add(pet);
		if (bindingResult.hasErrors())
		{
			model.addAttribute("pet", pet);
			return CREATE_OF_UPDATE_PET_FORM;
		}

		petService.save(pet);
		return "redirect:/owners/" + owner.getId();
	}

	@GetMapping("/pets/{petId}/edit")
	public String initUpdateForm(@PathVariable Long petId, Model model)
	{
		model.addAttribute("pet", petService.findById(petId));
		return CREATE_OF_UPDATE_PET_FORM;
	}

	@PostMapping("/pets/{petId}/edit")
	public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model)
	{
		if (result.hasErrors())
		{
			pet.setOwner(owner);
			model.addAttribute("pet", pet);
			return CREATE_OF_UPDATE_PET_FORM;
		}
		else
		{
			owner.getPets().add(pet);
			petService.save(pet);
			return "redirect:/owners/" + owner.getId();
		}
	}
}
