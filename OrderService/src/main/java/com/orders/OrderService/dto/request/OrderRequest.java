package com.orders.OrderService.dto.request;

import lombok.Data;

@Data
public class OrderRequest {
  private String orderId;
  private String itemName;
  private String users;
  private String address;
}
