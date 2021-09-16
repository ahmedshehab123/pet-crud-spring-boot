package org.paymob.onlineshop.controller;

import org.paymob.onlineshop.exceptions.PetExceptions;
import org.paymob.onlineshop.model.entity.Orders;
import org.paymob.onlineshop.model.entity.Pet;
import org.paymob.onlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/order")
    public ResponseEntity<?> saveOrder(@RequestBody Orders order){
        try {
            return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/order/{pageNum}/{pageSize}")
    public ResponseEntity<?> getOrdersList(@PathVariable int  pageNum,@PathVariable int  pageSize){
        try {
            return new ResponseEntity<>(orderService.getListOfOrders(pageNum,pageSize), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<?> getOrderId(@PathVariable Long  petId){
        try {
            return new ResponseEntity<>(orderService.getOrderById(petId), HttpStatus.OK);
        }catch (PetExceptions e){
            return new ResponseEntity<>(e.getErrorMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
