package com.orders.OrderService.dto.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@ToString
@Builder
public class OrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String itemName;
    private String users;
    private String address;
}
