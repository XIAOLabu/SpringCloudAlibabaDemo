/*
Navicat MySQL Data Transfer

Source Server         : hk
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : dev_cloud_product

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2021-12-24 16:07:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) NOT NULL COMMENT '业务订单号',
  `pay_order_id` varchar(255) DEFAULT NULL COMMENT '交易订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户标识',
  `p_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `p_price` varchar(255) DEFAULT NULL COMMENT '产品价格',
  `p_number` int(11) DEFAULT NULL COMMENT '产品数量',
  `p_id` int(11) DEFAULT NULL COMMENT '产品id',
  `c_time` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `up_time` varchar(64) DEFAULT NULL COMMENT '更新时间',
  `out_time` varchar(64) DEFAULT NULL COMMENT '取消时间',
  `spare` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
