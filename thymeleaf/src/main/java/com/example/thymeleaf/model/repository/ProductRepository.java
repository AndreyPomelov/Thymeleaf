package com.example.thymeleaf.model.repository;

import com.example.thymeleaf.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}