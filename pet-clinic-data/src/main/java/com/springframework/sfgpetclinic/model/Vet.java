package com.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nidhal on 26/05/2019.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",joinColumns = @JoinColumn(name = "vet_id"),
              inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        if (this.specialities == null) {
            this.specialities = new HashSet<>();
        }
        return this.specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public String toString() {

         String specialityALL = "";

        for (Speciality speciality : specialities ) {
            specialityALL += speciality.toString() + " - ";

        }
        return "Vet{" + super.toString()+
                "specialities=" + specialityALL +
                '}';
    }
}
