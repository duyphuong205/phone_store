package com.phone.service;

import java.util.List;

import com.phone.entity.Product;
import com.phone.service.base.BaseService;

public interface ProductService extends BaseService<Product> {
	List<Product> getAllByIsActive();
}
