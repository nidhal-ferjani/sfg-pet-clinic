package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.services.VetService;

import java.util.Set;

/**
 * Created by Nidhal on 01/06/2019.
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService/*CrudService<Vet, Long>*/ {


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
       super.deleteById(id);
    }
}
