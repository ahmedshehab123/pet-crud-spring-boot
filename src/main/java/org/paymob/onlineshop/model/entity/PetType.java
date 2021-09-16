package org.paymob.onlineshop.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PET_TYPE")
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_type_id")
    private Long petTypeId;
    @Column(name = "pet_type_name")
    private String petTypeName;

    @OneToMany(mappedBy = "petType")
    @JsonIgnore
    private List<Pet> pets;

    public Long getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Long petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
