package com.github.rakhmedovrs.mypetclinic.formatters;

import com.github.rakhmedovrs.mypetclinic.model.PetType;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@Component
public class PetTypeFormatter implements Formatter<PetType>
{
	private final PetTypeService petTypeService;

	public PetTypeFormatter(PetTypeService petTypeService)
	{
		this.petTypeService = petTypeService;
	}

	@Override
	public PetType parse(String s, Locale locale) throws ParseException
	{
		return petTypeService.findAll()
			.stream()
			.filter(petType -> petType.getName().equals(s))
			.findFirst()
			.orElseThrow(() -> new ParseException("petType: " + s + " not found", 0));
	}

	@Override
	public String print(PetType petType, Locale locale)
	{
		return petType.getName();
	}
}
