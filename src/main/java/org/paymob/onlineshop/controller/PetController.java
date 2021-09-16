package org.paymob.onlineshop.controller;

import org.paymob.onlineshop.exceptions.PetExceptions;
import org.paymob.onlineshop.model.entity.Pet;
import org.paymob.onlineshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class PetController {
    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "/pet")
    public ResponseEntity<?> savePet(@RequestBody Pet pet){
        try {
            return new ResponseEntity<>(petService.savePet(pet), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/pet/{petId}")
    public ResponseEntity<?> getPetBuId(@PathVariable Long  petId){
        try {
            return new ResponseEntity<>(petService.getPetById(petId), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/pet/{pageNum}/{pageSize}")
    public ResponseEntity<?> getPetsPagenated(@PathVariable int  pageNum,@PathVariable int  pageSize){
        try {
            return new ResponseEntity<>(petService.listPets(pageNum,pageSize), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping (value = "/pet/{petId}")
    public ResponseEntity<?> deletePetBuId(@PathVariable Long  petId){
        try {
            return new ResponseEntity<>(petService.delete(petId), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
