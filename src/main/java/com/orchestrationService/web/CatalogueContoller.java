package com.orchestrationService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchestrationService.dto.GetProductDTO;
import com.orchestrationService.service.CatalogueService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@OpenAPIDefinition(info=@Info(contact=@Contact(name="warehouse website team"),
description="This Service is like a starting point for the warehouse website from here only we will call all the microservices",
version="1.0"))
@RestController
@RequestMapping("/warehouse/catalogue")
public class CatalogueContoller {
	
	@Autowired
	private CatalogueService cataloguService;
	
	@CircuitBreaker(name="catalogueservices",fallbackMethod="getProductFallabck")
	@Retry(name="catalogueservices")
	@Operation(summary="get product by Id")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="product fetched sucessfully"),
			@ApiResponse(responseCode="404",description="No product found with the given ID"),
			@ApiResponse(responseCode="500",description="Something went wrong")
	})
	@GetMapping("/{productId}")
	public ResponseEntity<GetProductDTO> getProductById(@PathVariable String productId){
		GetProductDTO product = cataloguService.getProductById(productId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	public ResponseEntity<GetProductDTO> getProductFallabck(@PathVariable String productId, RuntimeException runtimeException){
		return new ResponseEntity<>(new GetProductDTO(),HttpStatus.OK);
	}


}
