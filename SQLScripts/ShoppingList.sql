USE csc510;
DROP TABLE IF EXISTS shopping_list;

CREATE TABLE shopping_list (id INT NOT NULL AUTO_INCREMENT,
	item VARCHAR(30) NOT NULL,
	item_count INT NOT NULL,
	item_price FLOAT,
	PRIMARY KEY (id));

USE csc510;
DROP TABLE IF EXISTS previous_shopping_list;

CREATE TABLE previous_shopping_list (id INT NOT NULL AUTO_INCREMENT,
	item VARCHAR(30) NOT NULL,
	item_count INT NOT NULL,
	item_price FLOAT,
	PRIMARY KEY (id));