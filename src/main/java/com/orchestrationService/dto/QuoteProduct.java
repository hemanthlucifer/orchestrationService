package com.orchestrationService.dto;


import lombok.Getter;
import lombok.Setter;


public class QuoteProduct {
	
	
	@Getter
	@Setter
	private int productId;
	
	@Getter
	@Setter
	private String productName;
	
	@Getter
	@Setter
	private double productCost;
	
	@Getter
	@Setter
	private int quantity;
	
	
	
}

