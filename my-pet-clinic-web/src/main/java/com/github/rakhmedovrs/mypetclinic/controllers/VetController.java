package com.github.rakhmedovrs.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
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
	@RequestMapping(path = {"", "/", "/index", "/index.html"}, method = RequestMethod.GET)
	public String listVets()
	{
		return "vets/index";
	}
}