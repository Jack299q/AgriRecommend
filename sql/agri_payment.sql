/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : agri

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2025-01-21 15:50:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agri_payment
-- ----------------------------
DROP TABLE IF EXISTS `agri_payment`;
CREATE TABLE `agri_payment` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `total` decimal(10,0) DEFAULT NULL COMMENT '订单金额',
  `payment_method` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of agri_payment
-- ----------------------------
INSERT INTO `agri_payment` VALUES ('1', '3', '8', '0', '微信', null, null, null, null);
INSERT INTO `agri_payment` VALUES ('2', '2', '9', '0', '微信', null, null, null, null);
INSERT INTO `agri_payment` VALUES ('3', '1', '10', '0', '微信', null, null, null, null);
