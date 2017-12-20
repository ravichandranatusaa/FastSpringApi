package com.fastspring.excercise.FastSpringAPI.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastspring.excercise.FastSpringAPI.domain.Coupon;
import com.fastspring.excercise.FastSpringAPI.domain.CouponType;
import com.fastspring.excercise.FastSpringAPI.domain.Product;
import com.fastspring.excercise.FastSpringAPI.domain.ProductFormat;
import com.fastspring.excercise.FastSpringAPI.service.CouponService;
import com.fastspring.excercise.FastSpringAPI.service.CouponTypeService;
import com.fastspring.excercise.FastSpringAPI.service.ProductFormatService;
import com.fastspring.excercise.FastSpringAPI.service.ProductService;

@RestController
@RequestMapping("/api")
public class VendorAPIController {

	
	@Autowired
    CouponService couponService;
	
	@Autowired
    CouponTypeService couponTypeService;
	
	@Autowired
    ProductService productService;
	
	@Autowired
    ProductFormatService productFormatService;
	
	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
    public ResponseEntity<List<Coupon>> listAllCoupons() {
		List<Coupon> coupons = couponService.getAllCoupons();
        if (coupons.isEmpty()) {
            return new ResponseEntity<List<Coupon>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Coupon>>(coupons, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/coupon", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<Coupon> createCoupon(@RequestParam String code, @RequestParam long discounttypeid, @RequestParam float value, @RequestParam long datemillis) {
		Coupon coupon = new Coupon();
		coupon.setCode(code);
		coupon.setExpirydate(new Date(datemillis));
		coupon.setValue(value);
		CouponType coupontype = couponTypeService.getCouponType(discounttypeid);
		coupon.setCoupontype(coupontype);

		coupon = couponService.saveCoupon(coupon);
		
		return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<Coupon> getCoupon(@PathVariable long id) {
		Coupon coupon = couponService.getCoupon(id);
        if (coupon==null) {
            return new ResponseEntity<Coupon>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable long id, @RequestParam String code, @RequestParam long discounttypeid, @RequestParam float value, @RequestParam long datemillis) {
		Coupon coupon = couponService.getCoupon(id);
		if(coupon!=null) {
			CouponType coupontype = couponTypeService.getCouponType(discounttypeid);
			if(coupontype!=null) {
				coupon.setCode(code);
				coupon.setExpirydate(new Date(datemillis));
				coupon.setValue(value);
				coupon = couponService.saveCoupon(coupon);
				return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
			} else {
				return new ResponseEntity<Coupon>(HttpStatus.NO_CONTENT);
			}
		}
		else {
            return new ResponseEntity<Coupon>(HttpStatus.NO_CONTENT);
        }
    }
	
	@RequestMapping(value = "/coupon/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<String> deleteCoupon(@PathVariable long id) {
		Coupon coupon = couponService.getCoupon(id);
        if (coupon==null) {
            return new ResponseEntity<String>("Delete Failed",HttpStatus.BAD_REQUEST);
        } else {
        	couponService.deleteCoupon(coupon);
        	return new ResponseEntity<String>("Delete Successful",HttpStatus.OK);
        }
    }
	
	
	


	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/product", method = RequestMethod.POST, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<Product> createProduct(@RequestParam String displayname, @RequestParam float unitprice, @RequestParam int defaultqty, @RequestParam String isdefaultqtyedit, @RequestParam String isremovable, @RequestParam long productformatid) {
		Product product = new Product();
		product.setDefaultqty(defaultqty);
		product.setDisplayname(displayname);
		product.setIsdefaultqtyedit("true".equalsIgnoreCase(isdefaultqtyedit)?true:false);
		product.setIsremovable("true".equalsIgnoreCase(isremovable)?true:false);
		product.setUnitprice(unitprice);
		ProductFormat productformat = productFormatService.getProductFormat(productformatid);
		product.setProductformat(productformat);

		product = productService.saveProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product product = productService.getProduct(id);
        if (product==null) {
            return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestParam String displayname, @RequestParam float unitprice, @RequestParam int defaultqty, @RequestParam String isdefaultqtyedit, @RequestParam String isremovable, @RequestParam long productformatid) {
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
				return new ResponseEntity<Product>(product, HttpStatus.OK);
			} else {
				return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
			}
		}
		else {
            return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
        }
    }
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json", produces="application/json")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		Product product = productService.getProduct(id);
        if (product==null) {
            return new ResponseEntity<String>("Delete Failed",HttpStatus.BAD_REQUEST);
        } else {
        	productService.deleteProduct(product);
        	return new ResponseEntity<String>("Delete Successful",HttpStatus.OK);
        }
    }
	
	
	
	
	
}
