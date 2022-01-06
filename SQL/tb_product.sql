/*
Navicat MySQL Data Transfer

Source Server         : hk
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : dev_cloud_product

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-12-24 16:07:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `p_type` varchar(32) DEFAULT NULL COMMENT '商品类型',
  `p_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `p_price` varchar(255) DEFAULT NULL COMMENT '商品价格',
  `stock` int(11) DEFAULT NULL COMMENT '库存量',
  `c_time` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `up_time` varchar(64) DEFAULT NULL COMMENT '更新时间',
  `spare` int(4) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
