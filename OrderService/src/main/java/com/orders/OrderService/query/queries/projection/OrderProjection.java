package com.orders.OrderService.query.queries.projection;

import com.orders.OrderService.entity.Order;
import com.orders.OrderService.query.queries.GetOrderQueries;
import com.orders.OrderService.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderProjection {
    private final OrderRepository orderRepository;

    @QueryHandler
    public List<Order> findAllOrders(GetOrderQueries getOrderQueries) {
        return orderRepository.findAll();
    }
}
