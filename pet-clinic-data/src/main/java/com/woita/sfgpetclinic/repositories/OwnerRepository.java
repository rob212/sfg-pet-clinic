package com.woita.sfgpetclinic.repositories;

import com.woita.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mcbrydr on 17/09/19
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
