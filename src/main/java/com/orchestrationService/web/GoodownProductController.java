package com.orchestrationService.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchestrationService.dto.GoodownProductDTO;
import com.orchestrationService.service.GoodownProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@OpenAPIDefinition(info=@Info(contact=@Contact(name="warehouse website team"),
description="This controller is responsible for performing REST operations on goodown product",
version="1.0"))
@RestController
@RequestMapping("/warehouse/product")
public class GoodownProductController {
	
	@Autowired
	private GoodownProductService goodownProductServiceImpl;
	
	@CircuitBreaker(name="logisticsservice", fallbackMethod="getAllProductsInCategoryFallback")
	@Retry(name="logisticsservice")
	@Operation(summary="get all products in goodown by using category")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Products fetched sucessfully"),
			@ApiResponse(responseCode="404", description="No products found with the given category"),
			@ApiResponse(responseCode="500", description="Something went wrong")
	})
	@GetMapping("/goodownCategory/{goodownId}/{categoryId}")
	public ResponseEntity<List<GoodownProductDTO>> getAllProductsInCategoryInGoodown(@PathVariable String goodownId, @PathVariable String categoryId){
		List<GoodownProductDTO> goodownProductDto = goodownProductServiceImpl.getAllProductsInCategoryInGoodown(goodownId, categoryId);
		return new ResponseEntity<>(goodownProductDto,HttpStatus.OK);
	}
	
	public ResponseEntity<List<GoodownProductDTO>> getAllProductsInCategoryFallback(@PathVariable String goodownId, @PathVariable String categoryId, RuntimeException runtimeException){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

}
