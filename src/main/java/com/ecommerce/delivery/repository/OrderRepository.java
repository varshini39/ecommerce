package com.ecommerce.delivery.repository;

import com.ecommerce.delivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
