package com.github.rakhmedovrs.mypetclinic.model;

import java.io.Serializable;

/**
 * @author RakhmedovRS
 * @created 04-May-20
 */
public class BaseEntity implements Serializable
{
	private Long id;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
