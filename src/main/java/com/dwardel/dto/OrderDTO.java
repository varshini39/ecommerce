package com.dwardel.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private Double totalPrice;
    private String status;
    private List<OrderItemDTO> orderItems;
}
