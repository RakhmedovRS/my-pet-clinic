package com.github.rakhmedovrs.mypetclinic.bootstrap;

import com.github.rakhmedovrs.mypetclinic.model.*;
import com.github.rakhmedovrs.mypetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@Component
public class DataLoader implements CommandLineRunner
{
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialitiesService specialitiesService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService)
	{
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitiesService = specialitiesService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args)
	{
		if (petTypeService.findAll().isEmpty())
		{
			loadData();
		}
	}

	private void loadData()
	{
		PetType dog = petTypeService.save(new PetType("Dog"));
		PetType cat = petTypeService.save(new PetType("Cat"));
		System.out.println("PetTypes are loaded");

		Speciality radiology = specialitiesService.save(new Speciality("Radiology"));
		Speciality surgery = specialitiesService.save(new Speciality("Surgery"));
		Speciality dentistry = specialitiesService.save(new Speciality("Dentistry"));
		System.out.println("Specialities are added");

		Owner ivan = new Owner("Ivan", "Ivanov", "ul. Lenina d.1", "Moscow", "111111111");

		Pet ivanDog = new Pet("Muhtar", dog, ivan, LocalDate.now().minusYears(1));
		ivan.getPets().add(ivanDog);

		ownerService.save(ivan);

		Owner petr = new Owner("Petr", "Petrov", "ul. Lenina d.2", "Moscow", "222222222");

		Pet petrCat = new Pet("Myau", cat, petr, LocalDate.now().minusYears(2));
		petr.getPets().add(petrCat);

		ownerService.save(petr);

		Visit catVisit = new Visit("Sneezy Kitty", petrCat);
		visitService.save(catVisit);

		System.out.println("Owners are loaded");

		Vet vet1 = new Vet("Kozel", "Kozlov");
		vet1.getSpecialities().add(radiology);
		vetService.save(vet1);

		Vet vet2 = new Vet("Volk", "Volkov");
		vet2.getSpecialities().add(surgery);
		vet2.getSpecialities().add(dentistry);
		vetService.save(vet2);
		System.out.println("Vets are loaded");
	}
}
