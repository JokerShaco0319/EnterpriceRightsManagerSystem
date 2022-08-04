/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.22 : Database - ssmmanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssmmanager` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ssmmanager`;

/*Table structure for table `log` */

CREATE TABLE `log` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `visitTime` timestamp NULL DEFAULT NULL COMMENT '访问时间',
  `username` varchar(20) DEFAULT NULL COMMENT '操作者用户名',
  `ip` varchar(50) DEFAULT NULL COMMENT '访问ip',
  `url` varchar(100) DEFAULT NULL COMMENT '访问资源url',
  `executionTime` int DEFAULT NULL COMMENT '执行时长',
  `method` varchar(100) DEFAULT NULL COMMENT '访问方法',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `member` */

CREATE TABLE `member` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `nickName` varchar(20) DEFAULT NULL COMMENT '昵称',
  `phoneNum` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `order` */

CREATE TABLE `order` (
  `id` varchar(32) NOT NULL COMMENT '无意义，主键uuid',
  `orderNum` varchar(50) NOT NULL COMMENT '订单编号 不为空 唯一',
  `orderTime` timestamp NULL DEFAULT NULL COMMENT '下单时间',
  `peopleCount` int DEFAULT NULL COMMENT '出行人数',
  `orderDesc` varchar(500) DEFAULT NULL COMMENT '订单描述（其他信息）',
  `payType` int DEFAULT NULL COMMENT '支付方式0支付宝1微信2其他',
  `orderStatus` int DEFAULT NULL COMMENT '订单状态0未支付1已支付',
  `productId` varchar(32) DEFAULT NULL COMMENT '产品id外键',
  `memberId` varchar(32) DEFAULT NULL COMMENT '会员id外键',
  PRIMARY KEY (`id`),
  UNIQUE KEY `orderNum` (`orderNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `order_traveller` */

CREATE TABLE `order_traveller` (
  `orderId` varchar(32) NOT NULL COMMENT '订单Id',
  `travellerId` varchar(32) NOT NULL COMMENT '旅客id',
  PRIMARY KEY (`orderId`,`travellerId`),
  KEY `travellerId` (`travellerId`),
  CONSTRAINT `order_traveller_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`),
  CONSTRAINT `order_traveller_ibfk_2` FOREIGN KEY (`travellerId`) REFERENCES `travellers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `permission` */

CREATE TABLE `permission` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `permissionName` varchar(20) DEFAULT NULL COMMENT '权限名',
  `url` varchar(100) DEFAULT NULL COMMENT '资源路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `product` */

CREATE TABLE `product` (
  `id` varchar(32) NOT NULL COMMENT '无意义，主键uuid',
  `productNum` varchar(50) NOT NULL COMMENT '产品编号，唯一，不为空',
  `productName` varchar(50) DEFAULT NULL COMMENT '产品名称（路线名称）',
  `cityName` varchar(50) DEFAULT NULL COMMENT '出发城市',
  `DepartureTime` time DEFAULT NULL COMMENT '出发时间',
  `productPrice` float DEFAULT NULL COMMENT '产品价格',
  `productDesc` varchar(500) DEFAULT NULL COMMENT '产品描述',
  `productStatus` int DEFAULT NULL COMMENT '状态（0关闭1开启）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `productNum` (`productNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `role` */

CREATE TABLE `role` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `roleName` varchar(20) DEFAULT NULL COMMENT '角色名',
  `roleDesc` varchar(500) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `role_permission` */

CREATE TABLE `role_permission` (
  `permissionId` varchar(32) NOT NULL,
  `roleId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色Id\n',
  PRIMARY KEY (`permissionId`,`roleId`),
  KEY `role_permission_role_id_fk` (`roleId`),
  CONSTRAINT `role_permission_permission_id_fk` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `role_permission_role_id_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和权限多对多关系的中间表';

/*Table structure for table `travellers` */

CREATE TABLE `travellers` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(20) DEFAULT NULL COMMENT '性别',
  `phoneNum` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `credentialsType` int DEFAULT NULL COMMENT '证件类型0身份证1护照2军官证',
  `credentialsNum` varchar(50) DEFAULT NULL COMMENT '证件号码',
  `travellerType` int DEFAULT NULL COMMENT '旅客类型0成人1儿童',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `user` */

CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '主键uuid',
  `email` varchar(50) NOT NULL COMMENT '非空 唯一',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码 加密 加密后长度固定位60',
  `phoneNum` varchar(20) DEFAULT NULL COMMENT '电话',
  `status` int DEFAULT NULL COMMENT '状态0未开启1已开启',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `users_role` */

CREATE TABLE `users_role` (
  `userId` varchar(32) NOT NULL,
  `roleId` varchar(32) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表和用户表的多对多中间表';

/* Trigger structure for table `log` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_log` BEFORE INSERT ON `log` FOR EACH ROW BEGIN
	set new.id=replace(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `member` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_member` BEFORE INSERT ON `member` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `order` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_order` BEFORE INSERT ON `order` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `permission` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_permission` BEFORE INSERT ON `permission` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `product` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_product` BEFORE INSERT ON `product` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `role` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_role` BEFORE INSERT ON `role` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `travellers` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_travellers` BEFORE INSERT ON `travellers` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/* Trigger structure for table `user` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `id_user` BEFORE INSERT ON `user` FOR EACH ROW BEGIN
	SET new.id=REPLACE(UUID(),'-','');
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
