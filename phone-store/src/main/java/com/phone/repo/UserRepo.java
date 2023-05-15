package com.phone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phone.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String user);
	User findByEmail(String Email);
}
