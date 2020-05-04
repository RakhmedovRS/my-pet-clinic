package com.github.rakhmedovrs.mypetclinic.services;

import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 04-May-20
 */
public interface BaseService<Entry>
{
	Entry findById(Long id);

	Entry save(Entry entry);

	Set<Entry> findAll();
}
