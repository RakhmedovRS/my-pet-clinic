package com.github.rakhmedovrs.mypetclinic.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@Entity
@Table(name = "owners")
public class Owner extends Person
{
	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "telephone")
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

	public Owner()
	{
	}

	public Owner(String firstName, String lastName, String address, String city, String telephone)
	{
		super(firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public Set<Pet> getPets()
	{
		return pets;
	}

	public void setPets(Set<Pet> pets)
	{
		this.pets = pets;
	}
}
