package com.phone.utils;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phone.entity.Category;
import com.phone.entity.CategoryParent;
import com.phone.service.CategoryParentService;
import com.phone.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service("GlobalData")
@RequiredArgsConstructor
public class GlobalDataUtil {
	private final CategoryParentService categoryParentService;
	
	private final CategoryService categoryService;

	public List<CategoryParent> getCategoryParents() {
		return categoryParentService.getAllByIsActive().isEmpty() ? null : categoryParentService.getAllByIsActive();
	}
	
	public List<Category> getCategories() {
		return categoryService.getAllByIsActive().isEmpty() ? null : categoryService.getAllByIsActive();
	}
}
