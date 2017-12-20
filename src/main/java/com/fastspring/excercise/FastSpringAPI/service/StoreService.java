package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.Store;
import com.fastspring.excercise.FastSpringAPI.repository.IStoreRepo;

@Service
public class StoreService {
	@Autowired
	IStoreRepo storeRepo;
	
	public List<Store> getAllStores() {
		return storeRepo.findAll();
	}
	
	public Store getStore(Long id) {
		return storeRepo.getOne(id);
	}
	
	public Store saveStore(Store store) {
		if(store!=null) {
			store = storeRepo.saveAndFlush(store);
		}
		return store;
	}
	
	public boolean deleteStore(Store store) {
		if(store!=null) {
			storeRepo.delete(store);
			return true;
		}
		return false;
	}
}
