package com.springframework.sfgpetclinic.services;

import com.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

/**
 * Created by Nidhal on 31/05/2019.
 */
public interface OwnerService  {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
