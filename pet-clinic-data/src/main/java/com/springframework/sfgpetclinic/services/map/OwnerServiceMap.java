package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Owner;
import com.springframework.sfgpetclinic.services.OwnerService;
import com.springframework.sfgpetclinic.services.PetService;
import com.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Nidhal on 01/06/2019.
 */
@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService/*CrudService<Owner, Long>*/ {


    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet ->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() ==  null){
                             pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                            throw new RuntimeException("Pet Type is Required");
                    }

                    if(pet.getId() == null){
                        pet.setId(petService.save(pet).getId());
                    }

                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
       super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {

        /*for (Owner owner:this.findAll()) {
            System.out.println(owner.getId());
            if(owner.getLastName().equalsIgnoreCase(lastName))
                return owner;
        }
        return null;*/

        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName()!=null && owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
