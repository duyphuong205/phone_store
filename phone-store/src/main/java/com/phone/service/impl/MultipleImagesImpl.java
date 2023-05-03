package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.entity.MultipleImages;
import com.phone.repo.MultipleImagesRepo;
import com.phone.service.MultipleImagesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class MultipleImagesImpl implements MultipleImagesService {

	private final MultipleImagesRepo multipleImagesRepo;

	@Override
	public List<MultipleImages> getAll() {
		return multipleImagesRepo.findAll();
	}

	@Override
	public MultipleImages findById(Long id) {
		Optional<MultipleImages> multipleImages = multipleImagesRepo.findById(id);
		return multipleImages.isPresent() ? multipleImages.get() : null;
	}

	@Override
	public MultipleImages create(MultipleImages entity) {
		return multipleImagesRepo.save(entity);
	}

	@Override
	public MultipleImages update(MultipleImages entity) {
		return multipleImagesRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		multipleImagesRepo.deleteById(id);

	}

}
