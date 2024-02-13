package com.orchestrationService.service;

import com.orchestrationService.dto.StoreDTO;

public interface StoreService {
	
	public StoreDTO addStoreToGoodown(StoreDTO storeDTO);
	public StoreDTO getStoreDetailsByStoreId(int storeId);
	public StoreDTO getStoreDetailsByStoreName(String storeName);

}
