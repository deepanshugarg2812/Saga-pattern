package com.orders.OrderService.command.controller;

import com.orders.OrderService.dto.command.OrderCommand;
import com.orders.OrderService.dto.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private CommandGateway commandGateway;

    public OrderController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(value = "/placeorder")
    public String addProduct(@RequestBody OrderRequest orderRequest) {
    OrderCommand orderCommand =
        OrderCommand.builder()
            .orderId(UUID.randomUUID().toString())
            .itemName(orderRequest.getItemName())
            .users(orderRequest.getUsers()).address(orderRequest.getAddress())
            .build();
    log.info("Command created and going to publish");
        String result = commandGateway.sendAndWait(orderCommand);
        return result;
    }
}
