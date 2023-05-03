package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.entity.CategoryParent;
import com.phone.repo.CategoryParentRepo;
import com.phone.service.CategoryParentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class CategoryParentImpl implements CategoryParentService {

	private final CategoryParentRepo categoryParentRepo;

	@Override
	public List<CategoryParent> getAll() {
		return categoryParentRepo.findAll();
	}

	@Override
	public CategoryParent findById(Long id) {
		Optional<CategoryParent> categoryParent = categoryParentRepo.findById(id);
		return categoryParent.isPresent() ? categoryParent.get() : null;
	}

	@Override
	public CategoryParent create(CategoryParent entity) {
		return categoryParentRepo.save(entity);
	}

	@Override
	public CategoryParent update(CategoryParent entity) {
		return categoryParentRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		categoryParentRepo.deleteById(id);

	}

}
