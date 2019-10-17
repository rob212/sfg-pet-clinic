package com.woita.sfgpetclinic.services.map;

import com.woita.sfgpetclinic.model.Owner;
import com.woita.sfgpetclinic.model.Pet;
import com.woita.sfgpetclinic.model.PetType;
import com.woita.sfgpetclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mcbrydr on 11/10/19
 */
class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    private String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
        assertEquals(ownerId, owners.iterator().next().getId());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(1L);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingIdWithoutPets() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoIdWithoutPets() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void saveWithIdAndPetWithoutTypeThrowsException() {
        Long id = 2L;
        Pet spot = Pet.builder().name("Spot").build();
        Set<Pet> pets = new HashSet<>();
        pets.add(spot);
        Owner owner2 = Owner.builder().id(id).pets(pets).build();
        spot.setOwner(owner2);

        assertThrows(RuntimeException.class, () -> {
            ownerServiceMap.save(owner2);
        });
    }

    @Test
    @Disabled
    void saveWithIdAndPet() {
        Long id = 2L;
        Pet spot = Pet.builder().name("Spot").petType(PetType.builder().name("dog").build()).build();
        Set<Pet> pets = new HashSet<>();
        pets.add(spot);
        Owner owner2 = Owner.builder().id(id).pets(pets).build();
        spot.setOwner(owner2);


        ownerServiceMap.save(owner2);
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findByLastNameNotFoundReturnsNull() {
        Owner owner = ownerServiceMap.findByLastName("fake");
        assertNull(owner);
    }
}