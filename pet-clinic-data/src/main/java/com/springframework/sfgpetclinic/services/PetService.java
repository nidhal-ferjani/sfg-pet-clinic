package com.springframework.sfgpetclinic.services;

import com.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

/**
 * Created by Nidhal on 31/05/2019.
 */
public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
