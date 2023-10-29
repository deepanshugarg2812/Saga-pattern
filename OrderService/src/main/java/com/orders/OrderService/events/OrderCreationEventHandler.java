package com.orders.OrderService.events;

import com.orders.OrderService.dto.event.OrderEvent;
import com.orders.OrderService.entity.Order;
import com.orders.OrderService.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreationEventHandler {
  private final OrderRepository orderRepository;

  @EventHandler
  public void on(OrderEvent orderEvent) {
    try {
      Order order = new Order();
      BeanUtils.copyProperties(orderEvent, order);
      orderRepository.save(order);
    } catch (Exception e) {
      log.info("error occured for {}", orderEvent);
    }
  }
}
