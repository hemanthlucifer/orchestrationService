package com.orchestrationService.service;

import java.util.List;

import com.orchestrationService.dto.CategoryDTO;

public interface CategoryService {
	
	public CategoryDTO createCategory(CategoryDTO categoryDTO);
	public List<CategoryDTO> getAllCategoriesInGoodown(String goodownId);


}
