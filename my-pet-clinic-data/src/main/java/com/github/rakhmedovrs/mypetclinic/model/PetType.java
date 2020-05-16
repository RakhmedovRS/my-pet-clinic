package com.github.rakhmedovrs.mypetclinic.model;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
public class PetType extends BaseEntity
{
	private String name;

	public PetType()
	{
	}

	public PetType(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
