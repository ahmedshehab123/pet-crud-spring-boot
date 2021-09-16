package org.paymob.onlineshop.model.repository;

import org.paymob.onlineshop.model.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
