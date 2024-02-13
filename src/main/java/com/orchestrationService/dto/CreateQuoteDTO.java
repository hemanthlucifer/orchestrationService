package com.orchestrationService.dto;

import java.io.Serializable;
import java.util.List;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateQuoteDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private double quotePrice;
	
	@Getter
	@Setter
	private int storeId;
	
	@Getter
	@Setter
	private String goodownId;
	
	@Getter
	@Setter
	private List<QuoteProduct> quoteProducts;

}
