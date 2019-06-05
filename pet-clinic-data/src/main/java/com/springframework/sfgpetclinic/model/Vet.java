package com.springframework.sfgpetclinic.model;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Created by Nidhal on 26/05/2019.
 */
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vet_specialities",joinColumns = @JoinColumn(name = "vet_id"),
              inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Vet> specialities;

    public Set<Vet> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Vet> specialities) {
        this.specialities = specialities;
    }
}
