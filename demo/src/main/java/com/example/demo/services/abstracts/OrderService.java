package com.example.demo.services.abstracts;

import com.example.demo.entities.Order;
import com.example.demo.services.dtos.requests.order.AddOrderRequest;
import com.example.demo.services.dtos.requests.order.UpdateOrderRequest;
import com.example.demo.services.dtos.responses.order.GetOrderListResponse;
import com.example.demo.services.dtos.responses.order.GetOrderResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
public interface OrderService {


    List<Order> getAll();

    GetOrderResponse getById(int id);

    void addOrder(AddOrderRequest addOrderRequest);

    void updateOrder(@PathVariable int id, UpdateOrderRequest updateOrderRequest);

    void deleteOrder(int id);

    List<GetOrderListResponse> findByStartDateBetween(LocalDate date1, LocalDate date2);

    List<GetOrderListResponse> findByAmountLessThanEqual(double amount);
}

