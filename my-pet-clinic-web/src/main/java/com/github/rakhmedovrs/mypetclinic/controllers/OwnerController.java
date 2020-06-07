package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@Controller
@RequestMapping("/owners")
public class OwnerController
{
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
		return "owners/findOwners";
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
			return "owners/findOwners";
		}
		else if (ownersList.size() == 1)
		{
			return "redirect:/owners/" + ownersList.get(0).getId();
		}
		else
		{
			model.addAttribute("selections", ownersList);
			return "owners/ownersList";
		}
	}

	@GetMapping("/{ownerID}")
	public ModelAndView showOwner(@PathVariable String ownerID)
	{
		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
		modelAndView.addObject(ownerService.findById(Long.valueOf(ownerID)));
		return modelAndView;
	}
}
