CREATE SCHEMA `schooldb` ;

USE mysql;

CREATE USER 'schooluser'@'%' IDENTIFIED BY 'school123';

GRANT ALL PRIVILEGES ON schooldb.* TO 'schooluser'@'%';
FLUSH PRIVILEGES;

--       GRANT ALL ON schooldb.* TO 'schooluser'@'localhost' IDENTIFIED BY 'school123' WITH GRANT OPTION;