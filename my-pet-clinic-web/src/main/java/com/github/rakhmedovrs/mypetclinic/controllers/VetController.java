package com.github.rakhmedovrs.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@Controller
public class VetController
{
	@RequestMapping(path = {"/vets", "/vets/index", "/vets/index.html"}, method = RequestMethod.GET)
	public String listVets()
	{
		return "vets/index";
	}
}
