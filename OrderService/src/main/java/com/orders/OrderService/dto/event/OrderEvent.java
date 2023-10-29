package com.orders.OrderService.dto.event;

import lombok.Data;

@Data
public class OrderEvent {
    private String orderId;
    private String itemName;
    private String users;
    private String address;
}
