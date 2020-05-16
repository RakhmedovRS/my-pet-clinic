package com.github.rakhmedovrs.mypetclinic.bootstrap;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.model.Pet;
import com.github.rakhmedovrs.mypetclinic.model.PetType;
import com.github.rakhmedovrs.mypetclinic.model.Vet;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import com.github.rakhmedovrs.mypetclinic.services.PetTypeService;
import com.github.rakhmedovrs.mypetclinic.services.VetService;
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

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService)
	{
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args)
	{
		PetType dog = petTypeService.save(new PetType("Dog"));
		PetType cat = petTypeService.save(new PetType("Cat"));
		System.out.println("PetTypes are loaded");

		Owner ivan = ownerService.save(
			new Owner("Ivan", "Ivanov", "ul. Lenina d.1", "Moscow", "111111111")
		);

		Owner petr = ownerService.save(
			new Owner("Petr", "Petrov", "ul. Lenina d.2", "Moscow", "222222222")
		);

		System.out.println("Owners are loaded");

		Pet ivanDog = new Pet("Muhtar", dog, ivan, LocalDate.now().minusYears(1));
		ivan.getPets().add(ivanDog);

		Pet petrCat = new Pet("Myau", cat, petr, LocalDate.now().minusYears(2));
		petr.getPets().add(petrCat);

		Vet vet1 = new Vet();
		vet1.setFirstName("Kozel");
		vet1.setLastName("Kozlov");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Volk");
		vet2.setLastName("Volkov");
		vetService.save(vet2);

		System.out.println("Vets are loaded");
	}
}
