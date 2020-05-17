package com.github.rakhmedovrs.mypetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@Controller
@RequestMapping("/")
public class IndexController
{
	@RequestMapping(path = {"", "index.html"}, method = RequestMethod.GET)
	public String index()
		{
		return "index";
	}

	@RequestMapping(path = "/oups" , method = RequestMethod.GET)
	public String oupsHandler()
	{
		return "nonimplemented";
	}
}
