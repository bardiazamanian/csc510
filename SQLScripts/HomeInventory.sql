USE csc510;
DROP TABLE IF EXISTS home_inventory;

CREATE TABLE home_inventory (id INT NOT NULL AUTO_INCREMENT,
	item VARCHAR(30) NOT NULL,
	item_count INT NOT NULL,
	PRIMARY KEY (id));

INSERT INTO home_inventory values (default, 'apples', 2);
INSERT INTO home_inventory values (default, 'whole milk', 1);
INSERT INTO home_inventory values (default, 'Lays Potate Chips', 1);
INSERT INTO home_inventory values (default, 'grape jelly', 1);
INSERT INTO home_inventory values (default, 'lamb', 1);