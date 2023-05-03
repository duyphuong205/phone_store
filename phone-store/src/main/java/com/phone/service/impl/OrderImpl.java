package com.phone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phone.entity.Order;
import com.phone.repo.OrderRepo;
import com.phone.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class OrderImpl implements OrderService {

	private final OrderRepo orderRepo;

	@Override
	public List<Order> getAll() {
		return orderRepo.findAll();
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> order = orderRepo.findById(id);
		return order.isPresent() ? order.get() : null;
	}

	@Override
	public Order create(Order entity) {
		return orderRepo.save(entity);
	}

	@Override
	public Order update(Order entity) {
		return orderRepo.save(entity);
	}

	@Override
	public void delete(Long id) {
		orderRepo.deleteById(id);

	}

}
