package org.paymob.onlineshop.model.repository;

import org.paymob.onlineshop.model.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
