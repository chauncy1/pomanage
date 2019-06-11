/*
Navicat MySQL Data Transfer

Source Server         : Connect_3
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : day15

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-05-29 10:17:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accrue_records
-- ----------------------------
DROP TABLE IF EXISTS `accrue_records`;
CREATE TABLE `accrue_records` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ACCRUE_COMMENTS` varchar(255) NOT NULL COMMENT 'ACCRUE操作备注',
  `ACCRUE_AMOUNT` float(8,2) NOT NULL COMMENT '操作单次人天变更数量',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `LASTUPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `CREAT_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者',
  `LASTUPDATE_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新者',
  `PO_ID` bigint(20) NOT NULL COMMENT 'PO主表ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accrue_records
-- ----------------------------

-- ----------------------------
-- Table structure for consultant_info
-- ----------------------------
DROP TABLE IF EXISTS `consultant_info`;
CREATE TABLE `consultant_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DELETE_FLAG` bigint(20) NOT NULL DEFAULT '1' COMMENT '删除状态',
  `EMP_NAME` varchar(50) NOT NULL COMMENT '顾问名',
  `EMP_NO` bigint(25) NOT NULL COMMENT '顾问NO',
  `EMP_RATE` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '顾问rate',
  `EMP_TYPE` varchar(25) NOT NULL COMMENT '顾问类型',
  `TOTAL_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '顾问总人天',
  `EMP_LEVEL` varchar(25) NOT NULL COMMENT '顾问等级',
  `EMP_COMMENT` varchar(25) DEFAULT NULL COMMENT '顾问comment',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `LASTUPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `CREAT_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者',
  `LASTUPDATE_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新者',
  `ROLE_ID` bigint(20) NOT NULL COMMENT 'ROLE主表ID',
  `TOTAL_AMOUNT` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '顾问总人天',
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consultant_info
-- ----------------------------
INSERT INTO `consultant_info` VALUES ('12', '1', 'one', '100006', '200.00', 'JTP', '20.00', 'X1', '32', '2019-05-28 17:03:50', '2019-05-28 17:03:50', '0', '0', '21', '4000.00', '2019-05-28 00:00:00', '2019-05-30 00:00:00');

-- ----------------------------
-- Table structure for po_info
-- ----------------------------
DROP TABLE IF EXISTS `po_info`;
CREATE TABLE `po_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DELETE_FLAG` bigint(20) NOT NULL DEFAULT '1' COMMENT '删除状态',
  `CODE` bigint(20) NOT NULL COMMENT 'CODE',
  `PO_NAME` varchar(50) NOT NULL COMMENT '项目名称',
  `START_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'PO开始时间',
  `END_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'PO结束时间',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `LASTUPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `CREAT_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者',
  `LASTUPDATE_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新者',
  `PO_NO` varchar(10) NOT NULL DEFAULT '0' COMMENT '订单代码',
  `PO_DESC` varchar(200) NOT NULL DEFAULT 'NULL' COMMENT 'PO描述',
  `CONTENT_TYPE` varchar(200) NOT NULL DEFAULT 'NULL' COMMENT 'PO类型',
  `PO_STATUS` varchar(12) NOT NULL DEFAULT 'Close' COMMENT 'PO状态',
  `PO_INITIAL_TOTAL_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT 'PO初始总人天',
  `PO_TOTAL_AMOUNT_EX` float(8,2) NOT NULL DEFAULT '0.00' COMMENT 'PO总金额（不含税)',
  `PO_TOTAL_AMOUNT_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT 'PO总金额（含税)',
  `BILLED_AMT_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '已用金额（含税）',
  `PO_AVAILABLE_AMT_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '可用金额（不含税）',
  `TOTAL_BURNED_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '总使用人天',
  `BALANCE_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '未使用人天',
  `VAT` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '税率',
  `PROJECT_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT 'project主表ID',
  `PO_COMMENT` varchar(200) NOT NULL DEFAULT '无' COMMENT 'po备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of po_info
-- ----------------------------
INSERT INTO `po_info` VALUES ('4', '1', '64123', 'xfgb ', '2019-05-22 09:54:43', '2018-12-29 00:00:00', '2018-12-06 00:00:54', '2018-12-06 00:00:54', '-1', '-1', '1234567890', 'rth', 'T&M', 'Stop', '12.00', '72.00', '76.32', '146.28', '-69.96', '24.00', '-12.00', '6.00', '1', '无');
INSERT INTO `po_info` VALUES ('5', '1', '64123', 'efer', '2018-12-06 00:54:42', '2018-12-28 00:00:00', '2018-12-06 00:23:31', '2018-12-06 00:23:31', '-1', '-1', '232332', 'erge', 'Fixed Price', 'Stop', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '-8.00', '1', '无');
INSERT INTO `po_info` VALUES ('7', '1', '64123', 'xcf', '2019-05-22 09:54:46', '2018-12-21 00:00:00', '2018-12-06 01:28:58', '2018-12-06 01:28:58', '-1', '-1', '1234561', 'AS', 'T&M', 'Close', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '20.00', '1', '无');
INSERT INTO `po_info` VALUES ('14', '1', '64123', 'xfgb2', '2019-05-22 00:00:00', '2019-05-28 00:00:00', '2019-05-28 10:53:21', '2019-05-28 10:53:21', '-1', '-1', '1234567899', 'sad', 'T&M', 'OPEN', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '0.00', '6.00', '0', '');
INSERT INTO `po_info` VALUES ('15', '1', '10001', 'wechat', '2019-05-28 13:32:19', '2019-07-23 00:00:00', '2019-05-28 11:30:01', '2019-05-28 11:30:01', '-1', '-1', '1000000001', '微信项目', 'FIXED PRICE', 'OPEN', '500.00', '100000.00', '125000.00', '25000.00', '100000.00', '300.00', '200.00', '25.00', '0', 'daimler的微信项目');
INSERT INTO `po_info` VALUES ('16', '1', '10001', 'middleware', '2019-05-28 13:32:46', '2019-06-14 00:00:00', '2019-05-28 11:37:50', '2019-05-28 11:37:50', '-1', '-1', '1000000002', '中间件项目', 'FIXED PRICE', 'OPEN', '600.00', '100000.00', '125000.00', '25000.00', '100000.00', '120.00', '480.00', '25.00', '0', 'daimler的中间件项目');
INSERT INTO `po_info` VALUES ('17', '1', '10001', 'above&beyond', '2019-05-28 13:33:26', '2019-05-30 00:00:00', '2019-05-28 11:45:55', '2019-05-28 17:03:50', '-1', '-1', '1000000003', '积分商城', 'FIXED PRICE', 'OPEN', '320.00', '104000.00', '130000.00', '37750.00', '92250.00', '151.00', '169.00', '25.00', '0', 'daimler的积分商城项目');
INSERT INTO `po_info` VALUES ('25', '1', '10001', 'test1', '2019-05-01 00:00:00', '2019-05-15 00:00:00', '2019-05-28 00:00:00', '2019-05-28 13:49:03', '-1', '-1', '1000000004', '测试用', 'FIXED PRICE', 'selected', '10.00', '1.00', '1.25', '0.50', '0.75', '5.00', '5.00', '25.00', '0', '阿萨德萨达');

-- ----------------------------
-- Table structure for project_info
-- ----------------------------
DROP TABLE IF EXISTS `project_info`;
CREATE TABLE `project_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DELETE_FLAG` bigint(20) NOT NULL DEFAULT '1' COMMENT '删除状态',
  `ACCOUNT` varchar(50) NOT NULL COMMENT '珊瑚岛',
  `CODE` bigint(20) NOT NULL COMMENT 'CODE',
  `PROJECT_NAME` varchar(50) NOT NULL COMMENT '项目名称',
  `PROJECT_COMMENT` varchar(50) DEFAULT NULL COMMENT '项目备注',
  `PROJECT_EM` varchar(20) NOT NULL COMMENT '项目经理',
  `PROJECT_DM` varchar(20) NOT NULL COMMENT '项总监',
  `PROJECT_DESC` varchar(255) DEFAULT NULL COMMENT '项目描述',
  `START_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '项目开始时间',
  `END_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '项目结束时间',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `LASTUPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `CREAT_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者',
  `LASTUPDATE_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新者',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_info
-- ----------------------------
INSERT INTO `project_info` VALUES ('1', '1', 'sfs', '64123', 'vv', '分个34wwfw2sddss', 'v', '242', '分好', '2018-12-06 12:46:32', '2018-12-29 00:00:00', '2018-12-05 23:54:23', '2018-12-05 23:54:23', '-1', '-1');
INSERT INTO `project_info` VALUES ('8', '1', 'Daimler', '10001', 'WeChat', '暂无备注', 'Lisi', 'Lisi', 'daimler', '2016-01-03 00:00:00', '2020-01-01 00:00:00', '2016-01-03 11:17:54', '2019-05-28 11:17:54', '-1', '-1');

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `DELETE_FLAG` bigint(20) NOT NULL DEFAULT '1' COMMENT '删除状态',
  `PO_ROLE` varchar(50) NOT NULL COMMENT '项目成员角色',
  `TOTAL_AMOUNT_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '总金额（含税）',
  `TOTAL_AMOUNT_EX` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '总数字（不含税）',
  `BURNED_AMOUNT_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '已消耗数字（含税）',
  `BURNED_AMOUNT_EX` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '已消耗数字（不含税）',
  `BALANCE_AMOUNT_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '剩余数字（含税）',
  `BALANCE_AMOUNT_EX` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '剩余数字（不含税）',
  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `LASTUPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
  `CREAT_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建者',
  `LASTUPDATE_BY` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新者',
  `RATE_IN` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '人天单价（含税）',
  `RATE_EX` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '人天单价（不含税）',
  `BILLABLE_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT 'ROLE总人天',
  `BURNED_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '已用人天',
  `PO_ID` bigint(20) NOT NULL COMMENT 'PO主表ID',
  `ROLE_COMMENT` varchar(255) NOT NULL DEFAULT '无' COMMENT 'role备注',
  `START_DATE` datetime NOT NULL,
  `END_DATE` datetime NOT NULL,
  `BALANCE_MANDAY` float(8,2) NOT NULL DEFAULT '0.00' COMMENT '已用人天',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('21', '1', 'java', '10000.00', '0.00', '2000.00', '0.00', '8000.00', '0.00', '2019-05-28 15:45:18', '2019-05-28 17:03:50', '-1', '-1', '200.00', '0.00', '50.00', '10.00', '17', '123', '2019-05-28 08:00:00', '2019-05-30 08:00:00', '30.00');
INSERT INTO `role_info` VALUES ('22', '1', 'java13', '6000.00', '0.00', '2200.00', '0.00', '3800.00', '0.00', '2019-05-28 15:51:39', '2019-05-28 17:01:53', '-1', '-1', '200.00', '0.00', '30.00', '11.00', '17', '213', '2019-05-28 08:00:00', '2019-05-30 08:00:00', '19.00');
INSERT INTO `role_info` VALUES ('23', '1', 'jads', '3000.00', '0.00', '1000.00', '0.00', '2000.00', '0.00', '2019-05-28 15:53:19', '2019-05-28 15:53:19', '-1', '-1', '100.00', '0.00', '30.00', '10.00', '17', '213', '2019-05-28 08:00:00', '2019-05-30 08:00:00', '10.00');
