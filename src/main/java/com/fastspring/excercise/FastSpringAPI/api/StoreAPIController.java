package com.fastspring.excercise.FastSpringAPI.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.excercise.FastSpringAPI.domain.OrderItems;
import com.fastspring.excercise.FastSpringAPI.domain.Orders;
import com.fastspring.excercise.FastSpringAPI.domain.Product;
import com.fastspring.excercise.FastSpringAPI.domain.Store;
import com.fastspring.excercise.FastSpringAPI.service.OrderItemsService;
import com.fastspring.excercise.FastSpringAPI.service.OrdersService;
import com.fastspring.excercise.FastSpringAPI.service.ProductService;
import com.fastspring.excercise.FastSpringAPI.service.StoreService;

@RestController
@RequestMapping("/storeapi")
public class StoreAPIController {


	@Autowired
	StoreService storeService;

	@Autowired
	OrdersService ordersService;	

	@Autowired
	ProductService productService;

	@Autowired
	OrderItemsService orderItemsService;

	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public ResponseEntity<List<Store>> listStores() {
		List<Store> stores = storeService.getAllStores();
		if (stores.isEmpty()) {
			return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
	public ResponseEntity<OrderItems> addProduct(@RequestParam Long orderid, @RequestParam Long productid, @RequestParam float discountval, @RequestParam int quantity) {

		OrderItems item = new OrderItems();

		if(orderid>0 && productid>0 && quantity>0) {
			Product product = productService.getProduct(productid);
			float discountperc = ((product.getUnitprice() - discountval)/product.getUnitprice())*100;

			Orders order = ordersService.getOrder(orderid);

			item.setDiscountperc(discountperc);
			item.setDiscountval(discountval);
			item.setIsvoided(false);
			item.setOrder(order);
			item.setProducts(product);
			item.setQuantity(quantity);

			item = orderItemsService.saveOrderItem(item);

		}
		return new ResponseEntity<OrderItems>(item, HttpStatus.OK);
	}


	@RequestMapping(value = "/product", method = RequestMethod.DELETE, headers = "Accept=application/json", produces="application/json")
	public ResponseEntity<String> removeProduct(@RequestParam Long orderitemid, @RequestParam Long orderid) {

		if(orderitemid>0 && orderid>0) {
			Orders order = ordersService.getOrder(orderid);
			OrderItems item = orderItemsService.getOrderItem(orderitemid);
			List<OrderItems> items = order.getOrderItems();
			if(items!=null) {
				items.remove(item);
				order.setOrderItems(items);
			}
			ordersService.saveOrder(order);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Product Not Found", HttpStatus.BAD_REQUEST);
		}
	}



}
