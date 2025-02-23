package com.ecommerce.delivery.repository;

import com.ecommerce.delivery.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
