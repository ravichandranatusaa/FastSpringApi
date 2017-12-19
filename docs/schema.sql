CREATE TABLE discounttype(id int primary key, typename varchar(255));

CREATE TABLE coupon(id int primary key
,code varchar(255)
,discounttypeid int
,value decimal(20,2)
,expirydate date
);

ALTER TABLE coupon add foreign key (discounttypeid) references discounttype(id);


CREATE TABLE discount(id int primary key
,discounttypeid int
,productid int
,quantity int
,value decimal(20,2)
,discountorder int
);

ALTER TABLE discount add foreign key (discounttypeid) references discounttype(id);
ALTER TABLE discount add foreign key (productid) references product(id);


create table store(id int primary key, storename varchar(255), storeaddr varchar(2000), displayname varchar(255));

create table loginperson(id int primary key, name varchar(255), displayname varchar(1000), password varchar(2000)); 

create table storesession(id int primary key, loginpersonid int, closesession boolean);

ALTER TABLE storesession add foreign key (loginpersonid) references loginperson(id);

CREATE TABLE productformat(id int primary key, name varchar(255));

create table product(id int primary key
,displayname varchar(255)
,unitprice decimal(22,0)
,defaultqty int
,isdefaultqtyedit boolean
,isremovable boolean
,productformatid int
,deletedflag boolean
);


create table orders(id int primary key
,storesessionid int
,couponid int
);

ALTER TABLE orders add foreign key (storesessionid) references storesession(id);
ALTER TABLE orders add foreign key (couponid) references coupon(id);

create table orderitems(id int primary key
,orderid int
,productid int
,isvoided boolean
,discountval decimal(22,0)
,discountperc decimal(5,2)
);


ALTER TABLE orderitems add foreign key (orderid) references orders(id);
ALTER TABLE orderitems add foreign key (productid) references product(id);

commit;