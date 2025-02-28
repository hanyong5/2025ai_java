use shop;
desc t_customer;
CREATE TABLE t_customer(
	 customer_id int not null auto_increment,
	 customer_name varchar(10) not null,
	 phone varchar(20) not null unique,
	 email varchar(50) not null unique,
	 address varchar(100) not null,
	 regist_date datetime default now(),
	 region_code varchar(3) not null,
	 primary key(customer_id)
 );

CREATE TABLE t_region(
	 region_code varchar(3) not null,
	 region_name varchar(10) not null,
	 primary key(region_code)
 );

CREATE TABLE t_product(
	 product_code int not null auto_increment,
	 product_name varchar(50) not null,
	 price int,
	 primary key(product_code)
 );

 CREATE TABLE t_sales(
	 id int not null auto_increment,
	 customer_id int not null,
	 product_code int not null,
	 qty int not null,
	 sales_date datetime default now(),
	 primary key(id)
 );
 
ALTER TABLE t_customer ADD CONSTRAINT fk_region_code FOREIGN KEY (region_code) REFERENCES t_region(region_code);
ALTER TABLE t_sales ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES t_customer (customer_id);
ALTER TABLE t_sales ADD CONSTRAINT fk_product_code FOREIGN KEY (product_code) REFERENCES t_product (product_code);

INSERT INTO t_region (region_code, region_name) VALUES
 ('02', '서울특별시'),
 ('031', '경기도'),
 ('032', '인천광역시'),
 ('033', '강원특별자치도'),
 ('041', '충청남도'),
 ('042', '대전광역시'),
 ('043', '충청북도'),
 ('044', '세종특별자치시'),
 ('051', '부산광역시'),
 ('052', '울산광역시'),
 ('053', '대구광역시'),
 ('054', '경상북도'),
 ('055', '경상남도'),
 ('061', '전라남도'),
 ('062', '광주광역시'),
 ('063', '전라북도'),
 ('064', '제주특별자치도');
 
 
INSERT INTO t_customer (customer_name, phone, email, address, region_code)
 VALUES
 ('홍길동', '010-1234-5678', 'hong@example.com', '서울시 강남구', '02'),
 ('김철수', '010-9876-5432', 'kim@example.com', '경기도 수원시', '031'),
 ('이영희', '010-1111-2222', 'lee@example.com', '인천시 남구', '032'),
 ('박민지', '010-5555-7777', 'park@example.com', '강원도 춘천시', '033'),
 ('정기호', '010-9999-8888', 'jung@example.com', '대전시 중구', '042');

INSERT INTO t_product(product_name, price)
 VALUES
 ('노트북', 1500000),
 ('스마트폰', 1000000),
 ('키보드', 50000),
 ('마우스', 30000),
 ('이어폰', 70000);

INSERT INTO t_sales (customer_id, product_code, qty)
 VALUES
 (1, 1, 2),
 (2, 2, 1),
 (3, 3, 5),
 (4, 4, 3),
 (5, 5, 2),
 (1, 2, 3),
 (3, 1, 1),
 (2, 4, 2),
 (4, 3, 4),
 (5, 5, 1);

select * from shop.t_customer tc ;
select * from shop.t_region tr ;
select * from shop.t_product tp ;
select * from shop.t_sales ts ;

# 제품별(product)로 구매된 총수량(sales)과 총가격(product)을 계산하여 출력

select tp.product_name , sum(tp.price), sum(ts.qty)
from t_sales ts 
join t_product tp
on ts.product_code = tp.product_code
group by tp.product_name
;

# 특정고객(3)이 구매(sales)한 제품이름(product) 출력

select 
	ts.customer_id,
	tc.customer_name,
	tp.product_name
from t_sales ts 
join t_product tp 
	on ts.product_code = tp.product_code
join t_customer tc 
	on ts.customer_id =tc.customer_id
where tc.customer_name like "이영희"
order by tp.product_name asc
;

# 특정고객(3)이 구매(sales)한 제품이름(product) 출력

select ts.customer_id ,tp.product_name, ts.sales_date
from t_sales ts
join t_product tp 
on ts.product_code = tp.product_code
where ts.customer_id = 3
;




# 각 지역별로 고객수를 계산
select  
	tr.region_code,tr.region_name,
	count(*) as count
from t_customer tc 
join t_region tr 
on tc.region_code = tr.region_code
group by tr.region_code;

# 각 지역별로 고객수, 고객이름출력
select  
	tr.region_code,
	GROUP_CONCAT(tc.customer_name),
	count(*) as count
from t_customer tc 
join t_region tr 
on tc.region_code = tr.region_code
group by tr.region_code;


select * from shop.t_customer tc ;
select * from shop.t_region tr ;
select * from shop.t_product tp ;
select * from shop.t_sales ts ;

# 고객(customer)이 속한 지역(region)별 총 구매량(sales) 출력

select tc.customer_name,tc.region_code,ts.qty
from t_sales ts 
join t_customer tc 
on ts.customer_id = tc.customer_id;

select tc.region_code,sum(ts.qty) as count
from t_sales ts 
join t_customer tc 
on ts.customer_id = tc.customer_id
group by tc.region_code;

#결과
select tr.region_name, Rc.count
from t_region tr 
join (
	select tc.region_code,sum(ts.qty) as count
	from t_sales ts 
	join t_customer tc 
	on ts.customer_id = tc.customer_id
	group by tc.region_code
) Rc
on tr.region_code = Rc.region_code
order by Rc.count desc;





