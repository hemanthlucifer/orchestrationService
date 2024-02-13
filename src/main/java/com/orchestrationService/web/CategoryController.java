package com.orchestrationService.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchestrationService.dto.CategoryDTO;
import com.orchestrationService.service.CategoryService;
import com.orchestrationService.util.MessageCodes;

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
@RequestMapping("/warehouse/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@CircuitBreaker(name="logisticsservice", fallbackMethod="createCategoryFallback")
	@Operation(summary="create catgeory")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Category created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating category")
	})
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(CategoryDTO categoryDTO){
		CategoryDTO newCategoryDTO = categoryService.createCategory(categoryDTO);
		return new ResponseEntity<>(newCategoryDTO,HttpStatus.OK);
	}
	
	@CircuitBreaker(name="logisticsservice", fallbackMethod="getAllCategoriesInGoodownFallback")
	@Operation(summary="get all categories in goodown")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="categories fetched sucessfully"),
			@ApiResponse(responseCode="404", description="No goodown present with given goodownId"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching categories")
	})
	@GetMapping("/{goodownId}")
	public ResponseEntity<List<CategoryDTO>> getAllCategoriesInGoodown(@PathVariable("goodownId") String goodownId){
		List<CategoryDTO> categories = categoryService.getAllCategoriesInGoodown(goodownId);
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	
	public ResponseEntity<List<CategoryDTO>> getAllCategoriesInGoodownFallback(@PathVariable("goodownId") String goodownId, RuntimeException runtimeException) throws Exception{
		throw new Exception(MessageCodes.unknownError);
	}
	
	
	public ResponseEntity<CategoryDTO> createCategoryFallback(CategoryDTO categoryDTO, RuntimeException runTimeException){
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

}
