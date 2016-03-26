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
    
INSERT INTO shopping_list values (default, 'bananas',1, 2.30);
INSERT INTO shopping_list values (default, 'oranges',1, 1.55);
INSERT INTO shopping_list values (default, 'apples',1, 0.75);
INSERT INTO shopping_list values (default, 'lettuce',1, 2.75);
INSERT INTO shopping_list values (default, 'squash',1, 1.75);
INSERT INTO shopping_list values (default, 'whole milk',1, 5.25);

INSERT INTO previous_shopping_list values (default, 'orange juice',1, 3.11);
INSERT INTO previous_shopping_list values (default, 'apple juice',1, 4.23);
INSERT INTO previous_shopping_list values (default, 'beer',1, 9.65);
INSERT INTO previous_shopping_list values (default, 'Coke Cola',1, 4.25);