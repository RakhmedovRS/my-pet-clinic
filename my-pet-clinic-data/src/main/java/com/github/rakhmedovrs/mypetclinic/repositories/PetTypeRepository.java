package com.github.rakhmedovrs.mypetclinic.repositories;

import com.github.rakhmedovrs.mypetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long>
{
}
