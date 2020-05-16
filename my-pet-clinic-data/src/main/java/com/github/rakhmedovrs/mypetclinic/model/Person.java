package com.github.rakhmedovrs.mypetclinic.model;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
public class Person extends BaseEntity
{
	private String firstName;
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
