-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 mycar 的数据库结构
CREATE DATABASE IF NOT EXISTS `mycar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mycar`;


-- 导出  表 mycar.customer 结构
CREATE TABLE IF NOT EXISTS `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(20) NOT NULL DEFAULT '0' COMMENT '客户编码',
  `name` varchar(20) NOT NULL DEFAULT '0' COMMENT '客户名称',
  `sex` smallint(6) NOT NULL DEFAULT '0' COMMENT '性别',
  `phone` char(15) NOT NULL DEFAULT '0' COMMENT '手机号',
  `carnum` char(10) NOT NULL DEFAULT '0' COMMENT '车牌号',
  `address` varchar(50) NOT NULL DEFAULT '0' COMMENT '地址',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`customerid`),
  KEY `code` (`code`),
  KEY `name` (`name`),
  KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- 正在导出表  mycar.customer 的数据：~0 rows (大约)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- 导出  表 mycar.repair 结构
CREATE TABLE IF NOT EXISTS `repair` (
  `repairid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` char(20) NOT NULL DEFAULT '0' COMMENT '维修编码',
  `item` char(20) NOT NULL DEFAULT '0' COMMENT '维修项目',
  `partscode` varchar(40) DEFAULT '0' COMMENT '配件编码',
  `partsname` varchar(20) DEFAULT '0' COMMENT '配件名称',
  `partsprice` float DEFAULT '0' COMMENT '配件单价',
  `cost` float NOT NULL DEFAULT '0' COMMENT '费用',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建维修单时间',
  `customerid` int(11) NOT NULL COMMENT '客户id',
  PRIMARY KEY (`repairid`),
  KEY `code` (`code`),
  KEY `item` (`item`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修表';

-- 正在导出表  mycar.repair 的数据：~0 rows (大约)
DELETE FROM `repair`;
/*!40000 ALTER TABLE `repair` DISABLE KEYS */;
/*!40000 ALTER TABLE `repair` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
