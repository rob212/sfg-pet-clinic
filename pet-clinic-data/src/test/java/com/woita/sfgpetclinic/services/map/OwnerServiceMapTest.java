package com.woita.sfgpetclinic.services.map;

import com.woita.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mcbrydr on 11/10/19
 */
class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
        assertEquals(new Long(1L), owners.iterator().next().getId());
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByLastName() {
    }
}