package com.springframework.sfgpetclinic.repositories;

import com.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nidhal on 08/06/2019.
 */
public interface VetRepository extends CrudRepository<Vet, Long> {
}
