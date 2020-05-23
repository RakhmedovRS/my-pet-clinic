package com.github.rakhmedovrs.mypetclinic.model;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity
{
	@Column(name = "date")
	private LocalDate date = LocalDate.now();

	@Column(name = "description")
	private String description;

	@ManyToOne(targetEntity = Pet.class)
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Visit()
	{
	}

	public Visit(String description, Pet pet)
	{
		this.description = description;
		this.pet = pet;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Pet getPet()
	{
		return pet;
	}

	public void setPet(Pet pet)
	{
		this.pet = pet;
	}
}
