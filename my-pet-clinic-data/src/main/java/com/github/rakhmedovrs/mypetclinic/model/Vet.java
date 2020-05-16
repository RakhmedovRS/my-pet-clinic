package com.github.rakhmedovrs.mypetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
public class Vet extends Person
{
	private Set<Speciality> specialities;

	public Vet()
	{
		specialities = new HashSet<>();
	}

	public Vet(String firstName, String lastName)
	{
		super(firstName, lastName);
	}

	public Set<Speciality> getSpecialities()
	{
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities)
	{
		this.specialities = specialities;
	}
}
