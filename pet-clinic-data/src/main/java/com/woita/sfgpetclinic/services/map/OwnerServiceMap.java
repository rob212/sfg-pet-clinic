package com.woita.sfgpetclinic.services.map;

import com.woita.sfgpetclinic.model.Owner;
import com.woita.sfgpetclinic.services.CrudService;

import java.util.Set;

/**
 * @author mcbrydr on 16/08/19
 */
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
