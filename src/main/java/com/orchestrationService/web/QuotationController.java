package com.orchestrationService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchestrationService.dto.CreateQuoteDTO;
import com.orchestrationService.dto.GetQuoteDTO;
import com.orchestrationService.service.QuotationService;


@RestController
@RequestMapping("/warehouse/quotation")
public class QuotationController {
	
	@Autowired
	private QuotationService quotationService;
	
	@PostMapping("/")
	public ResponseEntity<GetQuoteDTO> createQuotation(@RequestBody CreateQuoteDTO quoteDto) {
		GetQuoteDTO quote = quotationService.createQuote(quoteDto);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}
	
	@GetMapping("/{quoteId}")
	public ResponseEntity<GetQuoteDTO> getQuoteById(@PathVariable("quoteId")int quoteId){
		GetQuoteDTO quote = quotationService.getQuoteByQuoteId(quoteId);
		return new ResponseEntity<>(quote,HttpStatus.OK);
	}


}
