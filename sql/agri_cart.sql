/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : agri

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2025-01-14 15:36:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agri_cart
-- ----------------------------
DROP TABLE IF EXISTS `agri_cart`;
CREATE TABLE `agri_cart` (
  `cart_id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint DEFAULT NULL,
  `product_name` varchar(32) DEFAULT NULL,
  `category_name` varchar(32) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of agri_cart
-- ----------------------------
INSERT INTO `agri_cart` VALUES ('1', '1', '车厘子', '水果', '1', '1', null, null);
INSERT INTO `agri_cart` VALUES ('2', '2', '赣南脐橙', '水果', '1', '2', null, null);
INSERT INTO `agri_cart` VALUES ('3', '3', '猕猴桃', '水果', '2', '1', null, null);
INSERT INTO `agri_cart` VALUES ('4', '4', '番石榴', '水果', '3', '1', null, null);
