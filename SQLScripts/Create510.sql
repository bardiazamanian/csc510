CREATE DATABASE csc510;
USE csc510;

CREATE USER sqluser IDENTIFIED BY 'sqluserpw'; 

grant usage on *.* to sqluser@localhost identified by 'sqluserpw'; 
grant all privileges on csc510.* to sqluser@localhost; 