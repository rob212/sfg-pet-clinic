package com.woita.sfgpetclinic.services;

import com.woita.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * @author mcbrydr on 08/08/19
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
