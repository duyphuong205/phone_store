package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.entity.Role;
import com.phone.repo.RoleRepo;
import com.phone.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class RoleServiceImpl implements RoleService {

	private final RoleRepo roleRepo;

	@Override
	public List<Role> getAll() {
		return roleRepo.findAll();
	}

	@Override
	public Role findById(Long id) {
		Optional<Role> role = roleRepo.findById(id);
		return role.isPresent() ? role.get() : null;
	}

	@Override
	public Role create(Role entity) {
		return roleRepo.save(entity);
	}

	@Override
	public Role update(Role entity) {
		return roleRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		roleRepo.deleteById(id);
	}

}
