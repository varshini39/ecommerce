package com.ecommerce.delivery.repository;

import com.ecommerce.delivery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
