package com.woita.sfgpetclinic.repositories;

import com.woita.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mcbrydr on 17/09/19
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
