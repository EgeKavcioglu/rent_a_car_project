package com.example.demo.services.concretes;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.abstracts.OrderService;
import com.example.demo.services.dtos.requests.order.AddOrderRequest;
import com.example.demo.services.dtos.requests.order.UpdateOrderRequest;
import com.example.demo.services.dtos.responses.order.GetOrderListResponse;
import com.example.demo.services.dtos.responses.order.GetOrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;
    private List<GetOrderListResponse> getOrderListResponse;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();

    }

    @Override
    public GetOrderResponse getById(int id) {
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
        order.setStartdate(updateOrderRequest.getStartdate());
        order.setEnddate(updateOrderRequest.getEnddate());
        order.setTotalprice(updateOrderRequest.getTotalprice());

        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public List<GetOrderListResponse> findByStartDateBetween(LocalDate date1, LocalDate date2) {
        return orderRepository.findByStartDateBetween(date1, date2);
    }

    @Override
    public List<GetOrderListResponse> findByAmountLessThanEqual(double amount) {
            List<Order> orderList = orderRepository.findByAmountLessThanEqual(amount);
            List<GetOrderListResponse> getOrderListResponses = new ArrayList<>();
            for (Order order : orderList) {
                GetOrderListResponse response = new GetOrderListResponse();
                response.setStartdate(order.getStartdate());
                response.setEnddate(order.getEnddate());
                response.setTotalprice(order.getTotalprice());
                getOrderListResponses.add(response);
            }
            return getOrderListResponse;
        }

    }
}

