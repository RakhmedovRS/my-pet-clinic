package com.github.rakhmedovrs.mypetclinic.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@Setter
@Getter
@NoArgsConstructor
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

	@Builder
	public Owner(Long id, String firstName, String lastName, String address,
	             String city, String telephone, Set<Pet> pets)
	{
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets = pets == null ? this.pets : pets;
	}
}
