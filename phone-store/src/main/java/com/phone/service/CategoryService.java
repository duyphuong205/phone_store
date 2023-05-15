package com.phone.service;

import java.util.List;

import com.phone.entity.Category;
import com.phone.service.base.BaseService;

public interface CategoryService extends BaseService<Category> {
	List<Category> getAllByIsActive();
}
