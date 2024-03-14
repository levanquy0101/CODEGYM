CREATE DATABASE product_manager;

use product_manager;

CREATE TABLE customer (
	id int PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50),
	age int
);

CREATE TABLE
`order` (
	id int PRIMARY KEY AUTO_INCREMENT,
	customer_id int,
	`date` datetime,
	total_price float,
	FOREIGN KEY (customer_id) REFERENCES customer (id)
);

CREATE TABLE product (
	id int PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50),
	price FLOAT
);

CREATE TABLE order_detail (
	order_id int,
	product_id int,
	quantity SMALLINT,
	PRIMARY KEY (order_id, product_id)
);


-- insert data customer
INSERT INTO customer (`name`, age) VALUE('Minhh Quan', 10);
INSERT INTO customer (`name`, age) VALUE('Ngoc Oanh', 20);
INSERT INTO customer (`name`, age) VALUE('Hong Ha', 50);


-- insert data order
insert INTO `order` (customer_id, `date`) VALUE(1, '2006-03-21');
insert INTO `order` (customer_id, `date`) VALUE(2, '2006-03-23');
insert INTO `order` (customer_id, `date`) VALUE(1, '2006-03-21');

-- insert data product
INSERT into product (`name`, price) VALUE('may giat', 3);
INSERT into product (`name`, price) VALUE('tu lanh', 5);
INSERT into product (`name`, price) VALUE('dieu hoa', 7);
INSERT into product (`name`, price) VALUE('quat', 1);
INSERT into product (`name`, price) VALUE('bep dien', 2);

-- insert data order detail
INSERT INTO order_detail (order_id, product_id, quantity) VALUE(1,1,3);
INSERT INTO order_detail (order_id, product_id, quantity) VALUE(1,3,7);
INSERT INTO order_detail (order_id, product_id, quantity) VALUE(1,4,2);
INSERT INTO order_detail (order_id, product_id, quantity) VALUE(3,1,8);
INSERT INTO order_detail (order_id, product_id, quantity) VALUE(2,5,4);
INSERT INTO order_detail (order_id, product_id, quantity) VALUE(2,3,3);

-----------------

-- 1 Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT * from `order`;

-- 2 Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.name, p.name from customer c 
join `order` o on c.id = o.customer_id 
join order_detail od on o.id = od.order_id
join product p on od.product_id = p.id

-- 3 Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào (use explain to test performence)
select * from customer c where not exists (select 1 from `order` o where o.customer_id = c.id);

SELECT * from customer WHERE id not in (SELECT customer_id FROM `order`);

SELECT * FROM customer c
LEFT JOIN `order` o on o.customer_id= c.id
WHERE o.id is NULL


-- 4 Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT o.id as `code`, o.date as `date`, sum(p.price* d.quantity) as total from `order` o
INNER JOIN order_detail d on d.order_id= o.id
INNER JOIN product p on p.id= d.product_id
GROUP BY o.id




