package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.entity.MultipleImage;
import com.phone.repo.MultipleImageRepo;
import com.phone.service.MultipleImageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class MultipleImageServiceImpl implements MultipleImageService {

	private final MultipleImageRepo multipleImagesRepo;

	@Override
	public List<MultipleImage> getAll() {
		return multipleImagesRepo.findAll();
	}

	@Override
	public MultipleImage findById(Long id) {
		Optional<MultipleImage> multipleImages = multipleImagesRepo.findById(id);
		return multipleImages.isPresent() ? multipleImages.get() : null;
	}

	@Override
	public MultipleImage create(MultipleImage entity) {
		return multipleImagesRepo.save(entity);
	}

	@Override
	public MultipleImage update(MultipleImage entity) {
		return multipleImagesRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		multipleImagesRepo.deleteById(id);

	}

}
