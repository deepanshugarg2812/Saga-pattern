package com.orders.OrderService.query.controller;

import com.orders.OrderService.entity.Order;
import com.orders.OrderService.query.queries.GetOrderQueries;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class QueryOrders {
    private final QueryGateway queryGateway;

    @GetMapping("/getall")
    public List<Order> findAll(){
        GetOrderQueries getOrderQueries = new GetOrderQueries();
        return queryGateway.query(getOrderQueries, ResponseTypes.multipleInstancesOf(Order.class)).join();
    }
}
