-- product types
INSERT INTO producttypes(type) VALUES('Bottom');
INSERT INTO producttypes(type) VALUES('Topping');
-- users
INSERT INTO users(username, password, balance) VALUES ('Jesper', 'Petersen', 100);
INSERT INTO users(username, password, balance) VALUES ('Henrik', 'Agger', 100);
INSERT INTO users(username, password, balance) VALUES ('Claus', 'Kramath', 100);
-- bottoms
INSERT INTO products(producttypeId, name, price) VALUES (1, 'Chocolate', 5);
INSERT INTO products(producttypeId, name, price) VALUES (1, 'Vanilla', 5);
INSERT INTO products(producttypeId, name, price) VALUES (1, 'Nutmeg', 5);
INSERT INTO products(producttypeId, name, price) VALUES (1, 'Pistacio', 6);
INSERT INTO products(producttypeId, name, price) VALUES (1, 'Almond', 7);
-- toppings
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Chocolate', 5);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Blueberry', 5);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Raspberry', 5);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Crispy', 6);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Strawberry', 6);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Rum/Raisin', 7);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Orange', 8);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Lemon', 8);
INSERT INTO products(producttypeId, name, price) VALUES (2, 'Blue cheese', 9);
-- orders
INSERT INTO orders(userId) VALUES(1);
INSERT INTO orders(userId) VALUES(2);
INSERT INTO orders(userId) VALUES(3);
-- line items, order 1
INSERT INTO lineitems(orderId, productId, qty, price) VALUES(1, 1, 2, 10);
INSERT INTO lineitems(orderId, productId, qty, price) VALUES(1, 7, 1, 5);
INSERT INTO lineitems(orderId, productId, qty, price) VALUES(1, 9, 1, 6);