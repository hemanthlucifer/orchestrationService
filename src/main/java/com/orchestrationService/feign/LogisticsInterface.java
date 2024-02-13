package com.orchestrationService.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.orchestrationService.dto.CategoryDTO;
import com.orchestrationService.dto.CreateQuoteDTO;
import com.orchestrationService.dto.GetQuoteDTO;
import com.orchestrationService.dto.GoodownProductDTO;
import com.orchestrationService.dto.StoreDTO;

@Component
@FeignClient("LOGISTICSSERVICE")
public interface LogisticsInterface {
	
	@PostMapping("/category/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO);
	
	
	@GetMapping("/category/{goodownId}")
	public ResponseEntity<List<CategoryDTO>> getAllCategoriesInGoodown(@PathVariable("goodownId") String goodownId);
	
	@GetMapping("/gProduct/goodownCategory/{goodownId}/{categoryId}")
	public ResponseEntity<List<GoodownProductDTO>> getAllProductsInCategoryInGoodown(@PathVariable String goodownId, @PathVariable String categoryId);
	
	@PostMapping("/quotation/")
	public ResponseEntity<GetQuoteDTO> createQuotation(@RequestBody CreateQuoteDTO quoteDto);
	
	@GetMapping("/quotation/{quoteId}")
	public ResponseEntity<GetQuoteDTO> getQuoteById(@PathVariable("quoteId")int quoteId);
	
	@PostMapping("/store/")
	public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO store);
	
	@GetMapping("/store/{storeId}")
	public ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId")int storeId);
	
	@GetMapping("/store/")
	public ResponseEntity<StoreDTO> getStoreByName(@RequestParam("storeName") String storeName);

}
