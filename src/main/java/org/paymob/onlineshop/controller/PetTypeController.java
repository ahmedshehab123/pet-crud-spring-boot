package org.paymob.onlineshop.controller;

import org.paymob.onlineshop.exceptions.PetExceptions;
import org.paymob.onlineshop.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PetTypeController {
    private final PetTypeService petTypeService;

    @Autowired
    public PetTypeController(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @GetMapping(value = "/pet/type")
    public ResponseEntity<?> getPetsType(){
        try {
            return new ResponseEntity<>(petTypeService.getPetType(), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
