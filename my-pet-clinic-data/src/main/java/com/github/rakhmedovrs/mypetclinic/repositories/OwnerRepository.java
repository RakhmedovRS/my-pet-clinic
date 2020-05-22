package com.github.rakhmedovrs.mypetclinic.repositories;

import com.github.rakhmedovrs.mypetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
public interface OwnerRepository extends CrudRepository<Owner, Long>
{
	Owner findByLastName(String lastName);
}
