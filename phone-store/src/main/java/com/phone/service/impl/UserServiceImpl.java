package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.constants.RoleConstant;
import com.phone.entity.Role;
import com.phone.entity.User;
import com.phone.entity.UserRole;
import com.phone.repo.RoleRepo;
import com.phone.repo.UserRepo;
import com.phone.repo.UserRoleRepo;
import com.phone.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	private final RoleRepo roleRepo;

	private final UserRoleRepo userRoleRepo;
	
	private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	@Override
	public User create(User entity) {
		return userRepo.save(entity);
	}

	@Override
	public User update(User entity) {
		return userRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public User register(User user) {
		try {
			user.setPassword(encoder.encode(user.getPassword()));
			userRepo.save(user);
			Role role = roleRepo.findByName(RoleConstant.ROLE_CUSTOMER);
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			userRoleRepo.save(userRole);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}

	@Override
	public User getByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User getByEmail(String email) {
		return userRepo.findByEmail(email);
	}
}
