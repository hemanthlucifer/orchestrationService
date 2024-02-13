package com.orchestrationService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orchestrationService.dto.GetProductDTO;

@Component
@FeignClient("CATALOGUESERVICE")
public interface CatalogueInterface {
	
	@GetMapping("/catalogue/{productId}")
	public ResponseEntity<GetProductDTO> getProductById(@PathVariable String productId);

}
