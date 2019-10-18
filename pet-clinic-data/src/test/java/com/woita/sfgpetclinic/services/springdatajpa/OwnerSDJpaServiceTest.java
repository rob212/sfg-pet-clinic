package com.woita.sfgpetclinic.services.springdatajpa;

import com.woita.sfgpetclinic.model.Owner;
import com.woita.sfgpetclinic.repositories.OwnerRepository;
import com.woita.sfgpetclinic.repositories.PetRepository;
import com.woita.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author mcbrydr on 17/10/19
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    private Long ownerId = 1L;
    private Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(ownerId).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(LAST_NAME);
    }

    @Test
    void findAll() {
        Owner gary = Owner.builder().id(1L).firstName("Gary").build();
        Owner sarah = Owner.builder().id(2L).firstName("Sarah").build();
        Set<Owner> owners = new HashSet<>();
        owners.add(gary);
        owners.add(sarah);

        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> actualOwners = service.findAll();

        assertEquals(2, actualOwners.size());
        assertTrue(actualOwners.contains(gary));
        assertTrue(actualOwners.contains(sarah));
        verify(ownerRepository).findAll();

    }

    @Test
    void findByIdWhenOwnerDoesNotExist() {
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.empty());

        Owner owner = service.findById(ownerId);

        assertNull(owner);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(ownerId);

        assertEquals(returnOwner, owner);
        verify(ownerRepository).findById(ownerId);
    }


    @Test
    void save() {
        service.save(returnOwner);

        verify(ownerRepository).save(returnOwner);
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        verify(ownerRepository).delete(returnOwner);
    }

    @Test
    void deleteById() {
        service.deleteById(ownerId);

        verify(ownerRepository).deleteById(ownerId);
    }
}