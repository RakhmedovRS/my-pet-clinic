package com.github.rakhmedovrs.mypetclinic.model;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity
{
	@Column(name = "name")
	private String name;

	@ManyToOne(targetEntity = PetType.class)
	@JoinColumn(name = "type_id")
	private PetType petType;

	@ManyToOne(targetEntity = Owner.class)
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	public Pet()
	{
	}

	public Pet(String name, PetType petType, Owner owner, LocalDate birthDate)
	{
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public PetType getPetType()
	{
		return petType;
	}

	public void setPetType(PetType petType)
	{
		this.petType = petType;
	}

	public Owner getOwner()
	{
		return owner;
	}

	public void setOwner(Owner owner)
	{
		this.owner = owner;
	}

	public LocalDate getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate)
	{
		this.birthDate = birthDate;
	}
}
