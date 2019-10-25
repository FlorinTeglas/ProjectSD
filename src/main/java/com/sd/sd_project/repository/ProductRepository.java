package com.sd.sd_project.repository;

import com.sd.sd_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
