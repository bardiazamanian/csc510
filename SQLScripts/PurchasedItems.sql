USE csc510;
DROP TABLE IF EXISTS purchased_items;

CREATE TABLE purchased_items (pid INT NOT NULL AUTO_INCREMENT,
	item VARCHAR(30) NOT NULL,
    date_purchased DATETIME NOT NULL,
	PRIMARY KEY (pid));

INSERT INTO purchased_items values (default, 'orange juice', '2016-03-28 10:34:09');
INSERT INTO purchased_items values (default, 'apple juice', '2016-03-27 15:34:09');
INSERT INTO purchased_items values (default, 'beer', '2016-03-26 17:34:09');
INSERT INTO purchased_items values (default, 'Coke Cola', '2016-03-26 22:34:09');
INSERT INTO purchased_items values (default, 'bread', '2016-03-27 10:34:09');
INSERT INTO purchased_items values (default, 'butter', '2016-03-12 22:34:09');
INSERT INTO purchased_items values (default,  'watermelon', '2016-03-02 10:34:09');
