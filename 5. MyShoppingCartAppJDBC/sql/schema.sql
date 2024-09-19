-- Cambiando la configuración de MySQL
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Creando tabla `producto`
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
                            `pid` int(11) NOT NULL AUTO_INCREMENT,
                            `codigo` int(11) NOT NULL,
                            `marca` varchar(255) NOT NULL,
                            `nombre` varchar(40) NOT NULL,  -- Cambié "Nombre" a minúscula para consistencia
                            `tipo` varchar(20) DEFAULT NULL,
                            `precio` double NOT NULL,
                            `existencias` int(11) DEFAULT NULL,
                            PRIMARY KEY (`pid`),
                            UNIQUE KEY `pid_UNIQUE` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Creando tabla `usuario`
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
                           `uid` int(11) NOT NULL AUTO_INCREMENT,
                           `nombre` varchar(30) NOT NULL,
                           `apellido` varchar(30) NOT NULL,
                           `email` varchar(255) NOT NULL,
                           `interes` int(11) NOT NULL,
                           `saldo` int(11) DEFAULT NULL,
                           `password` text NOT NULL,
                           `nacimiento` datetime DEFAULT NULL,
                           `activo` tinyint(1) DEFAULT NULL,
                           PRIMARY KEY (`uid`),
                           UNIQUE KEY `uid_UNIQUE` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Creando tabla `almacen`
DROP TABLE IF EXISTS `almacen`;
CREATE TABLE `almacen` (
                           `aid` int(11) NOT NULL AUTO_INCREMENT,
                           `producto` int(11) NOT NULL,
                           `cantidad` int(11) NOT NULL,
                           PRIMARY KEY (`aid`),
                           UNIQUE KEY `aid_UNIQUE` (`aid`),
                           KEY `fk_almacen_producto_idx` (`producto`),
                           CONSTRAINT `fk_almacen_producto`
                               FOREIGN KEY (`producto`) REFERENCES `producto` (`pid`)
                                   ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Creando tabla `compra`
DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
                          `cid` int(11) NOT NULL AUTO_INCREMENT,
                          `usuario` int(11) NOT NULL,
                          `producto` int(11) NOT NULL,
                          `cantidad` int(11) NOT NULL,
                          `fecha` timestamp NULL DEFAULT NULL,
                          PRIMARY KEY (`cid`),
                          UNIQUE KEY `cid_UNIQUE` (`cid`),
                          KEY `fk_compra_usuario_idx` (`usuario`),
                          KEY `fk_compra_producto_idx` (`producto`),
                          CONSTRAINT `fk_compra_producto`
                              FOREIGN KEY (`producto`) REFERENCES `producto` (`pid`)
                                  ON DELETE NO ACTION ON UPDATE NO ACTION,
                          CONSTRAINT `fk_compra_usuario`
                              FOREIGN KEY (`usuario`) REFERENCES `usuario` (`uid`)
                                  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- Restaurar las configuraciones originales
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
