package com.orchestrationService.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchestrationService.dto.CategoryDTO;

import com.orchestrationService.feign.LogisticsInterface;
import com.orchestrationService.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	LogisticsInterface categoryInterface;

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		CategoryDTO category = categoryInterface.createCategory(categoryDTO).getBody();
		return category;
	}

	@Override
	public List<CategoryDTO> getAllCategoriesInGoodown(String goodownId) {
		try {
		List<CategoryDTO> allCategories = categoryInterface.getAllCategoriesInGoodown(goodownId).getBody();
		return allCategories;
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			return new ArrayList<>();
		}
		
	}
	
	

}
