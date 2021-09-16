package org.paymob.onlineshop.service;

import org.paymob.onlineshop.dto.ResponseModel;
import org.paymob.onlineshop.exceptions.ErrorCodes;
import org.paymob.onlineshop.exceptions.PetExceptions;
import org.paymob.onlineshop.model.entity.Pet;
import org.paymob.onlineshop.model.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet savePet(Pet pet) {
        if (pet.getPetType() == null)
            throw new PetExceptions(ErrorCodes.PetType.Missing_Pet_type);
        return petRepository.save(pet);
    }

    public Pet getPetById(Long petId) {
        Optional<Pet> pet = petRepository.findById(petId);
        return pet.orElse(null);
    }

    public ResponseModel listPets(int pageNum, int pageSize) {
        Page<Pet> pets = petRepository.findAll(PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "petId"));
        return new ResponseModel(pets.getTotalElements(), pets.getContent());
    }

    public boolean delete(Long petId) {
        Optional<Pet> pet = petRepository.findById(petId);
        if (pet.isEmpty())
            throw new PetExceptions(ErrorCodes.Pet.Pet_Not_exist);
        try {
            petRepository.delete(pet.get());
        } catch (Exception e) {
            throw new PetExceptions(ErrorCodes.Pet.FAILED_TO_DELETE);
        }
        return true;
    }
}
