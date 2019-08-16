package com.woita.sfgpetclinic.services.map;

import com.woita.sfgpetclinic.model.Vet;
import com.woita.sfgpetclinic.services.CrudService;

import java.util.Set;

/**
 * @author mcbrydr on 16/08/19
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}