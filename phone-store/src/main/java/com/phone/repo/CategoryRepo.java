package com.phone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phone.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
	@Query("SELECT c FROM Category c WHERE c.isActive = ?1")
	List<Category> findAllByIsActive(Boolean isActive);
}
