package com.springframework.sfgpetclinic.repositories;

import com.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nidhal on 08/06/2019.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
