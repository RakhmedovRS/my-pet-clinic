package com.github.rakhmedovrs.mypetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity
{
	@Column(name = "description")
	private String description;

	public Speciality()
	{
	}

	public Speciality(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
