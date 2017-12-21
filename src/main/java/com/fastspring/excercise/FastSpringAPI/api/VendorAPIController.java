package com.fastspring.excercise.FastSpringAPI.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.excercise.FastSpringAPI.domain.Coupon;
import com.fastspring.excercise.FastSpringAPI.domain.DiscountType;
import com.fastspring.excercise.FastSpringAPI.domain.Product;
import com.fastspring.excercise.FastSpringAPI.domain.ProductFormat;
import com.fastspring.excercise.FastSpringAPI.service.CouponService;
import com.fastspring.excercise.FastSpringAPI.service.DiscountTypeService;
import com.fastspring.excercise.FastSpringAPI.service.ProductFormatService;
import com.fastspring.excercise.FastSpringAPI.service.ProductService;

@RestController
@RequestMapping("/api")
public class VendorAPIController {


	@Autowired
	CouponService couponService;

	@Autowired
	DiscountTypeService discountTypeService;

	@Autowired
	ProductService productService;

	@Autowired
	ProductFormatService productFormatService;

	@RequestMapping(value = "/coupon", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody List<Coupon> listAllCoupons() {
		List<Coupon> coupons = couponService.getAllCoupons();
		return coupons;
	}

	@RequestMapping(value = "/coupon", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Coupon createCoupon(@RequestParam String code, @RequestParam long discounttypeid, @RequestParam float value, @RequestParam long datemillis) {
		Coupon coupon = new Coupon();
		coupon.setCode(code);
		coupon.setExpirydate(new Date(datemillis));
		coupon.setValue(value);
		DiscountType coupontype = discountTypeService.getDiscountType(discounttypeid);
		coupon.setCoupontype(coupontype);

		coupon = couponService.saveCoupon(coupon);

		return coupon;
	}


	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Coupon getCoupon(@PathVariable long id) {
		Coupon coupon = couponService.getCoupon(id);
		return coupon;
	}

	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Coupon updateCoupon(@PathVariable long id, @RequestParam String code, @RequestParam long discounttypeid, @RequestParam float value, @RequestParam long datemillis) {
		Coupon coupon = couponService.getCoupon(id);
		if(coupon!=null) {
			DiscountType coupontype = discountTypeService.getDiscountType(discounttypeid);
			if(coupontype!=null) {
				coupon.setCode(code);
				coupon.setExpirydate(new Date(datemillis));
				coupon.setValue(value);
				coupon = couponService.saveCoupon(coupon);

			}
		}
		return coupon;
	}

	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody boolean deleteCoupon(@PathVariable long id) {
		Coupon coupon = couponService.getCoupon(id);
		if (coupon!=null) {
			couponService.deleteCoupon(coupon);
			return true;
		}
		return false;
	}






	@RequestMapping(value = "/product", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody List<Product> listAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Product createProduct(@RequestParam String displayname, @RequestParam float unitprice, @RequestParam int defaultqty, @RequestParam String isdefaultqtyedit, @RequestParam String isremovable, @RequestParam long productformatid) {
		Product product = new Product();
		product.setDefaultqty(defaultqty);
		product.setDisplayname(displayname);
		product.setIsdefaultqtyedit("true".equalsIgnoreCase(isdefaultqtyedit)?true:false);
		product.setIsremovable("true".equalsIgnoreCase(isremovable)?true:false);
		product.setUnitprice(unitprice);
		ProductFormat productformat = productFormatService.getProductFormat(productformatid);
		product.setProductformat(productformat);

		product = productService.saveProduct(product);
		return product;
	}


	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Product getProduct(@PathVariable long id) {
		Product product = productService.getProduct(id);
		return product;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody Product updateProduct(@PathVariable long id, @RequestParam String displayname, @RequestParam float unitprice, @RequestParam int defaultqty, @RequestParam String isdefaultqtyedit, @RequestParam String isremovable, @RequestParam long productformatid) {
		Product product = productService.getProduct(id);
		if(product!=null) {
			ProductFormat productformat = productFormatService.getProductFormat(productformatid);
			if(productformat!=null) {
				product.setDefaultqty(defaultqty);
				product.setDisplayname(displayname);
				product.setIsdefaultqtyedit("true".equalsIgnoreCase(isdefaultqtyedit)?true:false);
				product.setIsremovable("true".equalsIgnoreCase(isremovable)?true:false);
				product.setUnitprice(unitprice);
				product.setProductformat(productformat);

				product = productService.saveProduct(product);
				
			}
		}
		return product;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces="application/json")
	public @ResponseBody boolean deleteProduct(@PathVariable long id) {
		Product product = productService.getProduct(id);
		if (product==null) {
			return false;
		} else {
			productService.deleteProduct(product);
			return true;
		}
	}





}
