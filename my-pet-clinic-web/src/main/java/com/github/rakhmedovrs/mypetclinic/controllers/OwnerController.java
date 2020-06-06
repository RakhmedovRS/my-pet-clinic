package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping(path = {"", "/", "/index", "/index.html"})
	public String listOwners(Model model)
	{
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}

	@GetMapping(path = {"/find"})
	public String findOwners()
	{
		return "nonimplemented";
	}

	@GetMapping("/{ownerID}")
	public ModelAndView showOwner(@PathVariable String ownerID)
	{
		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
		modelAndView.addObject(ownerService.findById(Long.valueOf(ownerID)));
		return modelAndView;
	}
}
