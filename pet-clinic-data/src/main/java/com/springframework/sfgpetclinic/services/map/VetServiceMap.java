package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.services.SpecialitiesService;
import com.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Nidhal on 01/06/2019.
 */

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService/*CrudService<Vet, Long>*/ {

    private SpecialitiesService specialitiesService;

    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

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
        if(object != null){
            if(object.getSpecialities().size()>0){
               object.getSpecialities().forEach(speciality ->{
                   if(speciality.getId() == null){
                      speciality.setId(specialitiesService.save(speciality).getId());
                   }
               });
            }
            return super.save(object);
        }else{
            return null;
        }

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
