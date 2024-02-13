package com.orchestrationService.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.orchestrationService.util.MessageCodes;

@Aspect
@Component
public class AOPExceptionHandler {
	
	@AfterThrowing(pointcut="execution(public * com.orchestrationService.serviceImpl.CatalogueServiceImpl.getProductById(String))", throwing="ex")
	public void catalogueServiceExceptionHandler(Exception ex) throws Exception {
		if(ex instanceof ProductNotFoundException) {
			throw new ProductNotFoundException(ex.getMessage());
		}else {
			throw new Exception(MessageCodes.unknownError);
		}
	}
	
	@AfterThrowing(pointcut="execution(public * com.orchestrationService.serviceImpl.CategoryServiceImpl.getAllCategoriesInGoodown(String))", throwing="ex")
	public void categoryExceptionHandler(Exception ex) throws Exception{
		if(ex instanceof GoodownNotFoundException) {
			throw new GoodownNotFoundException(ex.getMessage());
		}else {
			throw new Exception (MessageCodes.unknownError);
		}
	}
	
	@AfterThrowing(pointcut="execution(public * com.orchestrationService.serviceImpl.GoodownProductServiceImpl.getAllProductsInCategoryInGoodown(String, String))", throwing="ex")
	public void goodownProductServiceExceptionHandler(Exception ex) throws Exception{
		if(ex instanceof GoodownNotFoundException) {
			throw new GoodownNotFoundException(ex.getMessage());
		}else if(ex instanceof CategoryNotFoundException) {
			throw new CategoryNotFoundException(ex.getMessage());
		}else {
			throw new Exception(MessageCodes.unknownError);
		}
	}
	
	@AfterThrowing(pointcut="execution(public * com.orchestrationService.serviceImpl.StoreServiceImpl.getStoreDetailsByStoreId(int))", throwing="ex")
	public void storeServiceExceptionhandler(Exception ex) throws Exception {
		if(ex instanceof StoreNotFoundException) {
			throw new StoreNotFoundException(ex.getMessage());
		}else {
			throw new Exception(MessageCodes.unknownError);
		}
	}
	
	@AfterThrowing(pointcut="execution(public * com.orchestrationService.web.CategoryController.getAllCategoriesInGoodownFallback(String, RuntimeException))", throwing="ex")
	public void getCategoriesFallbackHandler(Exception ex) throws Exception{
		throw new Exception(MessageCodes.unknownError);
	}

}
