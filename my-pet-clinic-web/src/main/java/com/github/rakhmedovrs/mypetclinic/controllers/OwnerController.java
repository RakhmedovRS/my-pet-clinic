package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.validation.Valid;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@Controller
@RequestMapping("/owners")
public class OwnerController
{
	private static final String FIND_OWNERS = "owners/findOwners";
	private static final String CREATE_OF_UPDATE_OWNER_FORM = "owners/createOrUpdateOwnerForm";
	private static final String OWNERS_REDIRECT = "redirect:/owners/";

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService)
	{
		this.ownerService = ownerService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder webDataBinder)
	{
		webDataBinder.setDisallowedFields("id");
	}

	@GetMapping(path = {"/find"})
	public String findOwners(Model model)
	{
		model.addAttribute("owner", Owner.builder().build());
		return FIND_OWNERS;
	}

	@GetMapping
	public String processFindForm(Owner owner, BindingResult bindingResult, Model model)
	{
		if (owner.getLastName() == null)
		{
			owner.setLastName("");
		}

		List<Owner> ownersList = ownerService.findAllByLastNameLike(owner.getLastName());
		if (ownersList.isEmpty())
		{
			bindingResult.rejectValue("lastName", "notFound", "not found");
			return FIND_OWNERS;
		}
		else if (ownersList.size() == 1)
		{
			return OWNERS_REDIRECT + ownersList.get(0).getId();
		}
		else
		{
			model.addAttribute("selections", ownersList);
			return "owners/ownersList";
		}
	}

	@GetMapping("/{ownerID}")
	public ModelAndView showOwner(@PathVariable Long ownerID)
	{
		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
		modelAndView.addObject(ownerService.findById(ownerID));
		return modelAndView;
	}

	@GetMapping("/new")
	public String initCreationForm(Model model)
	{
		model.addAttribute("owner", Owner.builder().build());
		return CREATE_OF_UPDATE_OWNER_FORM;
	}

	@PostMapping("/new")
	public String processCreationForm(@Valid Owner owner, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return CREATE_OF_UPDATE_OWNER_FORM;
		}

		Owner saved = ownerService.save(owner);
		return OWNERS_REDIRECT + saved.getId();
	}

	@GetMapping("/{ownerID}/edit")
	public String initUpdateForm(@PathVariable Long ownerID, Model model)
	{
		model.addAttribute("owner", ownerService.findById(ownerID));
		return CREATE_OF_UPDATE_OWNER_FORM;
	}

	@PostMapping("/{ownerID}/edit")
	public String processUpdateForm(@Valid Owner owner,
	                                @PathVariable Long ownerID,
	                                BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return CREATE_OF_UPDATE_OWNER_FORM;
		}

		owner.setId(ownerID);
		Owner saved = ownerService.save(owner);
		return OWNERS_REDIRECT + saved.getId();
	}
}
