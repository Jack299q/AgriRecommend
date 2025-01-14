/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : agri

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2025-01-14 15:37:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agri_product
-- ----------------------------
DROP TABLE IF EXISTS `agri_product`;
CREATE TABLE `agri_product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `product_sn` varchar(32) DEFAULT NULL COMMENT '产品编码',
  `product_name` varchar(32) DEFAULT NULL COMMENT '产品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `stock` bigint DEFAULT NULL COMMENT '库存',
  `description` varchar(32) DEFAULT NULL COMMENT '商品描述',
  `category_id` bigint DEFAULT NULL COMMENT '类别id',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of agri_product
-- ----------------------------
INSERT INTO `agri_product` VALUES ('1', '1001', '车厘子', '99.00', '100', '脆甜多汁，新鲜', '1', null, null, null, null);
INSERT INTO `agri_product` VALUES ('2', '1002', '赣南脐橙', '12.00', '100', '皮薄，甜蜜', '1', null, null, null, null);
INSERT INTO `agri_product` VALUES ('3', '1003', '猕猴桃', '20.00', '100', '果实较大，风味浓甜可口，较耐贮藏', '1', null, null, null, null);
INSERT INTO `agri_product` VALUES ('4', '1004', '番石榴', '16.00', '100', '维生素高，清脆爽口', '1', null, null, null, null);
INSERT INTO `agri_product` VALUES ('5', '1005', '库尔勒香梨', '35.00', '100', '好吃，很甜', '1', null, null, null, null);
INSERT INTO `agri_product` VALUES ('6', '1006', '西红柿', '2.00', '100', '新鲜', '2', null, null, null, null);
INSERT INTO `agri_product` VALUES ('7', '1007', '茄子', '2.00', '100', '果色深柴，光泽好，果肉白色，品质好。', '2', null, null, null, null);
INSERT INTO `agri_product` VALUES ('8', '1008', '大白菜', '1.00', '100', '包心紧实，圆嫩饱满，叶片清脆，口味清甜', '2', null, null, null, null);
INSERT INTO `agri_product` VALUES ('9', '1009', '玉米', '3.00', '100', '可以生吃的水果玉米，脆甜多汁，清香弥漫', '2', null, null, null, null);
INSERT INTO `agri_product` VALUES ('10', '1010', '秋葵', '1.50', '100', '好吃不贵', '2', null, null, null, null);
INSERT INTO `agri_product` VALUES ('11', '1011', '土鸡蛋', '4.50', '100', '土鸡蛋清香且柔滑', '3', null, null, null, null);
INSERT INTO `agri_product` VALUES ('12', '1012', '羊肉', '45.00', '100', '肉质细嫩、无膻味', '3', null, null, null, null);
INSERT INTO `agri_product` VALUES ('13', '1013', '牛肉', '48.00', '100', '味道鲜美', '3', null, null, null, null);
INSERT INTO `agri_product` VALUES ('14', '1014', '鸭蛋', '5.40', '100', '品质优良', '3', null, null, null, null);
INSERT INTO `agri_product` VALUES ('15', '1015', '牛肉丸', '9.00', '100', '肉质厚实，口感好', '3', null, null, null, null);
INSERT INTO `agri_product` VALUES ('16', '1016', '花生油', '15.00', '100', '农家自榨新鲜花生油，原香', '4', null, null, null, null);
INSERT INTO `agri_product` VALUES ('17', '1017', '红薯粉条', '31.00', '100', '口感香甜，劲道十足', '4', null, null, null, null);
INSERT INTO `agri_product` VALUES ('18', '1018', '东北大米', '13.00', '500', '吉林天然有机大米', '4', null, null, null, null);
INSERT INTO `agri_product` VALUES ('19', '1019', '五常大米', '5.80', '500', '优质大米', '4', null, null, null, null);
INSERT INTO `agri_product` VALUES ('20', '1020', '玉米馒头', '2.10', '100', '精选优质原材料，经过精细工艺加工而成', '4', null, null, null, null);
