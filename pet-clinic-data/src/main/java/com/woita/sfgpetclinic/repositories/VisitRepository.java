package com.woita.sfgpetclinic.repositories;

import com.woita.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author mcbrydr on 17/09/19
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
