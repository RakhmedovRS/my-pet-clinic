package com.github.rakhmedovrs.mypetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@MappedSuperclass
public class Person extends BaseEntity
{
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	public Person()
	{
	}

	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
}
