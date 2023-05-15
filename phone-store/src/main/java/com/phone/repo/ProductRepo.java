package com.phone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phone.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.isActive = ?1")
	List<Product> findAllByIsActive(Boolean isActive);
}
