package com.orchestrationService.service;

import com.orchestrationService.dto.CreateQuoteDTO;
import com.orchestrationService.dto.GetQuoteDTO;

public interface QuotationService {
	
	public GetQuoteDTO createQuote(CreateQuoteDTO quote);
	public GetQuoteDTO getQuoteByQuoteId(int quoteId);

}
