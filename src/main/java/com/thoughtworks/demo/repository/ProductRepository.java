package com.thoughtworks.demo.repository;

import com.thoughtworks.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
