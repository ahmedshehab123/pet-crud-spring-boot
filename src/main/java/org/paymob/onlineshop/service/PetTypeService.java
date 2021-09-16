package org.paymob.onlineshop.service;

import org.paymob.onlineshop.model.entity.PetType;
import org.paymob.onlineshop.model.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeService {
    private final PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    public List<PetType> getPetType(){
        return petTypeRepository.findAll();
    }
}
