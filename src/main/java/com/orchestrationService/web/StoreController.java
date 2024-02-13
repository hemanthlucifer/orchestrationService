package com.orchestrationService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.orchestrationService.dto.StoreDTO;
import com.orchestrationService.serviceImpl.StoreServiceImpl;

@RestController
@RequestMapping("/warehouse/store")
public class StoreController {
	
	@Autowired
	private StoreServiceImpl storeService;
	
	
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Store created sucessfully"),
			@ApiResponse(responseCode="400",description="Bad Request"),
			@ApiResponse(responseCode="500",description="Something went wrong")
	})
	@PostMapping("/")
	public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO store) {
		StoreDTO storeDTO = storeService.addStoreToGoodown(store);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Store fetched sucessfully"),
			@ApiResponse(responseCode="404",description="store not found with the given Id"),
			@ApiResponse(responseCode="500",description="Something went wrong")
	})
	@GetMapping("/{storeId}")
	public ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId")int storeId){
		StoreDTO storeDto = storeService.getStoreDetailsByStoreId(storeId);
		return new ResponseEntity<>(storeDto,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(responseCode="200",description="Store fetched sucessfully"),
			@ApiResponse(responseCode="404",description="store not found with the given Id"),
			@ApiResponse(responseCode="500",description="Something went wrong")
	})
	@GetMapping("/")
	public ResponseEntity<StoreDTO> getStoreByName(@RequestParam("storeName") String storeName){
		StoreDTO storeDTO = storeService.getStoreDetailsByStoreName(storeName);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}

}
