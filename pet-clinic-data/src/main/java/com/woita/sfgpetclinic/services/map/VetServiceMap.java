package com.woita.sfgpetclinic.services.map;

import com.woita.sfgpetclinic.model.Speciality;
import com.woita.sfgpetclinic.model.Vet;
import com.woita.sfgpetclinic.services.SpecialityService;
import com.woita.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author mcbrydr on 16/08/19
 */
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if (vet != null) {
            if (vet.getSpecialities().size() > 0) {
                vet.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(vet);

        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
