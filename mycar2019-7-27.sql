/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.11 : Database - mycar
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mycar` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mycar`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customerid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) NOT NULL DEFAULT '0' COMMENT '客户名称',
  `sex` char(2) NOT NULL DEFAULT '0' COMMENT '性别',
  `phone` char(15) NOT NULL DEFAULT '0' COMMENT '手机号',
  `carnum` char(10) NOT NULL DEFAULT '0' COMMENT '车牌号',
  `address` varchar(50) NOT NULL DEFAULT '0' COMMENT '地址',
  `createtime` date NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`customerid`),
  KEY `name` (`name`),
  KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=1564205884833 DEFAULT CHARSET=utf8 COMMENT='客户表';

/*Data for the table `customer` */

insert  into `customer`(`customerid`,`name`,`sex`,`phone`,`carnum`,`address`,`createtime`) values (1,'11','1','13240714417','1111','111','2019-07-27'),(1564205884832,'阿松大','1','21e','却微乎其微','1212313','2019-07-27');

/*Table structure for table `repair` */

DROP TABLE IF EXISTS `repair`;

CREATE TABLE `repair` (
  `repairid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item` char(20) NOT NULL DEFAULT '0' COMMENT '维修项目',
  `partscode` varchar(40) DEFAULT '0' COMMENT '配件编码',
  `partsname` varchar(20) DEFAULT '0' COMMENT '配件名称',
  `partsprice` float DEFAULT '0' COMMENT '配件单价',
  `cost` float NOT NULL DEFAULT '0' COMMENT '费用',
  `createtime` date NOT NULL COMMENT '创建维修单时间',
  `customerid` bigint(20) NOT NULL COMMENT '客户id',
  PRIMARY KEY (`repairid`),
  KEY `item` (`item`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='维修表';

/*Data for the table `repair` */

insert  into `repair`(`repairid`,`item`,`partscode`,`partsname`,`partsprice`,`cost`,`createtime`,`customerid`) values (1,'aweq','qweq','qweq',121,1212,'2019-07-27',1),(2,'121','sadfa','asfdas',11,212,'2019-07-27',1),(5,'12额',NULL,NULL,NULL,1212,'2019-07-27',1564205884832);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
