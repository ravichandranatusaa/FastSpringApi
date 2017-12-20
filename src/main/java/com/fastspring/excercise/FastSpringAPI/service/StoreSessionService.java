package com.fastspring.excercise.FastSpringAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastspring.excercise.FastSpringAPI.domain.StoreSession;
import com.fastspring.excercise.FastSpringAPI.repository.ILoginPerson;
import com.fastspring.excercise.FastSpringAPI.repository.IStoreRepo;
import com.fastspring.excercise.FastSpringAPI.repository.IStoreSessionRepo;

@Service
public class StoreSessionService {
	@Autowired
	IStoreSessionRepo storeSessionRepo;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	IStoreRepo storeRepo;
	
	public List<StoreSession> getAllStoreSession() {
		return storeSessionRepo.findAll();
	}
	
	public StoreSession getStoreSession(int id) {
		return storeSessionRepo.getOne(id);
	}
	
	
	public StoreSession getStoreSession(String userid, int storeid) {
		StoreSession retval = new StoreSession();
		if(userid!=null && storeid>0) {
			retval.setLoginperson(loginService.getLoginPerson(userid));
			retval.setStore(storeRepo.findOne(storeid));
			retval.setClosesession(false);
			retval = storeSessionRepo.saveAndFlush(retval);
		}
		return retval;
	}
	
	public StoreSession saveStoreSession(StoreSession store) {
		if(store!=null) {
			store = storeSessionRepo.saveAndFlush(store);
		}
		return store;
	}
	
	public boolean deleteStoreSession(StoreSession store) {
		if(store!=null) {
			storeSessionRepo.delete(store);
			return true;
		}
		return false;
	}
}
