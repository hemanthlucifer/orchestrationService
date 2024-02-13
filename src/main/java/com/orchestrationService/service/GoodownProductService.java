package com.orchestrationService.service;

import java.util.List;

import com.orchestrationService.dto.GoodownProductDTO;

public interface GoodownProductService {
	
	public List<GoodownProductDTO> getAllProductsInCategoryInGoodown(String goodownId, String categoryId);

}
