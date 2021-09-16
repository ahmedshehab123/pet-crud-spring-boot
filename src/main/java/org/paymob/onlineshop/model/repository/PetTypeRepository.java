package org.paymob.onlineshop.model.repository;

import org.paymob.onlineshop.model.entity.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType,Long> {
}
