package com.woita.sfgpetclinic.services;

import com.woita.sfgpetclinic.model.Owner;

/**
 * @author mcbrydr on 08/08/19
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
