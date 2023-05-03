package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
