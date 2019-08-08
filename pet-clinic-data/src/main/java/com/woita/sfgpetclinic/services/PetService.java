package com.woita.sfgpetclinic.services;

import com.woita.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * @author mcbrydr on 08/08/19
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
