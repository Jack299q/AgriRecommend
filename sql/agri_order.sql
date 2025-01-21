/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : agri

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2025-01-21 15:50:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agri_order
-- ----------------------------
DROP TABLE IF EXISTS `agri_order`;
CREATE TABLE `agri_order` (
  `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_num` varchar(32) DEFAULT NULL COMMENT '订单号',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `total` decimal(10,0) DEFAULT NULL COMMENT '订单金额',
  `order_status` varchar(32) DEFAULT NULL COMMENT '订单状态',
  `payment_method` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` datetime DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of agri_order
-- ----------------------------
INSERT INTO `agri_order` VALUES ('6', 'so-1881604501119553536', '3', '0', '已付款', '微信', null, '2025-01-21 15:27:26', null, null);
INSERT INTO `agri_order` VALUES ('7', 'so-1881605063718211584', '3', '0', '已付款', '微信', null, '2025-01-21 15:29:40', null, null);
INSERT INTO `agri_order` VALUES ('8', 'so-1881605304009940992', '3', '0', '已付款', '微信', null, '2025-01-21 15:30:38', null, null);
INSERT INTO `agri_order` VALUES ('9', 'so-1881606241822728192', '2', '0', '已付款', '微信', null, '2025-01-21 15:34:21', null, null);
INSERT INTO `agri_order` VALUES ('10', 'so-1881607042611826688', '1', '0', '已付款', '微信', null, '2025-01-21 15:37:32', null, null);
