package com.orchestrationService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchestrationService.dto.CreateQuoteDTO;
import com.orchestrationService.dto.GetQuoteDTO;
import com.orchestrationService.feign.LogisticsInterface;
import com.orchestrationService.service.QuotationService;

@Service
public class QuotationServiceImpl implements QuotationService {
	
	@Autowired
	private LogisticsInterface quotation;

	@Override
	public GetQuoteDTO createQuote(CreateQuoteDTO quote) {
		GetQuoteDTO quoteDTO = quotation.createQuotation(quote).getBody();
		return quoteDTO;
	}

	@Override
	public GetQuoteDTO getQuoteByQuoteId(int quoteId) {
		GetQuoteDTO quoteDTO = quotation.getQuoteById(quoteId).getBody();
		return quoteDTO;
	}

}
