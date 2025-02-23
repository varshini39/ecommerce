package com.ecommerce.delivery.dto;

public record OrderItemDTO(Long id, Long orderId, Long productId, Integer quantity, Double priceAtPurchase) {}

