use school;

create table sales (
	id int auto_increment primary key,
	product varchar(50),
	quantity int,
	price decimal(10,2),
	sale_date date
);

desc sales;
select * from sales;
insert into sales (product,quantity,price,sale_date) values ('Apple',10,1.50,'2025-01-01');
insert into sales (product,quantity,price,sale_date) values ('Banana',20,0.75,'2025-01-01');
insert into sales (product,quantity,price,sale_date) values ('Apple',15,1.50,'2025-01-03');
insert into sales (product,quantity,price,sale_date) values ('Orange',5,2.00,'2025-01-03');
insert into sales (product,quantity,price,sale_date) values ('Banana',25,0.80,'2025-01-05');

delete from sales where id =8;

select count(*) as total
from sales;

select sum(quantity) as total_sum
from sales;

select avg(price) as avg_price
from sales;

select 
	min(price) as min_price, 
	max(price) as max_price, 
	count(*) as total_count,
	sum(quantity) as total_sum
from sales;

select product,sum(quantity) as sum
from sales
group by product;


select sale_date,sum(quantity) as t_quantity,sum(price) as t_price,count(*) as t_count
from sales
group by sale_date 
order by t_count desc;




