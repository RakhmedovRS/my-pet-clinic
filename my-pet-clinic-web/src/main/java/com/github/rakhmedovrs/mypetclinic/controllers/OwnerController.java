package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(path = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
	public String listOwners(Model model)
	{
		model.addAttribute("owners", ownerService.findAll());
		return "owners/index";
	}
}
