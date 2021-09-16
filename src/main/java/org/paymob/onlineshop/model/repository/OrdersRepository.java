package org.paymob.onlineshop.model.repository;

import org.paymob.onlineshop.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
