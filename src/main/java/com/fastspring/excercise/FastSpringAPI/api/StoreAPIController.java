package com.fastspring.excercise.FastSpringAPI.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.excercise.FastSpringAPI.domain.Store;
import com.fastspring.excercise.FastSpringAPI.service.StoreService;

@RestController
@RequestMapping("/storeapi")
public class StoreAPIController {

	
	@Autowired
    StoreService storeService;
	
	@RequestMapping(value = "/store", method = RequestMethod.GET)
    public ResponseEntity<List<Store>> listAllCoupons() {
		List<Store> stores = storeService.getAllStores();
        if (stores.isEmpty()) {
            return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }

	
}
