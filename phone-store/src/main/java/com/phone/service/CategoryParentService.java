package com.phone.service;

import java.util.List;

import com.phone.entity.CategoryParent;
import com.phone.service.base.BaseService;

public interface CategoryParentService extends BaseService<CategoryParent>{
	List<CategoryParent> getAllByIsActive();
}
