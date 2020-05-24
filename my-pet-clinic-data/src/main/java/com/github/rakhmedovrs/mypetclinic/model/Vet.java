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
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person
{
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities",
		joinColumns = @JoinColumn(name = "vet_id"),
		inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();
}
