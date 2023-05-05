package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {

}
