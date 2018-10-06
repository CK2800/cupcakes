-- users
INSERT INTO users(username, password, balance) VALUES ('Jesper', 'Petersen', 100);
INSERT INTO users(username, password, balance) VALUES ('Henrik', 'Agger', 100);
INSERT INTO users(username, password, balance) VALUES ('Claus', 'Kramath', 100);
-- bottoms
INSERT INTO bottoms(name, price) VALUES ('Chocolate', 5);
INSERT INTO bottoms(name, price) VALUES ('Vanilla', 5);
INSERT INTO bottoms(name, price) VALUES ('Nutmeg', 5);
INSERT INTO bottoms(name, price) VALUES ('Pistacio', 6);
INSERT INTO bottoms(name, price) VALUES ('Almond', 7);
-- toppings
INSERT INTO toppings(name, price) VALUES ('Chocolate', 5);
INSERT INTO toppings(name, price) VALUES ('Blueberry', 5);
INSERT INTO toppings(name, price) VALUES ('Raspberry', 5);
INSERT INTO toppings(name, price) VALUES ('Crispy', 6);
INSERT INTO toppings(name, price) VALUES ('Strawberry', 6);
INSERT INTO toppings(name, price) VALUES ('Rum/Raisin', 7);
INSERT INTO toppings(name, price) VALUES ('Orange', 8);
INSERT INTO toppings(name, price) VALUES ('Lemon', 8);
INSERT INTO toppings(name, price) VALUES ('Blue cheese', 9);
-- orders
INSERT INTO orders(userId) VALUES(1);
INSERT INTO orders(userId) VALUES(2);
INSERT INTO orders(userId) VALUES(3);
-- line items, order 1
INSERT INTO lineitems(orderId, toppingId, bottomId, qty, price) VALUES(1, 1, 2, 2, 10);
INSERT INTO lineitems(orderId, toppingId, bottomId, qty, price) VALUES(1, 4, 3, 1, 12);
INSERT INTO lineitems(orderId, toppingId, bottomId, qty, price) VALUES(1, 5, 8, 1, 15);