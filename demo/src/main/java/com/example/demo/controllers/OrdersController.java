package com.example.demo.controllers;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.abstracts.OrderService;
import com.example.demo.services.dtos.requests.order.AddOrderRequest;
import com.example.demo.services.dtos.requests.order.UpdateOrderRequest;
import com.example.demo.services.dtos.responses.order.GetOrderResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

        @GetMapping("{id}")
        public GetOrderResponse getById (@PathVariable int id){
            return orderService.getById(id);
        }

        @PostMapping
        public void addOrder(@RequestBody AddOrderRequest addOrderRequest){
            orderService.addOrder(addOrderRequest);
        }

        @PutMapping("{id}")
        public void updateOrder(@PathVariable int id, @RequestBody UpdateOrderRequest updateOrderRequest){
            orderService.updateOrder(id, updateOrderRequest);
        }

        @DeleteMapping("{id}")
        public void deleteOrder( @PathVariable int id){
            orderService.deleteOrder(id);
        }

    }



