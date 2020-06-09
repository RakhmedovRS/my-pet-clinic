package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.model.Pet;
import com.github.rakhmedovrs.mypetclinic.model.Visit;
import com.github.rakhmedovrs.mypetclinic.services.PetService;
import com.github.rakhmedovrs.mypetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;
import javax.validation.Valid;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@Controller
public class VisitController
{
	private final VisitService visitService;
	private final PetService petService;

	public VisitController(VisitService visitService, PetService petService)
	{
		this.visitService = visitService;
		this.petService = petService;
	}

	@InitBinder
	public void dataBinder(WebDataBinder dataBinder)
	{
		dataBinder.setDisallowedFields("id");

		dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport()
		{
			@Override
			public void setAsText(String text) throws IllegalArgumentException
			{
				setValue(LocalDate.parse(text));
			}
		});
	}

	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petID") Long petID, Map<String, Object> model)
	{
		Pet pet = petService.findById(petID);
		model.put("pet", pet);
		Visit visit = new Visit();
		pet.getVisits().add(visit);
		visit.setPet(pet);
		return visit;
	}

	@GetMapping("/owners/*/pets/{petID}/visits/new")
	public String initNewVisitForm(@PathVariable("petID") Long petID, Map<String, Object> model)
	{
		return "pets/createOrUpdateVisitForm";
	}

	@PostMapping("/owners/{ownerID}/pets/{petID}/visits/new")
	public String processNewVisitForm(@Valid Visit visit, BindingResult result)
	{
		if (result.hasErrors())
		{
			return "pets/createOrUpdateVisitForm";
		}
		else
		{
			visitService.save(visit);

			return "redirect:/owners/{ownerID}";
		}
	}
}
