package com.example.demo.repositories;

import com.example.demo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.services.dtos.responses.order.GetOrderListResponse;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByAmountLessThanEqual (double date);
    @Query("select new com.example.demo.services.dtos.responses.order.GetOrderListResponse" +
            "(o.startdate, o.enddate, o.totalprice) " +
            "from Order o where o.startDate between :date1 AND :date2")
    List<GetOrderListResponse> findByStartDateBetween(LocalDate date1, LocalDate date2);
}
