package com.springframework.sfgpetclinic.repositories;

import com.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nidhal on 08/06/2019.
 */
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
