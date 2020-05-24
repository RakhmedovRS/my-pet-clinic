package com.github.rakhmedovrs.mypetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity
{
	@Column(name = "description")
	private String description;
}
