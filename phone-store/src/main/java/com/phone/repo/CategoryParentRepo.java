package com.phone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phone.entity.CategoryParent;

@Repository
public interface CategoryParentRepo extends JpaRepository<CategoryParent, Long> {
	@Query("SELECT cp FROM CategoryParent cp WHERE cp.isActive = ?1")
	List<CategoryParent> findAllByIsActive(Boolean isActive);
}
