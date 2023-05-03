package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.entity.OrderStatus;
import com.phone.repo.OrderStatusRepo;
import com.phone.service.OrderStatusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class OrderStatusImpl implements OrderStatusService {

	private final OrderStatusRepo orderStatusRepo;

	@Override
	public List<OrderStatus> getAll() {
		return orderStatusRepo.findAll();
	}

	@Override
	public OrderStatus findById(Long id) {
		Optional<OrderStatus> orderStatus = orderStatusRepo.findById(id);
		return orderStatus.isPresent() ? orderStatus.get() : null;
	}

	@Override
	public OrderStatus create(OrderStatus entity) {
		return orderStatusRepo.save(entity);
	}

	@Override
	public OrderStatus update(OrderStatus entity) {
		return orderStatusRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		orderStatusRepo.deleteById(id);

	}

}
