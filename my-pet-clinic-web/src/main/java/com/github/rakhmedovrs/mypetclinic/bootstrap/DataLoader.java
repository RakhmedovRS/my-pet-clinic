package com.github.rakhmedovrs.mypetclinic.bootstrap;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import com.github.rakhmedovrs.mypetclinic.model.Vet;
import com.github.rakhmedovrs.mypetclinic.services.OwnerService;
import com.github.rakhmedovrs.mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@Component
public class DataLoader implements CommandLineRunner
{
	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService)
	{
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args)
	{
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Ivan");
		owner1.setFirstName("Ivanov");
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Petr");
		owner1.setFirstName("Petrov");
		ownerService.save(owner2);

		System.out.println("Owners are loaded");

		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Kozel");
		vet1.setFirstName("Kozlov");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Volk");
		vet2.setFirstName("Volkov");
		vetService.save(vet2);

		System.out.println("Vets are loaded");
	}
}
