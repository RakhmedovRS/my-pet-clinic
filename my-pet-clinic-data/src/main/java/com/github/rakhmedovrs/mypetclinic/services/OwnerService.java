package com.github.rakhmedovrs.mypetclinic.services;

import com.github.rakhmedovrs.mypetclinic.model.Owner;

/**
 * @author RakhmedovRS
 * @created 04-May-20
 */
public interface OwnerService extends CRUDService<Owner, Long>
{
	Owner findByLastName(String lastName);
}
