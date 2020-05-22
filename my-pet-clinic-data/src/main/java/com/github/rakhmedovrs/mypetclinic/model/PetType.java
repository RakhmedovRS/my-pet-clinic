package com.github.rakhmedovrs.mypetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity
{
	@Column(name = "name")
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
