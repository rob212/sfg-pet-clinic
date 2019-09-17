package com.woita.sfgpetclinic.services.map;

import com.woita.sfgpetclinic.model.Visit;
import com.woita.sfgpetclinic.services.springdatajpa.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author mcbrydr on 17/09/19
 */
@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
