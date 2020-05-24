package com.github.rakhmedovrs.mypetclinic.model;

import lombok.*;

import java.time.LocalDate;
import javax.persistence.*;

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
}
