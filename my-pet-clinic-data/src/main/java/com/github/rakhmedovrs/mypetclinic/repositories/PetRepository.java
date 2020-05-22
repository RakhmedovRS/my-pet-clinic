package com.github.rakhmedovrs.mypetclinic.repositories;

import com.github.rakhmedovrs.mypetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
public interface PetRepository extends CrudRepository<Pet, Long>
{
}
