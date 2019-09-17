package com.woita.sfgpetclinic.repositories;

import com.woita.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mcbrydr on 17/09/19
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
