package com.orchestrationService.service;

import com.orchestrationService.dto.GetProductDTO;

public interface CatalogueService {
	
	public GetProductDTO getProductById(String productID);

}
