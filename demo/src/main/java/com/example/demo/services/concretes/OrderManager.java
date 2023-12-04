package com.example.demo.services.concretes;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.abstracts.OrderService;
import com.example.demo.services.dtos.requests.order.AddOrderRequest;
import com.example.demo.services.dtos.requests.order.UpdateOrderRequest;
import com.example.demo.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();

    }

    @Override
    public GetOrderResponse getById(int id){
            Order order = orderRepository.findById(id).orElseThrow();

            GetOrderResponse dto = new GetOrderResponse();
            dto.setStartdate(order.getStartdate());
            dto.setEnddate(order.getEnddate());
            dto.setTotalprice(order.getTotalprice());

            return dto;
    }

    @Override
    public void addOrder(AddOrderRequest addOrderRequest) {
        Order order = new Order();

        //order.setCarid(addOrderRequest.getCarid());
        //order.setCustomerid(addOrderRequest.getCustomerid());
        order.setStartdate(addOrderRequest.getStartdate());
        order.setEnddate(addOrderRequest.getEnddate());
        order.setTotalprice(addOrderRequest.getTotalprice());

        orderRepository.save(order);
    }

    @Override
    public void updateOrder(@PathVariable int id, UpdateOrderRequest updateOrderRequest) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + updateOrderRequest.getId()));

        //order.setCarid(updateOrderRequest.getCarid());
        //order.setCustomerid(updateOrderRequest.getCustomerid());
        order.setStartdate(updateOrderRequest.getStartdate());
        order.setEnddate(updateOrderRequest.getEnddate());
        order.setTotalprice(updateOrderRequest.getTotalprice());

        orderRepository.save(order);
    }

     @Override
     public void deleteOrder(int id){
         this.orderRepository.deleteById(id);
        }

    }

