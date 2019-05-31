package com.springframework.sfgpetclinic.services;

import com.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * Created by Nidhal on 31/05/2019.
 */
public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
