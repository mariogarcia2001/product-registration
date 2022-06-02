package com.product.registration.productregistration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.registration.productregistration.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    public List<Product> findByName(String criteria);
}
