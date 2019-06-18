package com.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nidhal on 26/05/2019.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Table(name = "owners")
public class Owner extends Person{

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets ;

    @Builder
    public Owner(Long id, String firstName, String lastName,String address, String city, @Digits(fraction = 0, integer = 10) String telephone, Set<Pet> pets) {
        super(id,firstName,lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        if(pets == null){
            pets = new HashSet<>();
        }
        return pets;
    }
}
