package com.github.rakhmedovrs.mypetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity
{
	@Column(name = "name")
	private String name;

	@Override
	public String toString()
	{
		return name;
	}

	@Builder
	public PetType(Long id, String name)
	{
		super(id);
		this.name = name;
	}
}
