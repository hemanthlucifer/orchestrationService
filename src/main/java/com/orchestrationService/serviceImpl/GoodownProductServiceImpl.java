package com.orchestrationService.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orchestrationService.dto.GoodownProductDTO;

import com.orchestrationService.feign.LogisticsInterface;
import com.orchestrationService.service.GoodownProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GoodownProductServiceImpl implements GoodownProductService {
	
	private LogisticsInterface goodownInterface;

	@Override
	public List<GoodownProductDTO> getAllProductsInCategoryInGoodown(String goodownId, String categoryId) {
		List<GoodownProductDTO> products = goodownInterface.getAllProductsInCategoryInGoodown(goodownId, categoryId).getBody();
		return products;
	}
	
	

}
