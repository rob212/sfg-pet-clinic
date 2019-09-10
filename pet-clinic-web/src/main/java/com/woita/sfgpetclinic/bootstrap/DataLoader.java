package com.woita.sfgpetclinic.bootstrap;

import com.woita.sfgpetclinic.model.Owner;
import com.woita.sfgpetclinic.model.Pet;
import com.woita.sfgpetclinic.model.PetType;
import com.woita.sfgpetclinic.model.Vet;
import com.woita.sfgpetclinic.services.OwnerService;
import com.woita.sfgpetclinic.services.PetTypeService;
import com.woita.sfgpetclinic.services.VetService;
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

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("10 Main Street");
        owner1.setCity("London");
        owner1.setTelephone("0123456789");

        Pet mikesDog = new Pet();
        mikesDog.setPetType(savedDogPetType);
        mikesDog.setOwner(owner1);
        mikesDog.setName("Spot");
        mikesDog.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("14 Twisty Lane");
        owner2.setCity("Paris");
        owner2.setTelephone("0987654321");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setName("Luna");
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dave");
        vet2.setLastName("Kidmond");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
