package com.springframework.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nidhal on 05/06/2019.
 */
@Entity
@Table(name = "specialities")
public class Speciality extends  BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Vet> getVets() {
        if(vets == null){
            vets = new HashSet<>();
        }
        return vets;
    }

    public void setVets(Set<Vet> vets) {
        this.vets = vets;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "description='" + description + '\'' +
                '}';
    }
}
