package com.woita.sfgpetclinic.services;

import com.woita.sfgpetclinic.model.Owner;
import com.woita.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * @author mcbrydr on 08/08/19
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Owner> findAll();
}
