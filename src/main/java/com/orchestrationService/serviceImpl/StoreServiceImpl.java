package com.orchestrationService.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchestrationService.dto.StoreDTO;
import com.orchestrationService.feign.LogisticsInterface;
import com.orchestrationService.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private LogisticsInterface logisticsInterface;

	@Override
	public StoreDTO addStoreToGoodown(StoreDTO storeDTO) {
		StoreDTO store = logisticsInterface.createStore(storeDTO).getBody();
		return store;
	}

	@Override
	public StoreDTO getStoreDetailsByStoreId(int storeId) {
		StoreDTO storeDTO = logisticsInterface.getStoreById(storeId).getBody();
		return storeDTO;
	}

	@Override
	public StoreDTO getStoreDetailsByStoreName(String storeName) {
		StoreDTO storeDTO = logisticsInterface.getStoreByName(storeName).getBody();
		return storeDTO;
	}

}
