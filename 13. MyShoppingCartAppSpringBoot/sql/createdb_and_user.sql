-- Crear el esquema (base de datos)
CREATE SCHEMA `productos_db_jpa`;

-- Seleccionar la base de datos para trabajar con ella
USE productos_db_jpa;

-- Crear el usuario con un host local
CREATE USER 'productos_user'@'localhost' IDENTIFIED BY 'prod123';

-- Otorgar todos los privilegios al usuario para la base de datos productos_db
GRANT ALL PRIVILEGES ON productos_db_jpa.* TO 'productos_user'@'localhost';

-- Aplicar los cambios de privilegios
FLUSH PRIVILEGES;
