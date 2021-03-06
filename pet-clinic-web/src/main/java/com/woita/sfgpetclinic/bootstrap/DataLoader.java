package com.woita.sfgpetclinic.bootstrap;

import com.woita.sfgpetclinic.model.*;
import com.woita.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author mcbrydr on 29/08/19
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("10 Main Street");
        owner1.setCity("London");
        owner1.setTelephone("0123456789");


        Pet michaelsDog = setupPet(savedDogPetType, owner1, "Spot");

        Visit dogVisit = new Visit();
        dogVisit.setPet(michaelsDog);
        dogVisit.setDescription("Reduced appetite");
        dogVisit.setDate(LocalDate.now());
        visitService.save(dogVisit);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("14 Twisty Lane");
        owner2.setCity("Paris");
        owner2.setTelephone("0987654321");

        setupPet(savedCatPetType, owner2, "Luna");

        System.out.println("Loaded Owners...");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dave");
        vet2.setLastName("Kidmond");
        vet2.getSpecialities().add(savedRadiology);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }

    private Pet setupPet(PetType petType, Owner owner, String name) {
        Pet pet = new Pet();
        pet.setPetType(petType);
        pet.setOwner(owner);
        pet.setName(name);
        pet.setBirthDate(LocalDate.now());
        owner.getPets().add(pet);

        ownerService.save(owner);
        return pet;
    }
}
