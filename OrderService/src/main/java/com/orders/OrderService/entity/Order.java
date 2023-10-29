package com.orders.OrderService.entity;

import javax.persistence.Id;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    private String orderId;
    private String itemName;
    private String users;
    private String address;
}
