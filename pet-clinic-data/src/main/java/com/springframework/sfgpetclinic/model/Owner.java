package com.springframework.sfgpetclinic.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nidhal on 26/05/2019.
 */
@Entity
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

    public Set<Pet> getPets() {
        if(pets == null){
            pets = new HashSet<>();
        }
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {

        String petAll = "";
        for ( Pet pet: pets ) {
            petAll+=pet.getName() +" - ";
        }
        return "Owner{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pets= " + petAll +
                '}';
    }
}
