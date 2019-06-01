package com.springframework.sfgpetclinic.services;

import com.springframework.sfgpetclinic.model.Owner;

/**
 * Created by Nidhal on 31/05/2019.
 */
public interface OwnerService extends CrudService<Owner,Long>  {

    Owner findByLastName(String lastName);

}
