package com.github.rakhmedovrs.mypetclinic.controllers;

import com.github.rakhmedovrs.mypetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@Controller
@RequestMapping("/vets")
public class VetController
{
	private final VetService vetService;

	public VetController(VetService vetService)
	{
		this.vetService = vetService;
	}

	@RequestMapping(path = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
	public String listVets(Model model)
	{
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
