package com.springframework.sfgpetclinic.model;

/**
 * Created by Nidhal on 05/06/2019.
 */
public class Speciality extends  BaseEntity {

   // @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "description='" + description + '\'' +
                '}';
    }
}
