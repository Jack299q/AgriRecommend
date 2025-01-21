/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : agri

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2025-01-21 15:50:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agri_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `agri_orderitem`;
CREATE TABLE `agri_orderitem` (
  `order_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单明细id',
  `product_id` bigint DEFAULT NULL COMMENT '商品id',
  `order_id` bigint DEFAULT NULL COMMENT '订单id',
  `product_name` varchar(32) DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `quantity` int DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of agri_orderitem
-- ----------------------------
INSERT INTO `agri_orderitem` VALUES ('5', '1', '6', '车厘子', '99.00', '0');
INSERT INTO `agri_orderitem` VALUES ('6', '1', '7', '车厘子', '99.00', '0');
INSERT INTO `agri_orderitem` VALUES ('7', '1', '8', '车厘子', '99.00', '0');
INSERT INTO `agri_orderitem` VALUES ('8', '1', '9', '车厘子', '99.00', '0');
INSERT INTO `agri_orderitem` VALUES ('9', '1', '10', '车厘子', '99.00', '0');
