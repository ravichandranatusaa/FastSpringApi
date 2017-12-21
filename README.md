"# FastSpringApi" 


There are 10 different REST APIs for Vendor to support CRUD operations of Product & Coupon. They are,

1)	GET		/api/coupon				-	To get all coupons
2)  POST	/api/coupon				-	To create new coupon
3)  DELETE	/api/coupon/{id}		-	To delete a coupon based on its id
4)  PUT		/api/coupon/{id}		-	To update the coupon
5)  GET		/api/coupon/{id}		-	To get specific coupon
6)  POST	/api/product			-	To create new product
7)  GET		/api/product			-	To get all products
8)  GET		/api/product/{id}		-	To get specific product based on its id
9)  DELETE	/api/product/{id}		-	To delete a product based on its id
10) PUT		/api/product/{id}		-	To update the product
 
 
And There are 5 different APIs for Store (session)

1)	POST	/storeapi/coupon		-	To apply coupon to the order
2)	DELETE	/storeapi/product		-	To delete the product from the order
3)	GET		/storeapi/product		-	To get the all the product details of order
4)	POST	/storeapi/product		-	To create a new order
5)	GET		/storeapi/store			-	To get all store details

