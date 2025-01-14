/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : agri

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2025-01-14 15:36:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agri_category
-- ----------------------------
DROP TABLE IF EXISTS `agri_category`;
CREATE TABLE `agri_category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of agri_category
-- ----------------------------
INSERT INTO `agri_category` VALUES ('1', '水果', null, null, null, null);
INSERT INTO `agri_category` VALUES ('2', '蔬菜', null, null, null, null);
INSERT INTO `agri_category` VALUES ('3', '禽畜肉蛋', null, null, null, null);
INSERT INTO `agri_category` VALUES ('4', '粮油米面', null, null, null, null);
