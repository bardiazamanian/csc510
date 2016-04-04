USE csc510;
DROP TABLE IF EXISTS shopping_cart;

CREATE TABLE shopping_cart (id INT NOT NULL AUTO_INCREMENT,
	item VARCHAR(30) NOT NULL,
	item_count INT NOT NULL,
	item_price FLOAT,
	PRIMARY KEY (id));

INSERT INTO shopping_cart values (default, 'apples',2, 0.75);
INSERT INTO shopping_cart values (default, 'whole milk',1, 5.25);