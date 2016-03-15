USE csc510;
DROP TABLE IF EXISTS grocery_store_inventory;
CREATE TABLE grocery_store_inventory ( id INT NOT NULL AUTO_INCREMENT,
	item VARCHAR(30) NOT NULL,
	item_count INT NOT NULL,
	item_price FLOAT,
	store VARCHAR(30),	
	aisle INT,
	shelving_unit INT,
	shelf INT,
	PRIMARY KEY (id));

INSERT INTO grocery_store_inventory values (default, 'bananas',100, 2.30, 'Kroger', 1, 1, 1);
INSERT INTO grocery_store_inventory values (default, 'oranges',100, 1.55, 'Kroger', 1, 1, 2);
INSERT INTO grocery_store_inventory values (default, 'apples',100, 0.75, 'Kroger', 1, 1, 3);
INSERT INTO grocery_store_inventory values (default, 'lettuce',100, 2.75, 'Kroger', 1, 1, 4);
INSERT INTO grocery_store_inventory values (default, 'squash',100, 1.75, 'Kroger', 1, 2, 1);
INSERT INTO grocery_store_inventory values (default, 'whole milk',100, 5.25, 'Kroger', 10, 4, 5);
INSERT INTO grocery_store_inventory values (default, 'orange juice',100, 3.11, 'Kroger', 10, 3, 3);
INSERT INTO grocery_store_inventory values (default, 'apple juice',100, 4.23, 'Kroger', 10, 3, 4);
INSERT INTO grocery_store_inventory values (default, 'beer',100, 9.65, 'Kroger', 7, 6, 2);
INSERT INTO grocery_store_inventory values (default, 'Coke Cola',100, 4.25, 'Kroger', 8, 2, 1);

INSERT INTO grocery_store_inventory values (default, 'Applejacks cereal',100, 2.34, 'Food Lion', 8, 3, 4);
INSERT INTO grocery_store_inventory values (default, 'eggs',100, 1.89, 'Kroger', 4, 10, 3);
INSERT INTO grocery_store_inventory values (default, 'sausage',100, 2.75, 'Food Lion', 3, 11, 2);
INSERT INTO grocery_store_inventory values (default, 'bacon',100, 1.49, 'Kroger', 3, 2, 3);
INSERT INTO grocery_store_inventory values (default, 'Lays Potate Chips',100, 3.45, 'Kroger', 6, 2, 1);
INSERT INTO grocery_store_inventory values (default, 'Ruffles Potate Chips',100, 3.87, 'Food Lion', 7, 7, 3);
INSERT INTO grocery_store_inventory values (default, 'peanut butter',100, 2.16, 'Kroger', 2, 1, 3);
INSERT INTO grocery_store_inventory values (default, 'grape jelly',100, 3.29, 'Kroger', 2, 2, 4);
INSERT INTO grocery_store_inventory values (default, 'white bread',100, 4.78, 'Food Lion', 7, 7, 5);
INSERT INTO grocery_store_inventory values (default, 'wheat bread',100, 4.13, 'Kroger', 3, 8, 3);

INSERT INTO grocery_store_inventory values (default, 'hamburger', 100, 7.99, 'Food Lion', 6, 2, 4);
INSERT INTO grocery_store_inventory values (default, 'ribeye steak',100, 10.89, 'Kroger', 5, 12, 1);
INSERT INTO grocery_store_inventory values (default, 'roast beef',100, 6.75, 'Food Lion', 6, 2, 3);
INSERT INTO grocery_store_inventory values (default, 'lamb',100, 4.49, 'Kroger', 5, 2, 3);
INSERT INTO grocery_store_inventory values (default, 'chicken breast',100, 7.45, 'Kroger', 7, 1, 5);
INSERT INTO grocery_store_inventory values (default, 'chicken whole',100, 13.27, 'Food Lion', 6, 2, 2);
INSERT INTO grocery_store_inventory values (default, 'hamburger bun',100, 3.16, 'Kroger', 2, 2, 2);
INSERT INTO grocery_store_inventory values (default, 'ketup',100, 3.29, 'Kroger', 9, 1, 4);
INSERT INTO grocery_store_inventory values (default, 'mustard',100, 4.78, 'Food Lion', 8, 2, 5);
INSERT INTO grocery_store_inventory values (default, 'mayo',100, 4.13, 'Kroger', 4, 8, 3);

INSERT INTO grocery_store_inventory values (default, 'white rice', 100, 4.99, 'Food Lion', 8, 8, 1);
INSERT INTO grocery_store_inventory values (default, 'green beans', 100, 3.89, 'Kroger', 6, 7, 3);
INSERT INTO grocery_store_inventory values (default, 'brown rice',100, 2.75, 'Food Lion', 8, 1, 3);
INSERT INTO grocery_store_inventory values (default, 'rolls',100, 4.49, 'Kroger', 2, 8, 3);
INSERT INTO grocery_store_inventory values (default, 'american cheese',100, 3.45, 'Kroger', 2, 7, 3);
INSERT INTO grocery_store_inventory values (default, 'chedar cheese',100, 3.27, 'Food Lion', 3, 3, 3);
INSERT INTO grocery_store_inventory values (default, 'swiss cheese',100, 3.16, 'Kroger', 8, 7, 4);
INSERT INTO grocery_store_inventory values (default, 'goat cheese',100, 3.29, 'Kroger', 10, 2, 3);
INSERT INTO grocery_store_inventory values (default, 'spaghetti',100, 4.78, 'Food Lion', 9, 1, 5);
INSERT INTO grocery_store_inventory values (default, 'meat sauce',100, 4.13, 'Kroger', 6, 9, 2);

INSERT INTO grocery_store_inventory values (default, 'graham crackers', 100, 4.99, 'Food Lion', 7, 7, 3);
INSERT INTO grocery_store_inventory values (default, 'table crackers', 100, 3.89, 'Kroger', 4, 2, 1);
INSERT INTO grocery_store_inventory values (default, 'cheezit',100, 2.75, 'Food Lion', 3, 8, 2);
INSERT INTO grocery_store_inventory values (default, 'cookies',100, 4.49, 'Kroger', 6, 8, 3);
INSERT INTO grocery_store_inventory values (default, 'donuts',100, 3.45, 'Kroger', 6, 7, 3);
INSERT INTO grocery_store_inventory values (default, 'chocolate cake',100, 3.27, 'Food Lion', 4, 4, 4);
INSERT INTO grocery_store_inventory values (default, 'gold fish',100, 3.16, 'Kroger', 9, 1, 4);
INSERT INTO grocery_store_inventory values (default, 'fish',100, 3.29, 'Kroger', 2, 2, 5);
INSERT INTO grocery_store_inventory values (default, 'lance crackers',100, 4.78, 'Food Lion', 7, 3, 5);
INSERT INTO grocery_store_inventory values (default, 'ranch dressing',100, 4.13, 'Kroger', 7, 9, 2);