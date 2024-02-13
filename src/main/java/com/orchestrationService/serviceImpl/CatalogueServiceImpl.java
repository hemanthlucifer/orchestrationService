package com.orchestrationService.serviceImpl;

import org.springframework.stereotype.Service;

import com.orchestrationService.dto.GetProductDTO;
import com.orchestrationService.feign.CatalogueInterface;
import com.orchestrationService.service.CatalogueService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogueServiceImpl implements CatalogueService {
	
	
	private CatalogueInterface catalogueInterface;

	@Override
	public GetProductDTO getProductById(String productID) {
		GetProductDTO product = catalogueInterface.getProductById(productID).getBody();
		return product;
	}

}
