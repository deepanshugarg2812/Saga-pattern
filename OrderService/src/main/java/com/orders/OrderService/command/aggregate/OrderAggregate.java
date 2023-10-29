package com.orders.OrderService.command.aggregate;

import com.orders.OrderService.dto.command.OrderCommand;
import com.orders.OrderService.dto.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Slf4j
@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private String itemName;
    private String users;
    private String address;

    public OrderAggregate(){}

    @CommandHandler
    public OrderAggregate(OrderCommand orderCommand) {
        log.info("Command recieved {}", orderCommand);
        OrderEvent orderEvent = new OrderEvent();
        BeanUtils.copyProperties(orderCommand, orderEvent);
        AggregateLifecycle.apply(orderEvent);
    }

    @EventSourcingHandler
    public void on(OrderEvent orderEvent) {
        this.orderId = orderEvent.getOrderId();
        this.address = orderEvent.getAddress();
        this.itemName = orderEvent.getItemName();
        this.users = orderEvent.getUsers();
        log.info("Details filled and going to publish {}", orderEvent);
    }
}
