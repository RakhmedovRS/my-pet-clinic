package com.github.rakhmedovrs.mypetclinic.model;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
public class Owner extends Person
{
	private Set<Pet> pets;

	public Set<Pet> getPets()
	{
		return pets;
	}

	public void setPets(Set<Pet> pets)
	{
		this.pets = pets;
	}
}
