package com.github.rakhmedovrs.mypetclinic.model;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
public class Speciality extends BaseEntity
{
	private String description;

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
