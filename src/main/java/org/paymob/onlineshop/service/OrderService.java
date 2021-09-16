package org.paymob.onlineshop.service;

import org.paymob.onlineshop.dto.ResponseModel;
import org.paymob.onlineshop.model.entity.Orders;
import org.paymob.onlineshop.model.entity.Pet;
import org.paymob.onlineshop.model.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrdersRepository ordersRepository;


    @Autowired
    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    public ResponseModel getListOfOrders(int pageNum, int pageSize) {
        Page<Orders> orders = ordersRepository.findAll(PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "orderId"));
        return new ResponseModel(orders.getTotalElements(), orders.getContent());
    }

    public Orders getOrderById(Long orderId){
        return ordersRepository.getById(orderId);
    }
}
