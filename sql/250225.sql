use school;
show tables;

CREATE TABLE customers (
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE orders (
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  product VARCHAR(50),
  order_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO customers (name) VALUES ('Alice'), ('Bob'), ('Charlie');

INSERT INTO orders (customer_id, product, order_date) VALUES
(1, 'Apple', '2025-01-01'),
(1, 'Banana', '2025-01-02'),
(2, 'Orange', '2025-01-03');



select c.name
from school.customers c 
join school.orders o 
on c.customer_id = o.customer_id
group by c.name 
order by c.name desc
;



where o.order_id is null;










