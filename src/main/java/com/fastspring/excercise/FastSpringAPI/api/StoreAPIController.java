package com.fastspring.excercise.FastSpringAPI.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.excercise.FastSpringAPI.domain.Coupon;
import com.fastspring.excercise.FastSpringAPI.domain.Discount;
import com.fastspring.excercise.FastSpringAPI.domain.OrderItems;
import com.fastspring.excercise.FastSpringAPI.domain.Orders;
import com.fastspring.excercise.FastSpringAPI.domain.Product;
import com.fastspring.excercise.FastSpringAPI.domain.Store;
import com.fastspring.excercise.FastSpringAPI.service.CouponService;
import com.fastspring.excercise.FastSpringAPI.service.DiscountService;
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

	@Autowired
	DiscountService discountService;
	
	@Autowired
	CouponService couponService;


	@RequestMapping(value = "/store", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody List<Store> listStores() {
		List<Store> stores = storeService.getAllStores();
		if (stores.isEmpty()) {
			return new ArrayList<Store>();
		}
		return stores;
	}

	
	
	
	
	
	@RequestMapping(value = "/product", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody List<OrderItems> getProducts(@RequestParam Long orderid) {
		if(orderid>0) {
			return ordersService.getOrder(orderid).getOrderItems();
		}
		return new ArrayList<OrderItems>();
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody OrderItems addProduct(@RequestParam Long orderid, @RequestParam Long productid, @RequestParam int quantity) {

		OrderItems item = new OrderItems();

		if(orderid>0 && productid>0 && quantity>0) {
			Product product = productService.getProduct(productid);

			List<Discount> discounts = discountService.getDiscount(product);

			item.setQuantity(quantity);

			/* Start - Logic to Apply Discount */
			long discountval = 0;
			int index = 0;
			for(Discount disc:discounts) {
				for(int count= quantity; count>0 && index<quantity;count--) {
					if(disc.getQuantity() == count) {
						discountval += disc.getValue();
						quantity = quantity - count; 
					} 
					index++;
				}
				index=0;
			}
			/* End - Logic to Apply Discount */
			
			float discountperc = ((product.getUnitprice() - discountval)/product.getUnitprice())*100;
			Orders order = ordersService.getOrder(orderid);
			item.setDiscountperc(discountperc);
			item.setDiscountval(discountval);
			item.setIsvoided(false);
			item.setOrder(order);
			item.setProducts(product);
			item = orderItemsService.saveOrderItem(item);
		}
		return item;
	}

	@RequestMapping(value = "/product", method = RequestMethod.DELETE, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody boolean removeProduct(@RequestParam Long orderitemid, @RequestParam Long orderid) {

		if(orderitemid>0 && orderid>0) {
			Orders order = ordersService.getOrder(orderid);
			OrderItems item = orderItemsService.getOrderItem(orderitemid);
			List<OrderItems> items = order.getOrderItems();
			if(items!=null) {
				items.remove(item);
				order.setOrderItems(items);
			}
			ordersService.saveOrder(order);
			return true;
		} else {
			return false;
		}
	}


	
	
	@RequestMapping(value = "/coupon", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Orders applyCoupon(@RequestParam Long orderid, @RequestParam String couponcode) {
		if(orderid>0 && couponcode!=null) {
			Orders order = ordersService.getOrder(orderid);
			Coupon coupon = couponService.getCouponByCode(couponcode);
			
			order.setCoupons(coupon);
			ordersService.saveOrder(order);
			return order;
		}
		return new Orders();
	}

}
