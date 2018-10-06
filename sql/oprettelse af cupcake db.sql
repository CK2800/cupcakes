DROP DATABASE IF EXISTS cupcakes;

CREATE DATABASE cupcakes;
USE cupcakes;

DROP TABLE IF EXISTS lineitems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS bottoms;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS producttypes;


CREATE TABLE users(
id int PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE, 
`password` VARCHAR(64) NOT NULL, -- så vi kan kryptere med sha2/salt - 256 bits/4 bits hex = 64 chars.
balance DECIMAL(13,2) NOT NULL DEFAULT 0
);

CREATE TABLE bottoms(
id int PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
price DECIMAL(13,2) NOT NULL
);

CREATE TABLE toppings(
id int PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
price DECIMAL(13,2) NOT NULL
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
orderId int,
toppingId int,
bottomId int,
qty int NOT NULL,
price DECIMAL(13,2) NOT NULL,
PRIMARY KEY(orderId, toppingId, bottomId), -- sammensat primær ngl. istedet for (godt set, Jesper).
CONSTRAINT fk_lineitems_orders
FOREIGN KEY(orderId)
REFERENCES orders(id)
ON DELETE CASCADE, -- if an order is deleted, so are its lineitems.
CONSTRAINT fk_lineitems_toppings
FOREIGN KEY(toppingId)
REFERENCES toppings(id)
ON DELETE NO ACTION, -- toppings referenced by lineitems can not be deleted.
CONSTRAINT fk_lineitems_bottoms
FOREIGN KEY(bottomId)
REFERENCES toppings(id)
ON DELETE NO ACTION -- bottoms referenced by lineitems can not be deleted.
);





