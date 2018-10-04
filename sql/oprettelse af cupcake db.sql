DROP DATABASE IF EXISTS cupcakes;

CREATE DATABASE cupcakes;
USE cupcakes;

DROP TABLE IF EXISTS lineitems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS producttypes;

CREATE TABLE producttypes(
id int PRIMARY KEY AUTO_INCREMENT,
`type` VARCHAR(50) NOT NULL
);

CREATE TABLE users(
id int PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE, 
`password` VARCHAR(256) NOT NULL, -- så vi kan kryptere med sha2/salt.
balance DECIMAL(13,2) NOT NULL DEFAULT 0
);

CREATE TABLE products(
id int PRIMARY KEY AUTO_INCREMENT,
producttypeId int NOT NULL,
`name` VARCHAR(50) NOT NULL,
price DECIMAL(13,2) NOT NULL,
CONSTRAINT fk_products_producttypes
FOREIGN KEY (producttypeId)
REFERENCES producttypes(id)
ON DELETE NO ACTION -- producttypes referenced by products can not be deleted.
);

CREATE TABLE orders(
id int PRIMARY KEY AUTO_INCREMENT,
userId int NOT NULL,
CONSTRAINT fk_orders_users
FOREIGN KEY (userId)
REFERENCES users(id)
ON DELETE NO ACTION -- users referenced by orders can not be deleted.
);

CREATE TABLE lineitems(
-- id int PRIMARY KEY AUTO_INCREMENT,
orderId int,
productId int,
qty int NOT NULL,
price DECIMAL(13,2) NOT NULL,
PRIMARY KEY(orderId, productId), -- sammensat primær ngl. istedet for (godt set, Jesper).
CONSTRAINT fk_lineitems_orders
FOREIGN KEY(orderId)
REFERENCES orders(id)
ON DELETE CASCADE, -- if an order is deleted, so are its lineitems.
CONSTRAINT fk_lineitems_products
FOREIGN KEY(productId)
REFERENCES products(id)
ON DELETE NO ACTION -- products referenced by lineitems can not be deleted.
);





