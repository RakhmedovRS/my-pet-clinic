package com.github.rakhmedovrs.mypetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity
{
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public Person(Long id, String firstName, String lastName)
	{
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
