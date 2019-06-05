package com.springframework.sfgpetclinic.bootstrap;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.model.Pet;
import com.springframework.sfgpetclinic.model.PetType;
import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.services.OwnerService;
import com.springframework.sfgpetclinic.services.PetTypeService;
import com.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Nidhal on 02/06/2019.
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
    public void run(String... args) throws Exception {

        //###########################################################

        PetType dog = new PetType();
        dog.setName("dog");

        PetType savedDogPetType = petTypeService.save(dog);
        System.out.println("Dog Saved : " + savedDogPetType );

        PetType cat = new PetType();
        dog.setName("cat");

        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Cat Saved : " +savedCatPetType );

        System.out.println("Loaded PetTypes ....");


        //###########################################################

        Owner owner1 = new Owner();
        owner1.setFirstName("Nidhal");
        owner1.setLastName("Ferjani");
        owner1.setAddress("12 rue liberta USA");
        owner1.setCity("Manar");
        owner1.setTelephone("55124785");


        Pet pet1 = new Pet();
        pet1.setPetType(savedCatPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");
        owner1.getPets().add(pet1);

        Pet pet11 = new Pet();
        pet11.setPetType(savedCatPetType);
        pet11.setOwner(owner1);
        pet11.setBirthDate(LocalDate.now());
        pet11.setName("New Pacco");
        owner1.getPets().add(pet11);

        System.out.println("Owner1 : " + ownerService.save(owner1));

        Owner owner2 = new Owner();
        owner2.setFirstName("Ahmed");
        owner2.setLastName("Mejri");

        owner2.setAddress("17 rue bravia France");
        owner2.setCity("Enasser");
        owner2.setTelephone("45789632");

        Pet pet2 = new Pet();
        pet2.setPetType(savedDogPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Pasco");
        owner2.getPets().add(pet2);

        System.out.println("Owner2 : " + ownerService.save(owner2));

        System.out.println("Loaded Owners ....");

        //###########################################################
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");



       //###########################################################


    }
}