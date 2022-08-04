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

/*Data for the table `log` */

insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('0aa3a5bc131711edaa3e049226144726','2022-08-03 18:28:40','tom','0:0:0:0:0:0:0:1','/user/findAll.do',4,'[类名]：vip.hyhforever.ssm.controller.UserController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('1a1b791413bc11ed8fc1049226144726','2022-08-04 14:10:13','tom','0:0:0:0:0:0:0:1','/user/findAll.do',16,'[类名]：vip.hyhforever.ssm.controller.UserController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('2b2f05d2131911edaa3e049226144726','2022-08-03 18:43:54','tom','0:0:0:0:0:0:0:1','/sysLog/findAll.do',19,'[类名]：vip.hyhforever.ssm.controller.SysLogController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('2ee52e44131911edaa3e049226144726','2022-08-03 18:44:00','tom','0:0:0:0:0:0:0:1','/sysLog/findAll.do',5,'[类名]：vip.hyhforever.ssm.controller.SysLogController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('31ec91b8131911edaa3e049226144726','2022-08-03 18:44:05','tom','0:0:0:0:0:0:0:1','/sysLog/findAll.do',4,'[类名]：vip.hyhforever.ssm.controller.SysLogController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('33facc4c131911edaa3e049226144726','2022-08-03 18:44:09','tom','0:0:0:0:0:0:0:1','/sysLog/findAll.do',4,'[类名]：vip.hyhforever.ssm.controller.SysLogController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('391f25e0131911edaa3e049226144726','2022-08-03 18:44:17','tom','0:0:0:0:0:0:0:1','/sysLog/findAll.do',6,'[类名]：vip.hyhforever.ssm.controller.SysLogController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('7a0c456f13b611ed8fc1049226144726','2022-08-04 13:29:57','tom','0:0:0:0:0:0:0:1','/user/findAll.do',17,'[类名]：vip.hyhforever.ssm.controller.UserController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('8182be0213b611ed8fc1049226144726','2022-08-04 13:30:10','tom','0:0:0:0:0:0:0:1','/role/findAll.do',10,'[类名]：vip.hyhforever.ssm.controller.RoleController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('8450f45f13b611ed8fc1049226144726','2022-08-04 13:30:14','tom','0:0:0:0:0:0:0:1','/product/findAll.do',16,'[类名]：vip.hyhforever.ssm.controller.ProductController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('865ae1ca13b611ed8fc1049226144726','2022-08-04 13:30:18','tom','0:0:0:0:0:0:0:1','/orders/findAll.do',0,'[类名]：vip.hyhforever.ssm.controller.OrdersController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('c657123d13b611ed8fc1049226144726','2022-08-04 13:32:05','tom','0:0:0:0:0:0:0:1','/product/findAll.do',28,'[类名]：vip.hyhforever.ssm.controller.ProductController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('c800618c13b611ed8fc1049226144726','2022-08-04 13:32:08','tom','0:0:0:0:0:0:0:1','/product/findAll.do',7,'[类名]：vip.hyhforever.ssm.controller.ProductController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('d42a3e6e13b611ed8fc1049226144726','2022-08-04 13:32:28','tom','0:0:0:0:0:0:0:1','/user/findAll.do',13,'[类名]：vip.hyhforever.ssm.controller.UserController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('d4fbfe3113b611ed8fc1049226144726','2022-08-04 13:32:30','tom','0:0:0:0:0:0:0:1','/user/findAll.do',24,'[类名]：vip.hyhforever.ssm.controller.UserController[方法名：]findAll');
insert  into `log`(`id`,`visitTime`,`username`,`ip`,`url`,`executionTime`,`method`) values ('d8310834fced11ec8b25049226144726','2022-07-06 13:38:20','username','192.168.0.1','http://www.baidu.om',5,'fimdAll()');

/*Data for the table `member` */

insert  into `member`(`id`,`name`,`nickName`,`phoneNum`,`email`) values ('32b5087ffcee11ec8b25049226144726','Jack','Joker','13119046937','241343123@qq.com');

/*Data for the table `order` */

insert  into `order`(`id`,`orderNum`,`orderTime`,`peopleCount`,`orderDesc`,`payType`,`orderStatus`,`productId`,`memberId`) values ('f365ef51fcee11ec8b25049226144726','202207061200003','2022-07-06 13:46:15',100,'100人旅游团出发前往北海道',0,1,'03b2b6ce064511ed817f049226144726','3');

/*Data for the table `order_traveller` */

insert  into `order_traveller`(`orderId`,`travellerId`) values ('f365ef51fcee11ec8b25049226144726','007964d1fcf111ec8b25049226144726');

/*Data for the table `permission` */

insert  into `permission`(`id`,`permissionName`,`url`) values ('1a58176efcf011ec8b25049226144726','管理员','http://www.hyhforever.vip');
insert  into `permission`(`id`,`permissionName`,`url`) values ('9dba7e7f121511ed91ea049226144726','ROOT','www.google.com');
insert  into `permission`(`id`,`permissionName`,`url`) values ('b292abf2118811ed94c1049226144726','普通用户','http://www.hyhforever.vip');

/*Data for the table `product` */

insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`DepartureTime`,`productPrice`,`productDesc`,`productStatus`) values ('03b2b6ce064511ed817f049226144726','info123','日月潭一日游','乌鲁木齐','10:50:00',9999,'越芜湖，越芜湖',1);
insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`DepartureTime`,`productPrice`,`productDesc`,`productStatus`) values ('3a822639fcec11ec8b25049226144726','productNum','productName','cityName','13:26:46',10.2,'productDesc',0);
insert  into `product`(`id`,`productNum`,`productName`,`cityName`,`DepartureTime`,`productPrice`,`productDesc`,`productStatus`) values ('9c00773bfcf011ec8b25049226144726','123456','漠河-北海道','漠河','13:58:08',666.6,'傻逼才去',1);

/*Data for the table `role` */

insert  into `role`(`id`,`roleName`,`roleDesc`) values ('22def525119111ed94c1049226144726','ROOT','根权限');
insert  into `role`(`id`,`roleName`,`roleDesc`) values ('a5213eaa0e3c11ed8fb5049226144726','ADMIN','管理员');
insert  into `role`(`id`,`roleName`,`roleDesc`) values ('c36424c1fcf011ec8b25049226144726','USER','普通用户');

/*Data for the table `role_permission` */

insert  into `role_permission`(`permissionId`,`roleId`) values ('1a58176efcf011ec8b25049226144726','c36424c1fcf011ec8b25049226144726');
insert  into `role_permission`(`permissionId`,`roleId`) values ('9dba7e7f121511ed91ea049226144726','c36424c1fcf011ec8b25049226144726');
insert  into `role_permission`(`permissionId`,`roleId`) values ('b292abf2118811ed94c1049226144726','c36424c1fcf011ec8b25049226144726');

/*Data for the table `travellers` */

insert  into `travellers`(`id`,`name`,`sex`,`phoneNum`,`credentialsType`,`credentialsNum`,`travellerType`) values ('007964d1fcf111ec8b25049226144726','韩金龙','男','1234445623',0,'622434198808094532',0);

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`username`,`password`,`phoneNum`,`status`) values ('4aba0843fcf111ec8b25049226144726','23351241@qq.com','jokershaco','$2a$10$.29EwF4Uhm6zV5ZCV4isu.zVnBqhle6XYWlmM7brncbVZgqhDLY.W','2341245123',1);
insert  into `user`(`id`,`email`,`username`,`password`,`phoneNum`,`status`) values ('96de89420f4411ed85e4049226144726','jinx123456@qq.com','jinx','$2a$10$4jR3LuZ38/8K7QVRSUaZR.plHsmCfwFbxCHo2dtm3I5pLXd30Q6oO','13119046941',1);
insert  into `user`(`id`,`email`,`username`,`password`,`phoneNum`,`status`) values ('c49cb6230e3c11ed8fb5049226144726','1557119917@qq.com','tom','$2a$10$5U2fDosN7I52nbJl/8BJ4uYxjA.shCE1Xq/MwgDjBWMoB2hr4N1h.','13119046938',1);
insert  into `user`(`id`,`email`,`username`,`password`,`phoneNum`,`status`) values ('f103fdf70e3c11ed8fb5049226144726','2557928402@qq.com','jack','$2a$10$NteB4o7BiKnyle/m4zqMpOrVh9J6J9CEgDkfZZjShA/C407l/7cLC','13119046939',0);
insert  into `user`(`id`,`email`,`username`,`password`,`phoneNum`,`status`) values ('f10645460e3c11ed8fb5049226144726','hyh66sex@163.com','frank','$2a$10$luwnL2KBCZTA8LPbLfes1.GjA.K9Yin0GkesKgin1df1UFKFLVagK','13119046940',1);

/*Data for the table `users_role` */

insert  into `users_role`(`userId`,`roleId`) values ('4aba0843fcf111ec8b25049226144726','22def525119111ed94c1049226144726');
insert  into `users_role`(`userId`,`roleId`) values ('96de89420f4411ed85e4049226144726','a5213eaa0e3c11ed8fb5049226144726');
insert  into `users_role`(`userId`,`roleId`) values ('c49cb6230e3c11ed8fb5049226144726','a5213eaa0e3c11ed8fb5049226144726');
insert  into `users_role`(`userId`,`roleId`) values ('4aba0843fcf111ec8b25049226144726','c36424c1fcf011ec8b25049226144726');
insert  into `users_role`(`userId`,`roleId`) values ('c49cb6230e3c11ed8fb5049226144726','c36424c1fcf011ec8b25049226144726');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
