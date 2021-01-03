CREATE TABLE customer (
id INT(6) PRIMARY KEY,
firstname VARCHAR(30),
lastname VARCHAR(30),
loginname VARCHAR(30) UNIQUE,
gender VARCHAR(10),
city VARCHAR(20)
);

CREATE TABLE seller (
id INT(6) PRIMARY KEY,
firstname VARCHAR(30),
lastname VARCHAR(30),
loginname VARCHAR(30) UNIQUE,
gender VARCHAR(10),
city VARCHAR(20)
);

CREATE TABLE product (
id INT(6) PRIMARY KEY,
seller_id INT(6) ,
name VARCHAR(30),
price double,
category VARCHAR(10),
colour VARCHAR(20),
description VARCHAR(30),
count INT(6)
);


CREATE TABLE products_purchased (
product_ID INT(6),
seller_iD INT(6) ,
customer_ID INT(6),
count INT(6),
purchase_id INT(6) AUTO_INCREMENT PRIMARY KEY
)



















